package igoroffline.practice.zuckerjooqone.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Hello {

    @PostConstruct
    public void init() {
        log.info("--- INIT START ---");
        hello();
        log.info("--- INIT END ---");
    }

    public void hello() {
        final var configuration = new Configuration().withJdbc(
                new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl("jdbc:postgresql://localhost:5432/first")
                        .withUser("REPLACE_WITH_ACTUAL_USERNAME")
                        .withPassword("REPLACE_WITH_ACTUAL_PASSWORD"))
                .withGenerator(
                        new Generator().withDatabase(
                                new Database().withName("org.jooq.meta.postgres.PostgresDatabase"))
                                .withTarget(new Target()
                                        .withPackageName("igoroffline.practice.zuckerjooqone.main.generated")
                                        .withDirectory("src/main/java/igoroffline/practice/zuckerjooqone/main/generated")));

        try {
            GenerationTool.generate(configuration);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
