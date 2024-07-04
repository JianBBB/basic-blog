package dev.danny.basicblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BasicblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicblogApplication.class, args);
    }

}
