package igoroffline.practice.zuckerjooqninegenerator.main;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NineGenerator {

    private final NineDatasource nineDatasource;

    public NineGenerator(NineDatasource nineDatasource) {
        this.nineDatasource = nineDatasource;
    }

    @PostConstruct
    public void init() {
        log.info("--- INIT START ---");
        generate();
        log.info("--- INIT END ---");
    }

    public void generate() {
        final var configuration = new Configuration().withJdbc(
                        new Jdbc()
                                .withDriver("org.postgresql.Driver")
                                .withUrl(nineDatasource.url())
                                .withUser(nineDatasource.username())
                                .withPassword(nineDatasource.password()))
                .withGenerator(
                        new Generator().withDatabase(
                                        new Database().withName("org.jooq.meta.postgres.PostgresDatabase"))
                                .withTarget(new Target()
                                        .withPackageName("igoroffline.practice.zuckerjooqnine.generated")
                                        .withDirectory("ZuckerJooqNineGenerator/src/main/java")));

        try {
            GenerationTool.generate(configuration);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
