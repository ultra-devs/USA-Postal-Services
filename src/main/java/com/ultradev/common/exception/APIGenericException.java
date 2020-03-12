package com.ultradev.common.exception;

public class APIGenericException extends Exception {

	private static final long serialVersionUID = 1L;
	String errorMessage;
	String details;
	String applicationErrorCode;
	String processingTier;
	
	
	public APIGenericException(String errorMessage, String details, String applicationErrorCode,
			String processingTier) {
		super();
		this.errorMessage = errorMessage;
		this.details = details;
		this.applicationErrorCode = applicationErrorCode;
		this.processingTier = processingTier;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getApplicationErrorCode() {
		return applicationErrorCode;
	}
	public void setApplicationErrorCode(String applicationErrorCode) {
		this.applicationErrorCode = applicationErrorCode;
	}
	public String getProcessingTier() {
		return processingTier;
	}
	public void setProcessingTier(String processingTier) {
		this.processingTier = processingTier;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
