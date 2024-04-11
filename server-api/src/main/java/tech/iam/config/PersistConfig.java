package tech.iam.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tech.iam.entity.Authorities;
import tech.iam.repository.UsersRepository;

@Configuration
@EntityScan(basePackageClasses = {Authorities.class})
@EnableJpaRepositories(basePackageClasses = {UsersRepository.class})
@EnableTransactionManagement
public class PersistConfig {

}
