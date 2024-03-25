package tech.iam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import tech.iam.repository.SodaRepository;
import tech.iam.service.SodaJdbcService;
import tech.iam.service.SodaService;

@Configuration
public class ServiceConfiguration {

    @Bean
    public SodaService sodaService(SodaRepository sodaRepository){
        return new SodaService(sodaRepository);
    }

    @Bean
    public SodaJdbcService sodaJdbcService(JdbcTemplate jdbcTemplate){
        return new SodaJdbcService(jdbcTemplate);
    }
}
