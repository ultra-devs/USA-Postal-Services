package com.ultradev.service;

import java.util.List;

import com.ultradev.common.exception.APIDataNotFoundException;
import com.ultradev.util.ApplicationConstants;

public class BaseDataRepositoryServices {
	/**
	 * 
	 * Mar 12, 2020
	 * 
	 * @uthor shashank
	 *
	 */
	private static final String DB_DNF_MSG = "Data Not Found";
	private static final String DB_DNF_CAT = "Data-layer";

	protected <T> void verifyRepositoryResponseForNoDataReturn(List<T> apiResponse, String failureMessage)
			throws APIDataNotFoundException {
		if (apiResponse == null || apiResponse.isEmpty())
			throw new APIDataNotFoundException(DB_DNF_MSG, failureMessage, ApplicationConstants.DB_LOOKUP_FAILED,
					DB_DNF_CAT);

	}

}
