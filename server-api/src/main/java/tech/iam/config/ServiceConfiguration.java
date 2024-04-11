package tech.iam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import tech.iam.repository.SodaRepository;
import tech.iam.repository.UsersRepository;
import tech.iam.service.SodaJdbcService;
import tech.iam.service.SodaService;
import tech.iam.service.UserService;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UserService userService(UsersRepository usersRepository){
        return  new UserService(usersRepository);
    }

    @Bean
    public SodaService sodaService(SodaRepository sodaRepository){
        return new SodaService(sodaRepository);
    }

    @Bean
    public SodaJdbcService sodaJdbcService(JdbcTemplate jdbcTemplate){
        return new SodaJdbcService(jdbcTemplate);
    }
}
