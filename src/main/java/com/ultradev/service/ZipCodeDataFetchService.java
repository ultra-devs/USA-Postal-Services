package com.ultradev.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.ultradev.common.exception.APIDataNotFoundException;
import com.ultradev.dao.entity.ZipCodeInfo;
import com.ultradev.dao.repo.ZipCodeRepository;
import com.ultradev.model.ZipCodeDetails;
import com.ultradev.util.ApiResponseMappingUtility;
import com.ultradev.util.LOG;

@Component
public class ZipCodeDataFetchService extends BaseDataRepositoryServices {

	Logger logger = LoggerFactory.getLogger(ZipCodeDataFetchService.class);
	@Autowired
	ZipCodeRepository ZipCodeRepository;
	final static String getZipCodeDetailsNoDataError = "No Records Found for Zip :"; // In case Used more consider
																						// moving a constant/enum

	/**
	 * Mar 12, 2020
	 * 
	 * @throws APIDataNotFoundException
	 * @uthor shashank
	 *
	 */
	public ZipCodeDetails processZipCodeDetails(String zipcode) throws APIDataNotFoundException {

		logger.info(LOG.FETCH_ZIP_CODE.val() + ":{}", zipcode);
		List<ZipCodeInfo> findByAdmincode1 = ZipCodeRepository.findByPostalcode(zipcode);
		verifyRepositoryResponseForNoDataReturn(findByAdmincode1, getZipCodeDetailsNoDataError + zipcode);
		Optional<ZipCodeInfo> zipCodeInfo = findByAdmincode1.stream().findFirst();// this should have only one record
																					// always
		// having fluid response mapping via bean mapping controlled by configuration
		ZipCodeDetails zipCodeDetails = projectResponse(zipCodeInfo.get(), new ZipCodeDetails());
		return zipCodeDetails;

	}

	/**
	 * 
	 * @param zipCodeInfo
	 * @param zipCodeDetails
	 * @return
	 */
	private ZipCodeDetails projectResponse(ZipCodeInfo zipCodeInfo, ZipCodeDetails zipCodeDetails) {
		return (ZipCodeDetails) ApiResponseMappingUtility.mapObject(zipCodeInfo, zipCodeDetails);
	}

}
