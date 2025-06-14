package igoroffline.practice.zuckerjpaseven.main;

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
    public void init() {
        log.info("--- INIT ---");
        final var country = QCountry.country1;
        final var between = country.id.between(28, 34);
        final var countries = countryRepository.findAll(between);
        log.info("countries= {}", countries);
        log.info("--- END ---");
    }
}
