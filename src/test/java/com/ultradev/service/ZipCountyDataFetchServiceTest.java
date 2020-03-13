package com.ultradev.service;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ultradev.common.exception.APIDataNotFoundException;
import com.ultradev.dao.entity.ZipCodeInfo;
import com.ultradev.dao.repo.ZipCodeRepository;
import com.ultradev.model.StateZipAndCountyTracker;

@RunWith(MockitoJUnitRunner.class)
public class ZipCountyDataFetchServiceTest {

	@Mock
	ZipCodeRepository zipCodeRepository;
	@InjectMocks
	ZipCountyDataFetchService zipCountyDataFetchService;

	@Test
	public void testProcessStateDetails_norecord() throws APIDataNotFoundException {
		List<ZipCodeInfo> zipcodeInfoList = new ArrayList<>();
		when(zipCodeRepository.findByAdmincode1("NJ")).thenReturn(zipcodeInfoList);
		try {
			zipCountyDataFetchService.processStateDetails("NJ");
			fail("Empty Response");
		} catch (APIDataNotFoundException apiDataNotFoundException) {
			assertNotEquals(apiDataNotFoundException.getDetails(), null);
		}

	}

	@Test
	public void testProcessStateDetails_success() throws APIDataNotFoundException {
		List<ZipCodeInfo> zipcodeInfoList = new ArrayList<>();
		ZipCodeInfo sample = new ZipCodeInfo();
		sample.setPostalcode("08872");
		sample.setPlace("New Jersey");
		sample.setAdmincode1("NJ");
		sample.setAdminname1("New Jersey");
		zipcodeInfoList.add(sample);
		when(zipCodeRepository.findByAdmincode1("NJ")).thenReturn(zipcodeInfoList);

		StateZipAndCountyTracker processStateDetails = zipCountyDataFetchService.processStateDetails("NJ");
		assertEquals(sample.getAdmincode1(), processStateDetails.getStateCode());
	}

}
