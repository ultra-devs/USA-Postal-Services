package com.ultradev.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.ultradev.model.ZipCodeDetails;
import com.ultradev.service.ZipCodeDataFetchService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ZipCodeServiceController.class })
@AutoConfigureMockMvc
@EnableWebMvc
class ZipCodeServiceControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	ZipCodeDataFetchService zipCodeDataFetchService;
	@Test
	void testGetZipCodeDetails() throws Exception {
		ZipCodeDetails sampleZipCodeDetails = new ZipCodeDetails();
		sampleZipCodeDetails.setCountyName("test");
		sampleZipCodeDetails.setPlaceName("testplace");
		sampleZipCodeDetails.setStateCode("TE");
		sampleZipCodeDetails.setStateName("TEST State");
		when(zipCodeDataFetchService.processZipCodeDetails("123456")).thenReturn(sampleZipCodeDetails);
		org.springframework.test.web.servlet.RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/v1/zip/123456").accept(MediaType.APPLICATION_JSON)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());// success response

	}

}
