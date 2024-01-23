package com.mahindrafinance.assignment.daoImpl;

import com.mahindrafinance.assignment.dao.AdvisoryRolesManagementDao;
import com.mahindrafinance.assignment.model.Advisor;
import com.mahindrafinance.assignment.model.LoginRequest;
import com.mahindrafinance.assignment.model.RegisterUserResponse;
import com.mahindrafinance.assignment.model.User;
import com.mahindrafinance.assignment.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static com.mahindrafinance.assignment.constants.SQLQueryConstants.*;

@Component
public class AdvisoryRolesManagementDaoImpl implements AdvisoryRolesManagementDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addAdvisory(Advisor advisor) {
        String query = ADD_ADVISOR;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("ID", UUID.randomUUID())
                .addValue("NAME",advisor.getAdvisorName())
                .addValue("URL",advisor.getAdvisorProfilePicUrl());
        namedParameterJdbcTemplate.update(query,sqlParameterSource);
    }

    @Override
    public RegisterUserResponse registerUser(User user) {

        String query = ADD_USER;
        UUID userId = UUID.randomUUID();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("ID",userId)
                .addValue("NAME",user.getUserName())
                .addValue("EMAIL",user.getUserEmail())
                .addValue("PASSWORD",user.getUserPassword());

        namedParameterJdbcTemplate.update(query,sqlParameterSource);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(userId.toString());
        response.setJwtToken(JWTUtil.generateToken(userId.toString()));


        return response;
    }

    @Override
    public RegisterUserResponse userLogin(LoginRequest loginRequest) throws AuthenticationException {

        String query = LOGIN_USER;

        RegisterUserResponse response = new RegisterUserResponse();

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("EMAIL",loginRequest.getUserEmail())
                .addValue("PASSWORD",loginRequest.getUserPassword());

        String userId = namedParameterJdbcTemplate.query(query, sqlParameterSource, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    return rs.getString("ID");
                }
                return "";
            }
        });

        if(userId.isEmpty()){
            throw new AuthenticationException();
        }
        response.setUserId(userId);
        response.setJwtToken(JWTUtil.generateToken(userId));
        return response;
    }

}
