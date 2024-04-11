package tech.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tech.iam.config.PersistConfig;
import tech.iam.config.SecurityConfig;
import tech.iam.config.ServiceConfiguration;
import tech.iam.controller.SodaController;
import tech.iam.controller.UserController;
import tech.iam.entity.Soda;
import tech.iam.service.SodaJdbcService;
import tech.iam.service.SodaService;

import java.util.Optional;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackageClasses = {SodaController.class, UserController.class})
@Import({ServiceConfiguration.class, SecurityConfig.class, PersistConfig.class})
public class ServerApiApplication {
    public static void main(String[] args) {
        System.out.println("CRC_2024");
        SpringApplication.run(ServerApiApplication.class, args);
    }

    private final SodaService sodaService;
    private final SodaJdbcService sodaJdbcService;
    public ServerApiApplication(SodaService sodaService, SodaJdbcService sodaJdbcService) {
        this.sodaService = sodaService;
        this.sodaJdbcService = sodaJdbcService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        sodaService.safe();
        Optional<Soda> soda = sodaService.findSoda();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void countSoda(){
        sodaJdbcService.getSodaCount();
        sodaJdbcService.getSodaWithMapper();
    }



}