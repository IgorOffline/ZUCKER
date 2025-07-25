package igoroffline.practice.zuckerjooqninebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ZuckerJooqNineBackend {

    public static void main(String[] args) {
        SpringApplication.run(ZuckerJooqNineBackend.class, args);
    }

}
