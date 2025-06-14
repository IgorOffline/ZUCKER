package igoroffline.practice.zuckermybatiseight.main.mappers;

import igoroffline.practice.zuckermybatiseight.main.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountryMapper {

    @Select("SELECT country_id AS id FROM country WHERE country_id = 38")
    Integer findCountryId();

    @Select("SELECT country_id AS id, country, last_update AS lastUpdate FROM country WHERE country_id BETWEEN 28 AND 34")
    List<Country> findCountriesSubset();
}
