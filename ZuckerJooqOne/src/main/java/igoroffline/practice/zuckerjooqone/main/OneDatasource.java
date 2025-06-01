package igoroffline.practice.zuckerjooqone.main;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
public record OneDatasource(String url, String username, String password) {
}
