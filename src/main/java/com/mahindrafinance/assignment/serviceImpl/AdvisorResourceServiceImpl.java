package com.mahindrafinance.assignment.serviceImpl;

import com.mahindrafinance.assignment.dao.AdvisorResourceDao;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.AdvisorBookings;
import com.mahindrafinance.assignment.service.AdvisorResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorResourceServiceImpl implements AdvisorResourceService {

    @Autowired
    AdvisorResourceDao resourceDao;


    @Override
    public List<Advisor> getAllAdvisor(String userId) {
        validateUserExists(userId);
        List<Advisor> listOfAllAdvisors = resourceDao.getAllAdvisor();
        return listOfAllAdvisors;
    }

    @Override
    public void bookAdvisorSlot(String userId, String advisorId, String dateTime) {
        validateUserExists(userId);
        validateAdvisorExists(advisorId);
        resourceDao.bookAdvisorSlot(userId,advisorId,dateTime);

    }

    @Override
    public List<AdvisorBookings> getAllBookings(String userId) {
        validateUserExists(userId);
        List<AdvisorBookings> listOfAllBookings = resourceDao.getAllBookings();
        return listOfAllBookings;
    }

    private void validateAdvisorExists(String advisorId) {

        if(!resourceDao.validateAdvisorExist(advisorId)){
            throw new IllegalArgumentException();
        }

    }

    private void validateUserExists(String userId) {

        if(!resourceDao.validateUserExist(userId)){
            throw new IllegalArgumentException();
        }

    }
}
