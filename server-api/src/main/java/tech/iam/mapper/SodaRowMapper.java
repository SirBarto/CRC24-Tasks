package tech.iam.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.iam.entity.Soda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SodaRowMapper implements RowMapper<Soda> {

    @Override
    public Soda mapRow(ResultSet rs, int rowNum) throws SQLException {
        Soda soda = new Soda();
        soda.setIdSoda(rs.getInt("id_soda"));
        soda.setName(rs.getString("name"));
        soda.setCode(rs.getString("code"));
        soda.setPrice(rs.getString("price"));
        return soda;
    }

}
