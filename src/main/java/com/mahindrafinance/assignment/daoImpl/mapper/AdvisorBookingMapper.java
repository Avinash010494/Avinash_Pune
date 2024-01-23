package com.mahindrafinance.assignment.daoImpl.mapper;

import com.mahindrafinance.assignment.model.AdvisorBookings;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvisorBookingMapper implements ResultSetExtractor<List<AdvisorBookings>> {
    @Override
    public List<AdvisorBookings> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<AdvisorBookings> listOfBooking = new ArrayList<>();

        while(rs.next()){
            AdvisorBookings advisorBookings = new AdvisorBookings();
            advisorBookings.setAdvisorId(rs.getString("ADVISOR_ID"));
            advisorBookings.setBookingId(rs.getString("BOOKING_ID"));
            advisorBookings.setAdvisorName(rs.getString("ADVISOR_NAME"));
            advisorBookings.setAdvisorProfilePicUrl(rs.getString("Profile_Pic"));
            advisorBookings.setBookingTime(rs.getString("BOOKING_TIME"));
            listOfBooking.add(advisorBookings);
        }


        return listOfBooking;
    }
}
