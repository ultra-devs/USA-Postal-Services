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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ultradev.model.StateZipAndCountyTracker;
import com.ultradev.service.ZipCountyDataFetchService;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ZipCountyServiceController.class })
@AutoConfigureMockMvc
@EnableWebMvc
class ZipCountyServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	ZipCountyDataFetchService zipCountyDataFetchService;
	@Test
	void test() throws Exception {
		when(zipCountyDataFetchService.processStateDetails("NJ")).thenReturn(new StateZipAndCountyTracker());
		org.springframework.test.web.servlet.RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/v1/zipcounty/count/NJ").accept(MediaType.APPLICATION_JSON)			
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
		
	}

}
