package com.mahindrafinance.assignment.controller;

import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.AdvisorBookings;
import com.mahindrafinance.assignment.service.AdvisorResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mahindrafinance.assignment.constants.AdvisoryURLConstants.*;

@RestController
public class AdvisorResourceController {

    @Autowired
    AdvisorResourceService resourceService;


    @GetMapping(value = GET_LIST_OF_ADVISOR)
    public ResponseEntity<List<Advisor>> getListOfAdvisor(@PathVariable("userId") String userId){

        List<Advisor> listOfAdvisor = resourceService.getAllAdvisor(userId);

        return new ResponseEntity<>(listOfAdvisor, HttpStatus.OK);
    }

    @PostMapping(value = BOOK_ADVISOR_URL)
    public ResponseEntity bookAdvisorSlot(@PathVariable("userId") String userId, @PathVariable("advisorId") String advisorId, @RequestBody String dateTime){

        resourceService.bookAdvisorSlot(userId,advisorId,dateTime);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = GET_ALL_ADVISOR_BOOKING_URL)
    public ResponseEntity<List<AdvisorBookings>> getAllBookings(@PathVariable("userId") String userId){

        List<AdvisorBookings> listOfAll = resourceService.getAllBookings(userId);

        return new ResponseEntity<>(listOfAll,HttpStatus.OK);

    }

}
