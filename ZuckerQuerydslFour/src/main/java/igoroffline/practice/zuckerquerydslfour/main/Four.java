package igoroffline.practice.zuckerquerydslfour.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Four {

    @PostConstruct
    public void init() {
        log.info("--- INIT ---");
        log.info("--- END ---");
    }
}
