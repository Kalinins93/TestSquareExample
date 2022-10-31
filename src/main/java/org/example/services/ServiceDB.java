package org.example.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.Map;

@Service
public class ServiceDB {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(Map<String,String> allParams) throws SQLException {
        int res=  jdbcTemplate.update(
                "INSERT INTO variables VALUES(nextval('id_variable'),?, ?, ?)", allParams.get("a"), allParams.get("b"), allParams.get("c"));

    }
}
