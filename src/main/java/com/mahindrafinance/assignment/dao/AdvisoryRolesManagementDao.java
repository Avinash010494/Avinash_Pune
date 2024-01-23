package com.mahindrafinance.assignment.dao;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.RegisterUserResponse;
import com.mahindrafinance.assignment.model.User;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public interface AdvisoryRolesManagementDao {

    public abstract void addAdvisory(Advisor advisor);

    public abstract RegisterUserResponse registerUser(User user);

    public abstract RegisterUserResponse userLogin(LoginRequest loginRequest) throws AuthenticationException;

}
