package igoroffline.practice.zuckerjdbcthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ZuckerJdbcThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuckerJdbcThreeApplication.class, args);
	}

}
