package com.mahindrafinance.assignment.daoImpl.mapper;

import com.mahindrafinance.assignment.model.Advisor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvisorDataMapper implements ResultSetExtractor<List<Advisor>> {
    @Override
    public List<Advisor> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Advisor> listOfAdvisor = new ArrayList<>();

        while(rs.next()){
            Advisor advisor = new Advisor();
            advisor.setAdvisorId(rs.getString("ID"));
            advisor.setAdvisorName(rs.getString("NAME"));
            advisor.setAdvisorProfilePicUrl(rs.getString("PROFILE_PIC"));
            listOfAdvisor.add(advisor);
        }

        return listOfAdvisor;
    }
}
