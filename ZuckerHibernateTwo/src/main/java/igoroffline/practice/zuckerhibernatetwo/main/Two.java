package igoroffline.practice.zuckerhibernatetwo.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Two {

    private final CountryRepository repository;

    public Two(CountryRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void two() {
        log.info("--- INIT ---");
        read();
        log.info("--- END ---");
    }

    private void read() {
        log.info("repository.count()= {}", repository.count());
        final var germany = repository.findByCountryEqualsIgnoreCase("germany");
        log.info("germany= {}", germany);
    }
}
