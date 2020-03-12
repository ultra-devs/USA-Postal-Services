package com.ultradev.common.exception;

import java.util.Date;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import com.ultradev.util.ApplicationConstants;

public class ExceptionUtility {

	final static String DEFAULT_CATEGORY="Application Error";
	public static ErrorDetails buildErrorDetailsEntity(APIGenericException exception, WebRequest request) {

		
		ErrorDetails errroDetails = new ErrorDetails(exception.getErrorMessage(), exception.getDetails(),
				exception.getApplicationErrorCode(), exception.getProcessingTier());
		errroDetails.setRequestpath(MDC.get(ApplicationConstants.REQUEST_URI_IDENTIFIER));
		return errroDetails;

	}

	public static ErrorDetails buildfalloutException(Exception exception, WebRequest request) {

		ErrorDetails errroDetails = new ErrorDetails(exception.getMessage(), exception.getLocalizedMessage(),
				"inter-001", "NA");
		errroDetails.setRequestpath(MDC.get(ApplicationConstants.REQUEST_URI_IDENTIFIER));
		return errroDetails;

	}

	public static void enhanceAPIDataNotFoundExceptionErrorDetail(ErrorDetails errroDetails) {
		errroDetails.setCategory(DEFAULT_CATEGORY);
		errroDetails.setHttpStatus(HttpStatus.NOT_FOUND);
		errroDetails.setHttpstatusCode(HttpStatus.NOT_FOUND.value());
		errroDetails.setTimestamp(new Date());
		errroDetails.setTransactionId(MDC.get(ApplicationConstants.TRANSACTION_ID_IDENTIFIER));
		errroDetails.setLevel("DataBase Lookup");
	}

}
