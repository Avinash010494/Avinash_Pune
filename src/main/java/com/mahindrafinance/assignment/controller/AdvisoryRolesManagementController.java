package com.mahindrafinance.assignment.controller;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.RegisterUserResponse;
import com.mahindrafinance.assignment.model.User;
import com.mahindrafinance.assignment.service.AdvisoryRolesManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

import static com.mahindrafinance.assignment.constants.AdvisoryURLConstants.*;

@RestController
public class AdvisoryRolesManagementController {

    @Autowired
    AdvisoryRolesManagementService managementService;


    @PostMapping(value = ADD_ADVISOR_URL)
    public ResponseEntity addAdvisor(@RequestBody Advisor advisor){

        managementService.addAdvisor(advisor);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = ADD_USER_URL)
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody User user){

        RegisterUserResponse response = managementService.registerUser(user);

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PostMapping(value = USER_LOGIN_URL)
    public ResponseEntity<RegisterUserResponse> userLogin(@RequestBody LoginRequest loginRequest) throws AuthenticationException {

        RegisterUserResponse response = managementService.userLogin(loginRequest);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}
