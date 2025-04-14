package sample.cafekiosk.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Spring Boot 애플리케이션에서 JPA Auditing을 활성화하기 위한 어노테이션
@EnableJpaAuditing
@SpringBootApplication
public class CafekioskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafekioskApplication.class, args);
    }

}
