package tech.iam.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tech.iam.entity.Soda;
import tech.iam.mapper.SodaRowMapper;

@Service
public class SodaJdbcService {

    private final static String query = "SELECT * FROM SODA WHERE id_soda = ?";
    private final JdbcTemplate jdbcTemplate;

    public SodaJdbcService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getSodaCount(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM SODA", Integer.class);
    }

    public Soda getSodaWithMapper(){
        int id =2;
        return jdbcTemplate.queryForObject(query, new SodaRowMapper(), id);
    }

}
