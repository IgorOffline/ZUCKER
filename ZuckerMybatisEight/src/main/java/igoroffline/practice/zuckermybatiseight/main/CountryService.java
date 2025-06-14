package igoroffline.practice.zuckermybatiseight.main;

import igoroffline.practice.zuckermybatiseight.main.mappers.CountryMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CountryService {

    private final CountryMapper countryMapper;

    public CountryService(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @PostConstruct
    public void init() {
        log.info("--- INIT ---");
        final var id = countryMapper.findCountryId();
        log.info("id= {}", id);
        final var countries = countryMapper.findCountriesSubset();
        log.info("countries= {}", countries);
        log.info("--- END ---");
    }
}
