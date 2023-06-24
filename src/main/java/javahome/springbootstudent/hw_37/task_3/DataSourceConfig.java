package javahome.springbootstudent.hw_37.task_3;

//import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/hw_35";
    private static final String USERNAME = "pingwit";
    private static final String PASSWORD = "pingwit_password";

//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl(URL);
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        return dataSource;
//    }
}
