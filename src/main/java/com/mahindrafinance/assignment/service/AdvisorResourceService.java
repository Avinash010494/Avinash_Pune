package com.mahindrafinance.assignment.service;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.AdvisorBookings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdvisorResourceService {

    public abstract List<Advisor> getAllAdvisor(String userId);
    public abstract void bookAdvisorSlot(String userId,String advisorId,String dateTime);

    public abstract List<AdvisorBookings> getAllBookings(String userId);
}
