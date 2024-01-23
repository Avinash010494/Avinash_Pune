package com.mahindrafinance.assignment.service;

import com.mahindrafinance.assignment.dao.AdvisorResourceDao;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.AdvisorBookings;
import com.mahindrafinance.assignment.serviceImpl.AdvisorResourceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdvisorResourceServiceTest {

    @InjectMocks
    AdvisorResourceServiceImpl resourceService;

    @Mock
    AdvisorResourceDao resourceDao;

    @Test
    public void getAllAdvisor(){

        List<Advisor> list = new ArrayList<>();
        Advisor advisor1=new Advisor();
        advisor1.setAdvisorProfilePicUrl("testUrl");
        advisor1.setAdvisorName("testName");
        advisor1.setAdvisorId("testId");
        list.add(advisor1);
        when(resourceDao.validateUserExist(anyString())).thenReturn(true);
        when(resourceService.getAllAdvisor(anyString())).thenReturn(list);
        List<Advisor> listOfAdvisor = resourceService.getAllAdvisor("testUserId");
        assertThat(listOfAdvisor.isEmpty()).isEqualTo(false);


    }

    @Test
    public void bookAdvisorSlotTest(){

        when(resourceDao.validateUserExist(anyString())).thenReturn(true);
        when(resourceDao.validateAdvisorExist(anyString())).thenReturn(true);
        resourceService.bookAdvisorSlot("testUser","testAdvisor","testDateTime");
    }

    @Test
    public void getAllBookingsTest(){

        List<AdvisorBookings> listOfAllBookings = new ArrayList<>();
        AdvisorBookings bookings=new AdvisorBookings();
        bookings.setBookingTime("testBooking");
        bookings.setBookingId("testBookingId");
        bookings.setAdvisorId("testAdvisorId");
        bookings.setAdvisorName("testAdvisorName");
        bookings.setAdvisorProfilePicUrl("testProfileUrl");
        listOfAllBookings.add(bookings);
        when(resourceDao.validateUserExist(anyString())).thenReturn(true);
        when(resourceDao.getAllBookings()).thenReturn(listOfAllBookings);
        List<AdvisorBookings> bookingsList=resourceDao.getAllBookings();
        assertThat(bookingsList.isEmpty()).isEqualTo(false);
    }

}
