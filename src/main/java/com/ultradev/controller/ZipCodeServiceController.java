package com.ultradev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultradev.model.ZipCodeDetails;
import com.ultradev.service.ZipCodeDataFetchService;
import com.ultradev.util.ApplicationConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApplicationConstants.BASE_PATH)
@Api(description = ApplicationConstants.SWAGGER_CAT_DESCRIPTION_ZIP, produces = ApplicationConstants.SWAGGER_CONTENT_DESCRIPTION, tags = ApplicationConstants.SWAGGER_TAG_DESCRIPTION_ZIP)

public class ZipCodeServiceController extends BaseControllerResponseBuilder {
	@Autowired
	ZipCodeDataFetchService zipCodeDataFetchService; // in case more dependency use constructor injection

	/**
	 * 
	 * Mar 11, 2020
	 * 
	 * @uthor shashank
	 *
	 */
	@GetMapping("/zip/{zipcode}")
	@ApiOperation(value = "Zip Code Lookup ", notes = "Return Place Details based on Zip Code")
	public ResponseEntity<ZipCodeDetails> getZipCodeDetails(@PathVariable("zipcode") String zipcode) throws Exception {
		return (ResponseEntity<ZipCodeDetails>) buildAppResponse(
				zipCodeDataFetchService.processZipCodeDetails(zipcode));
	}
}
