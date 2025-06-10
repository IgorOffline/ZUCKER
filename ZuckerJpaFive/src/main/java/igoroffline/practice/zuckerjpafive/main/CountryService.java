package igoroffline.practice.zuckerjpafive.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    private final CountryRepository2 countryRepository2;

    public CountryService(CountryRepository countryRepository, CountryRepository2 countryRepository2) {
        this.countryRepository = countryRepository;
        this.countryRepository2 = countryRepository2;
    }

    @PostConstruct
    void init() {
        log.info("--- INIT ---");
        final var germanyString = "germany";
        final var germany = countryRepository.getCountryByCountryContainingIgnoreCase(germanyString);
        final var germany2 = countryRepository2.getCountryTemp();
        final var germany3 = countryRepository2.getCountryByCountryContainingIgnoreCase2(germanyString);
        final var germany4 = countryRepository2.getCountryCriteriaBuilderPractice();
        log.info("germany= {}", germany);
        log.info("germany2= {}", germany2);
        log.info("germany3= {}", germany3);
        log.info("germany4= {}", germany4);
        log.info("--- END ---");
    }
}
