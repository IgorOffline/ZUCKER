package igoroffline.practice.zuckerjpafive.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    void init() {
        log.info("--- INIT ---");
        final var germany = countryRepository.getCountryByCountryContainingIgnoreCase("germany");
        log.info("germany= {}", germany);
        log.info("--- END ---");
    }
}
