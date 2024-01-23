package com.mahindrafinance.assignment.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class H2DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource h2DataSource(){
        DataSourceBuilder<HikariDataSource> dataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        dataSourceBuilder.url("jdbc:h2:mem:mahindra");
        dataSourceBuilder.username("mahindra");
        dataSourceBuilder.password("mahindra");
        dataSourceBuilder.driverClassName("org.h2.Driver");
        return dataSourceBuilder.build();
    }

    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedJdbcTemplate (@Qualifier("dataSource") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
