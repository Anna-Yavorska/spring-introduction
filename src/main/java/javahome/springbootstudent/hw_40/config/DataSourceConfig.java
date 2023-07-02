package javahome.springbootstudent.hw_40.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${db.url}")
    private String URL;
    @Value("${db.user_name}")
    private String USER_NAME;
    @Value("${db.password}")
    private String PASSWORD;

    @Bean
    public DataSource createDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USER_NAME);
        ds.setPassword(PASSWORD);
        return ds;
    }
}
