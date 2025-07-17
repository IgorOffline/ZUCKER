package igoroffline.practice.zuckerjooqninebackend.main;

import igoroffline.practice.zuckerjooqnine.generated.public_.tables.Country;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Strings;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NineRead {

    private final DSLContext dslContext;

    public NineRead(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @PostConstruct
    public void init() {
        log.info("--- INIT START ---");
        final var countries = dslContext.selectFrom(Country.COUNTRY).fetch();
        countries.forEach(country -> {
            if (Strings.CI.contains(country.getCountry(), "germany")) {
                log.info(country.getCountry());
            }
        });
        log.info("--- INIT END ---");
    }
}
