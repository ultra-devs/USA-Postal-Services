package com.ultradev.common.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	private Date timestamp;
	private String errorMessage; //
	private String details;
	private String category;
	private String transactionId;
	private String applicationErrorCode;
	private HttpStatus httpStatus;
	private int httpstatusCode;
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getHttpstatusCode() {
		return httpstatusCode;
	}

	public void setHttpstatusCode(int httpstatusCode) {
		this.httpstatusCode = httpstatusCode;
	}

	private String level;
	private String processingTier;
	private String requestpath;

	public ErrorDetails(String errorMessage, String details, String applicationErrorCode, String processingTier) {
		super();
		this.errorMessage = errorMessage;
		this.details = details;
		this.applicationErrorCode = applicationErrorCode;
		this.processingTier = processingTier;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getApplicationErrorCode() {
		return applicationErrorCode;
	}

	public void setApplicationErrorCode(String applicationErrorCode) {
		this.applicationErrorCode = applicationErrorCode;
	}
	

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getProcessingTier() {
		return processingTier;
	}

	public void setProcessingTier(String processingTier) {
		this.processingTier = processingTier;
	}

	public String getRequestpath() {
		return requestpath;
	}

	public void setRequestpath(String requestpath) {
		this.requestpath = requestpath;
	}

}