package tn.portfolio.portofolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PortofolioApplication {


    public static void main(String[] args) {
        SpringApplication.run(PortofolioApplication.class, args);
    }

}
