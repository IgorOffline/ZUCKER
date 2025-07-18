package igoroffline.practice.zuckerhibernatetwo.main;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByCountryEqualsIgnoreCase(String country);
}
