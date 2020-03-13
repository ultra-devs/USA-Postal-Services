package com.ultradev.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.ultradev.common.exception.APIDataNotFoundException;

@RunWith(MockitoJUnitRunner.class)
class BaseControllerResponseBuilderTest {

	@Test
	void testBuildAppResponse_GoodResponse() throws APIDataNotFoundException {
		List<String> response= new ArrayList<>();
		BaseControllerResponseBuilder baseControllerResponseBuilder= new BaseControllerResponseBuilder();
		assertEquals(200, baseControllerResponseBuilder.buildAppResponse(response).getStatusCodeValue());
	}

	
}
