package com.mahindrafinance.assignment.controller;

import com.google.gson.Gson;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static com.mahindrafinance.assignment.constants.AdvisoryURLConstants.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = AdvisoryRolesManagementController.class)
public class AdvisoryRolesManagementControllerTest {

    MockMvc mockMvc;
    private Gson gson;

    @InjectMocks
    AdvisoryRolesManagementController managementController;

    @Before
    public void setup() throws IOException{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(managementController).build();
        gson = new Gson();
    }

    @Test
    public void addAdvisorTest() throws Exception {
        Advisor advisor = new Advisor();
        advisor.setAdvisorId("TestId");
        advisor.setAdvisorName("TestName");
        advisor.setAdvisorProfilePicUrl("TestUrl");

        mockMvc.perform(MockMvcRequestBuilders.post(ADD_ADVISOR_URL)
                .content(gson.toJson(advisor))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        );

    }

    @Test
    public void addUserTest() throws Exception {
        User user = new User();
        user.setUserName("TestUser");
        user.setUserEmail("TestEmail");
        user.setUserPassword("TestPassword");
        user.setUserId("TestUserId");

        mockMvc.perform(MockMvcRequestBuilders.post(ADD_USER_URL)
                .content(gson.toJson(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        );

    }

    @Test
    public void loginTest() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("TestUserEmail");
        loginRequest.setUserPassword("TestPassword");

        mockMvc.perform(MockMvcRequestBuilders.post(USER_LOGIN_URL)
                .content(gson.toJson(loginRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        );

    }

}
