package com.mahindrafinance.assignment.service;

import com.mahindrafinance.assignment.dao.AdvisoryRolesManagementDao;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.RegisterUserResponse;
import com.mahindrafinance.assignment.model.User;
import com.mahindrafinance.assignment.serviceImpl.AdvisoryRolesManagmentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.naming.AuthenticationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdvisoryRolesManagementServiceTest {


    @InjectMocks
    AdvisoryRolesManagmentServiceImpl advisoryRolesManagmentService;

    @Mock
    AdvisoryRolesManagementDao rolesManagementDao;

    @Test
    public void addAdvisorTest(){
        Advisor advisor = new Advisor();
        advisor.setAdvisorId("TestId");
        advisor.setAdvisorName("TestName");
        advisor.setAdvisorProfilePicUrl("TestUrl");
        advisoryRolesManagmentService.addAdvisor(advisor);
    }

    @Test
    public void registerUserTest(){
        User user = new User();
        user.setUserId("testId");
        user.setUserEmail("testEmail");
        user.setUserPassword("testPassword");
        user.setUserName("testUserName");
        RegisterUserResponse response = new RegisterUserResponse();
        response.setJwtToken("TestJWTToken");
        response.setUserId("TestUser");

        when(rolesManagementDao.registerUser(any(User.class))).thenReturn(response);
        RegisterUserResponse registerUserResponse = advisoryRolesManagmentService.registerUser(user);

        assertThat(registerUserResponse!=null).isEqualTo(true);
    }

    @Test
    public void loginUserTest() throws AuthenticationException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserPassword("testPassword");
        loginRequest.setUserEmail("testUser");

        RegisterUserResponse response = new RegisterUserResponse();
        response.setJwtToken("TestJWTToken");
        response.setUserId("TestUser");

        when(rolesManagementDao.userLogin(any(LoginRequest.class))).thenReturn(response);
        RegisterUserResponse registerUserResponse = advisoryRolesManagmentService.userLogin(loginRequest);

        assertThat(registerUserResponse!=null).isEqualTo(true);
    }


}
