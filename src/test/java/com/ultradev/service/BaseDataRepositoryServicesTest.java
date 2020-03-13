package com.ultradev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ultradev.common.exception.APIDataNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class BaseDataRepositoryServicesTest {

	/*
	 * @Mock AssessmentManagementRepo assessmentManagementRepo;
	 * 
	 * @Mock FetchAllCaseAssessments fetchAllCaseAssessments;
	 */
	@InjectMocks
	BaseDataRepositoryServices baseDataRepositoryServices;

	@Test
	public void testVerifyRepositoryResponseForNoDataReturn() throws APIDataNotFoundException {
		List<String> sampleList = new ArrayList<>();
		String errorMessageString = "This list is empty";
		try {
			baseDataRepositoryServices.verifyRepositoryResponseForNoDataReturn(sampleList, errorMessageString);
			fail("This Case should have thrown exception");
		} catch (APIDataNotFoundException apiDataNotFoundException) {
			assertEquals(errorMessageString, apiDataNotFoundException.getDetails());

		}

	}

	@Test
	public void testVerifyRepositoryResponseForSuccessCase() throws APIDataNotFoundException {
		List<String> sampleList = new ArrayList<>();
		sampleList.add("sample");
		String errorMessageString = "This list is empty";
		try {
			baseDataRepositoryServices.verifyRepositoryResponseForNoDataReturn(sampleList, errorMessageString);

		} catch (APIDataNotFoundException apiDataNotFoundException) {
			fail("This Case sshould ");

		}

	}

}
