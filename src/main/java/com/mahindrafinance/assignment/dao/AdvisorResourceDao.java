package com.mahindrafinance.assignment.dao;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.AdvisorBookings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdvisorResourceDao {

    public abstract List<Advisor> getAllAdvisor();
    public abstract boolean validateUserExist(String userId);
    public abstract boolean validateAdvisorExist(String advisorId);
    public abstract void bookAdvisorSlot(String userId,String advisorId,String dateTime);
    public abstract List<AdvisorBookings> getAllBookings();


}
