package com.duties.tat.controller;

import com.duties.tat.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserController userController;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testLogin() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // 로그인 요청에 사용할 사용자 정보 설정
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId("test");
        loginRequest.setPassword("test");

        // 로그인 요청 전송
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 반환된 JWT 토큰 확인
        String responseContent = mvcResult.getResponse().getContentAsString();
        System.out.println("JWT Token: " + responseContent);
    }
}