package com.ultradev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ultradev.common.exception.APIDataNotFoundException;

public class BaseControllerResponseBuilder {

	public <T> org.springframework.http.ResponseEntity<T> buildAppResponse(T listResponse)
			throws APIDataNotFoundException {
		return new ResponseEntity<T>(listResponse, HttpStatus.OK);
	}
}
