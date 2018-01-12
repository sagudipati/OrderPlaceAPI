package com.shipt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SpringJDBCConfig {
 	 
 	
@Autowired
public DataSource dataSource;
 	 
 	
@Bean	
public JdbcTemplate jdbcTemplate() {
 	
JdbcTemplate jdbcTemplate = new JdbcTemplate();
 	
jdbcTemplate.setDataSource(dataSource);
 	
return jdbcTemplate;
 	
}
}
