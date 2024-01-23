package com.mahindrafinance.assignment.daoImpl;

import com.mahindrafinance.assignment.dao.AdvisorResourceDao;
import com.mahindrafinance.assignment.daoImpl.mapper.AdvisorBookingMapper;
import com.mahindrafinance.assignment.daoImpl.mapper.AdvisorDataMapper;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.AdvisorBookings;
import com.mahindrafinance.assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static com.mahindrafinance.assignment.constants.SQLQueryConstants.*;

@Component
public class AdvisorResourceDaoImpl implements AdvisorResourceDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Advisor> getAllAdvisor() {

        String query = GET_ALL_ADVISOR;

        List<Advisor> listOfAdvisor = namedParameterJdbcTemplate.query(query,new AdvisorDataMapper());

        return listOfAdvisor;
    }

    @Override
    public void bookAdvisorSlot(String userId, String advisorId, String dateTime) {

        String query = BOOK_SLOT;

        SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("BOOKING_ID", UUID.randomUUID())
                .addValue("ADVISOR_ID",advisorId)
                .addValue("USER_ID",userId)
                .addValue("BOOKING_TIME",dateTime);

        namedParameterJdbcTemplate.update(query,sps);

    }

    @Override
    public List<AdvisorBookings> getAllBookings() {

        String query = GET_ALL_BOOKINGS;

        List<AdvisorBookings> listOfAdvisorBooking = namedParameterJdbcTemplate.query(query,new AdvisorBookingMapper());

        return listOfAdvisorBooking;
    }

    @Override
    public boolean validateUserExist(String userId) {

        String query = GET_USER;

        SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("USERID",userId);

        String userName = namedParameterJdbcTemplate.query(query, sps, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    return rs.getString("NAME");
                }
                return "";
            }
        });

        if(!userName.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean validateAdvisorExist(String advisorId) {

        String query = GET_ADVISOR;

        SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("ADVISOR_ID",advisorId);

        String advisorName = namedParameterJdbcTemplate.query(query, sps, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    return rs.getString("NAME");
                }

                return "";
            }
        });
        if(!advisorName.isEmpty()){
            return true;
        }
        return false;
    }


}
