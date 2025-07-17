package igoroffline.practice.zuckerjooqninegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ZuckerJooqNineGenerator {

    public static void main(String[] args) {
        SpringApplication.run(ZuckerJooqNineGenerator.class, args);
    }

}
