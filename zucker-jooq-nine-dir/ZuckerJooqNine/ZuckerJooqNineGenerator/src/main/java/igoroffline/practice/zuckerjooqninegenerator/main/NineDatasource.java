package igoroffline.practice.zuckerjooqninegenerator.main;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
public record NineDatasource(String url, String username, String password) {
}
