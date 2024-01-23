package com.mahindrafinance.assignment.util;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.User;

public class RequestsValidatorUtil {

    public static void validateLoginRequest(LoginRequest loginRequest) {

        if(loginRequest.getUserEmail().isEmpty() || loginRequest.getUserPassword().isEmpty()){
            throw new IllegalArgumentException();
        }

    }

     public static void validateRegisterUserRequest(User user) {

        if(user.getUserEmail().isEmpty() || user.getUserName().isEmpty() || user.getUserPassword().isEmpty()){
            throw new IllegalArgumentException();
        }

    }

    public static void validateRequest(Advisor advisor) {

        if(advisor.getAdvisorName().isEmpty() || advisor.getAdvisorProfilePicUrl().isEmpty()){
            throw new IllegalArgumentException();
        }

    }

}
