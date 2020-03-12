package com.ultradev.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultradev.model.User;
import com.ultradev.util.ApplicationConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;

/*@CrossOrigin(origins = "http://localhost", maxAge = 15)
@RestController
@RequestMapping("/user")*/

@RestController
@RequestMapping(ApplicationConstants.BASE_PATH_TOEKN)
@Api(description = ApplicationConstants.SWAGGER_CAT_DESCRIPTION_AUTH, produces = ApplicationConstants.SWAGGER_CONTENT_DESCRIPTION, tags = ApplicationConstants.SWAGGER_TAG_DESCRIPTION_AUTH)

public class AuthController {

	@Value("${secure.service.token.age:0}")
	long tokenExpirationTimeInSeconds;

	@Value("${secure.service.user}")
	String authuser;

	@Value("${secure.service.password}")
	String authpassword;

	@PostMapping("/token")
	public TokenResponse login(@RequestBody User loginUser) throws Exception {
		String jwtToken = "";
		TokenResponse tokenResponse = new TokenResponse();
		if (loginUser.getUserId() != null && loginUser.getUserId().equals(authuser) && loginUser.getPassword() != null
				&& loginUser.getPassword().equals(authuser)) {

			long expiration = tokenExpirationTimeInSeconds * 1000;
			Date ExpirationDate = new Date(System.currentTimeMillis() + expiration);
			jwtToken = Jwts.builder().setSubject(loginUser.getUserId()).claim("roles", "user").setIssuedAt(new Date())
					.setExpiration(ExpirationDate).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			
			tokenResponse.setToken(jwtToken);
			tokenResponse.setUserName(loginUser.getUserId());
			tokenResponse.setTokenExpirationTimeStamp(ExpirationDate);
		} else {
			throw new RuntimeException("Invalid User/Password :" + loginUser.getUserId());
		}
		return tokenResponse;
	}

	class TokenResponse {

		String token;
		String userName;
		Date tokenExpirationTimeStamp;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Date getTokenExpirationTimeStamp() {
			return tokenExpirationTimeStamp;
		}

		public void setTokenExpirationTimeStamp(Date tokenExpirationTimeStamp) {
			this.tokenExpirationTimeStamp = tokenExpirationTimeStamp;
		}

	}

}
