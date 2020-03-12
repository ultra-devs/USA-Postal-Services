package com.ultradev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultradev.model.StateZipAndCountyTracker;
import com.ultradev.service.ZipCountyDataFetchService;
import com.ultradev.util.ApplicationConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApplicationConstants.BASE_PATH)
@Api(description = ApplicationConstants.SWAGGER_CAT_DESCRIPTION_COUNTY, produces = ApplicationConstants.SWAGGER_CONTENT_DESCRIPTION, tags = ApplicationConstants.SWAGGER_TAG_DESCRIPTION_COUNTY)

public class ZipCountyServiceController extends BaseControllerResponseBuilder {

	@Autowired
	ZipCountyDataFetchService zipCountyDataFetchService; // in case more dependency use constructor injection

	/**
	 * 
	 * Mar 11, 2020
	 * 
	 * @uthor shashank
	 *
	 */
	@GetMapping("/zipcounty/count/{state}")
	@ApiOperation(value = "State Details", notes = "County/Postal code Overview Based on State Name")
	public ResponseEntity<StateZipAndCountyTracker> getstateDetails(@PathVariable("state") String state)
			throws Exception {
		return (ResponseEntity<StateZipAndCountyTracker>) buildAppResponse(
				zipCountyDataFetchService.processStateDetails(state));
	}

}
