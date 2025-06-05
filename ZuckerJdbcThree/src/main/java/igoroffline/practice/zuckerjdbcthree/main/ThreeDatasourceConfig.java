package igoroffline.practice.zuckerjdbcthree.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ThreeDatasourceConfig {

    private final ThreeDatasource threeDatasource;

    public ThreeDatasourceConfig(ThreeDatasource threeDatasource) {
        this.threeDatasource = threeDatasource;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(threeDatasource.url());
        dataSource.setUsername(threeDatasource.username());
        dataSource.setPassword(threeDatasource.password());

        return dataSource;
    }
}
