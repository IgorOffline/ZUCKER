package igoroffline.practice.zuckerjooqone.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OneGenerator {

    private final OneDatasource oneDatasource;

    public OneGenerator(OneDatasource oneDatasource) {
        this.oneDatasource = oneDatasource;
    }

    @PostConstruct
    public void init() {
        //log.info("--- INIT START ---");
        //generate();
        //log.info("--- INIT END ---");
    }

    public void generate() {
        final var configuration = new Configuration().withJdbc(
                new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl(oneDatasource.url())
                        .withUser(oneDatasource.username())
                        .withPassword(oneDatasource.password()))
                .withGenerator(
                        new Generator().withDatabase(
                                new Database().withName("org.jooq.meta.postgres.PostgresDatabase"))
                                .withTarget(new Target()
                                        .withPackageName("igoroffline.practice.zuckerjooqone.generated")
                                        .withDirectory("src/main/java")));

        try {
            GenerationTool.generate(configuration);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
