package com.ultradev.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ultradev.common.exception.APIDataNotFoundException;
import com.ultradev.dao.entity.ZipCodeInfo;
import com.ultradev.dao.repo.ZipCodeRepository;
import com.ultradev.model.StateZipAndCountyTracker;
import com.ultradev.util.LOG;

@Component
public class ZipCountyDataFetchService extends BaseDataRepositoryServices {
	@Autowired
	ZipCodeRepository ZipCodeRepository;
	final static String getstateDetailsNoDataError = "No Records Found for State :"; // In case Used more consider
																						// moving a constant/enum

	Logger logger = LoggerFactory.getLogger(ZipCountyDataFetchService.class);

	public StateZipAndCountyTracker processStateDetails(String state) throws APIDataNotFoundException {
		List<ZipCodeInfo> findByAdmincode = ZipCodeRepository.findByAdmincode1(state);
		logger.info(LOG.FETCH_STATE_DETAILS.val() + ":{}", state);
		verifyRepositoryResponseForNoDataReturn(findByAdmincode, getstateDetailsNoDataError + state);// custom error handling
		StateZipAndCountyTracker stateZipAndCountyTracker = new StateZipAndCountyTracker(
				findByAdmincode.parallelStream().map(z -> z.getAdminname1()).distinct().findFirst().get(), state,
				findByAdmincode.parallelStream().map(z -> z.getAdminname2()).distinct().count(),
				findByAdmincode.parallelStream().map(z -> z.getPostalcode()).distinct().count());
		return stateZipAndCountyTracker;
	}

}
