package tech.iam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties
public class SpringJdbcConfig {

    @Value("username")
    String username;

    @Bean
    public DataSource postgresDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5400/postgres");
        dataSource.setUsername("crc24");
        dataSource.setPassword("crc24");
        return dataSource;
    }
}
