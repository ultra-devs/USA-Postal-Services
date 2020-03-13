package com.ultradev.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.ultradev.controller.AuthController.TokenResponse;
import com.ultradev.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AuthController.class })
@AutoConfigureMockMvc
@EnableWebMvc

class AuthControllerTest {
	@Autowired
	AuthController authController;
	@Test
	void testGenerateToken() throws Exception {
		User sampleUser = new User();
		sampleUser.setPassword("admin");
		sampleUser.setUserId("admin");
		TokenResponse mockResponse = authController.login(sampleUser);
		assertEquals("admin", mockResponse.getUserName());
	}

}
