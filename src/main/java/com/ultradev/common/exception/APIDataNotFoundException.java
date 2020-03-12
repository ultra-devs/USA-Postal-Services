package com.ultradev.common.exception;

public class APIDataNotFoundException extends APIGenericException {
	public APIDataNotFoundException(String errorMessage, String details, String applicationErrorCode,
			String processingTier) {
		super(errorMessage, details, applicationErrorCode, processingTier);
	}

	private static final long serialVersionUID = 2577367231656399112L;

	
}