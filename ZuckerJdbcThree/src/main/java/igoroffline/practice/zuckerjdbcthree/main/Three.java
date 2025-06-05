package igoroffline.practice.zuckerjdbcthree.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Slf4j
@Service
public class Three {

    private final DataSource dataSource;

    public Three(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() {
        log.info("--- INIT ---");
        three();
        log.info("--- END ---");
    }

    private void three() {
        final var jdbcTemplate = new JdbcTemplate(dataSource);
        final var countryCount = jdbcTemplate.queryForObject("SELECT COUNT('id_country') FROM public.country", Integer.class);
        log.info("countryCount= {}", countryCount);
        final var germanyId = jdbcTemplate.queryForObject("SELECT country_id FROM public.country WHERE country ILIKE 'germany'", Integer.class);
        log.info("germanyId= {}", germanyId);
        final var germany = jdbcTemplate.queryForObject("SELECT country_id, country, last_update FROM public.country WHERE country_id = ?",
                new CountryRowMapper(), germanyId);
        log.info("germany= {}", germany);
    }
}
