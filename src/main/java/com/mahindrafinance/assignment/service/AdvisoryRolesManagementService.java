package com.mahindrafinance.assignment.service;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.RegisterUserResponse;
import com.mahindrafinance.assignment.model.User;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public interface AdvisoryRolesManagementService {

    public abstract void addAdvisor(Advisor advisor);

    public abstract RegisterUserResponse registerUser(User user);

    public abstract RegisterUserResponse userLogin(LoginRequest loginRequest) throws AuthenticationException;

}
