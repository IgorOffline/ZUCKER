package igoroffline.practice.zuckerjpafive.main;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> getCountryByCountryContainingIgnoreCase(String country);
}
