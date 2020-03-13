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
import com.ultradev.model.ZipCodeDetails;

@RunWith(MockitoJUnitRunner.class)
public class ZipCodeDataFetchServiceTest {

	@Mock
	ZipCodeRepository zipCodeRepository;
	@InjectMocks
	ZipCodeDataFetchService zipCodeDataFetchService;
	private ZipCodeDetails zipCodeDetails;

	@Test
	public void testProcessZipCodeDetails_NoDataFound() throws APIDataNotFoundException {
		List<ZipCodeInfo> zipcodeInfoList = new ArrayList<>();
		System.out.println("zipCodeRepository " + zipCodeRepository);
		when(zipCodeRepository.findByPostalcode("08872")).thenReturn(zipcodeInfoList);
		try {
			zipCodeDetails = zipCodeDataFetchService.processZipCodeDetails("08872");
			fail("Empty Response");
		} catch (APIDataNotFoundException apiDataNotFoundException) {
			assertNotEquals(apiDataNotFoundException.getDetails(), null);
		}

	}

	@Test
	public void testProcessZipCodeDetails_success() throws APIDataNotFoundException {
		List<ZipCodeInfo> zipcodeInfoList = new ArrayList<>();
		ZipCodeInfo sample = new ZipCodeInfo();
		sample.setPostalcode("08872");
		sample.setPlace("New Jersey");
		sample.setAdmincode1("NJ");
		zipcodeInfoList.add(sample);

		when(zipCodeRepository.findByPostalcode("08872")).thenReturn(zipcodeInfoList);

		zipCodeDetails = zipCodeDataFetchService.processZipCodeDetails("08872");
		assertEquals(sample.getPlace(), zipCodeDetails.getPlaceName());

	}
}
