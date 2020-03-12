package com.ultradev.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	/***
	 * Checked User Error : GET API failed to fetch required Data
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(APIDataNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request) {
		// cast it
		APIGenericException apinotFoundexception = (APIGenericException) exception;
		ErrorDetails errorDetails = ExceptionUtility.buildErrorDetailsEntity(apinotFoundexception, request);
		ExceptionUtility.enhanceAPIDataNotFoundExceptionErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> falloutexceptionHandler(Exception exception, WebRequest request) {
		// cast it
		
		ErrorDetails errorDetails = ExceptionUtility.buildfalloutException(exception, request);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
