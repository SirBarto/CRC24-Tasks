package tech.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tech.iam.config.ServiceConfiguration;
import tech.iam.controller.SodaController;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackageClasses = SodaController.class)
@Import({ServiceConfiguration.class})
public class ServerApiApplication {
    public static void main(String[] args) {
        System.out.println("CRC_2024");
        SpringApplication.run(ServerApiApplication.class, args);
    }
}