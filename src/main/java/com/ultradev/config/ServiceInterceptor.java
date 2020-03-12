package com.ultradev.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ultradev.util.ApplicationConstants;
import com.ultradev.util.LOG;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class ServiceInterceptor extends OncePerRequestFilter {
	private static Logger log = LoggerFactory.getLogger(ServiceInterceptor.class);

	@Value("${application.version}")
	String applicationVersion;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			if (isApiCallForServiceInterception(request)) {
				autherize(request, response, filterChain);
				String transactionId = generateRequestId(request);
				String hostName = getHostInfo(request);
				pushRequestURI(request);
				pushHost(hostName);
				pushVersion();
				StopWatch stopWatch = new StopWatch();
				stopWatch.start();
				// request - processor
				requestProcessor(response, transactionId);
				prePopulateResponseheader(transactionId, hostName, response);
				filterChain.doFilter(request, response);
				stopWatch.stop();
				responseProcessor(stopWatch, request, response, transactionId);
			} else {

				filterChain.doFilter(request, response);
			}

		} finally {
			MDC.clear();
		}

	}

	private void autherize(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		if (!ApplicationConstants.API_SECURITY_ENABLE)
			return;
		final String authHeader = request.getHeader("authorization");

		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(request, response);

		} else {

			
			if (authHeader == null) {
				throw new ServletException(
						"Missing or invalid Authorization header for Secured API :" + request.getRequestURI());
			}

			final String token = authHeader.toString();

			try {

				final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
				request.setAttribute("claims", claims);
			} catch (final SignatureException e) {
				throw new ServletException("Invalid token");
			}

			// filterChain.doFilter(request, response);
		}

	}

	private boolean isApiCallForServiceInterception(HttpServletRequest request) {

		if (request.getRequestURI().contains("/token"))
			return false;
		if (request.getRequestURI().contains(ApplicationConstants.BASE_PATH)) {
			return true;
		}
		return false;

	}

	private void pushRequestURI(HttpServletRequest request) {
		if (request != null) {
			log.debug("PUSHED URI :{}", request.getRequestURI());
			MDC.put(ApplicationConstants.REQUEST_URI_IDENTIFIER, request.getRequestURI());
		}

	}

	private void pushHost(String hostName) {
		try {

			log.debug("PUSHED HOST :{}", hostName);
			MDC.put(ApplicationConstants.HOST_IDENTIFIER, hostName);

		} catch (Exception e) {
			log.debug("HOST DETECTION API FAILED: {} ", e);
		}

	}

	private void pushVersion() {
		MDC.put(ApplicationConstants.APP_VERSION, applicationVersion);
	}

	private void requestProcessor(HttpServletResponse response, String transactionId)
			throws IOException, ServletException {

		String mdcData = String.format("%s", transactionId);
		log.info(LOG.API_TRANSACTION_ID.val()+":{}", mdcData);
		MDC.put(ApplicationConstants.TRANSACTION_ID_IDENTIFIER, mdcData); // Referenced

	}

	private void prePopulateResponseheader(String transactionId, String hostName, HttpServletResponse response) {
		// pre populating response header for trecibility
		response.addHeader(ApplicationConstants.TRANSACTION_ID_IDENTIFIER, transactionId);
		response.addHeader(ApplicationConstants.HOST_IDENTIFIER_TAG, hostName);

	}

	private void responseProcessor(StopWatch stopWatch, HttpServletRequest request, HttpServletResponse response,
			String transactionId) {
		log.info(ApplicationConstants.RESPONSE_TIME_IDENTIFIER + " :{}", stopWatch.toString());
		if (!response.containsHeader(ApplicationConstants.TRANSACTION_ID_IDENTIFIER)) {
			response.addHeader(ApplicationConstants.TRANSACTION_ID_IDENTIFIER, transactionId);
		}
	}

	private String generateRequestId(HttpServletRequest request) {
		String transactionId = null;

		transactionId = request.getHeader(ApplicationConstants.TRANSACTION_ID_IDENTIFIER);

		if (transactionId == null) {
			transactionId = UUID.randomUUID().toString();
		}

		// log.info("transaction id :{}",transactionId);
		return transactionId;
	}

	private String getHostInfo(HttpServletRequest request) {
		String hostName = request.getServerName();
		return hostName;
	}
}