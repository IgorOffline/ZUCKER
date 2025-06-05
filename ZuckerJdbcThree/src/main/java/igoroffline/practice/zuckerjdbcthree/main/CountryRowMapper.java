package igoroffline.practice.zuckerjdbcthree.main;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Country(
                rs.getInt(ThreeEntityNames.COUNTRY_COUNTRY_ID),
                rs.getString(ThreeEntityNames.COUNTRY_COUNTRY),
                rs.getTimestamp(ThreeEntityNames.COUNTRY_LAST_UPDATE).toLocalDateTime());
    }
}
