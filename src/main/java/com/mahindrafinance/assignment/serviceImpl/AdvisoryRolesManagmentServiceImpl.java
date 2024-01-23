package com.mahindrafinance.assignment.serviceImpl;

import antlr.StringUtils;
import com.mahindrafinance.assignment.dao.AdvisoryRolesManagementDao;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.RegisterUserResponse;
import com.mahindrafinance.assignment.model.User;
import com.mahindrafinance.assignment.service.AdvisoryRolesManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mahindrafinance.assignment.util.RequestsValidatorUtil;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AdvisoryRolesManagmentServiceImpl implements AdvisoryRolesManagementService {

    @Autowired
    AdvisoryRolesManagementDao rolesManagementDao;

    @Override
    public void addAdvisor(Advisor advisor) {

        RequestsValidatorUtil.validateRequest(advisor);
        rolesManagementDao.addAdvisory(advisor);

    }

    @Override
    public RegisterUserResponse registerUser(User user) {
        RequestsValidatorUtil.validateRegisterUserRequest(user);
        RegisterUserResponse response = rolesManagementDao.registerUser(user);

        return response;
    }

    @Override
    public RegisterUserResponse userLogin(LoginRequest loginRequest) throws AuthenticationException {
        RequestsValidatorUtil.validateLoginRequest(loginRequest);

        RegisterUserResponse response = rolesManagementDao.userLogin(loginRequest);

        return response;
    }




}
