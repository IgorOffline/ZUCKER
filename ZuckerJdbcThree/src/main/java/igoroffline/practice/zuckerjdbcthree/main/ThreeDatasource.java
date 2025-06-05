package igoroffline.practice.zuckerjdbcthree.main;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
public record ThreeDatasource(String url, String username, String password) {
}
