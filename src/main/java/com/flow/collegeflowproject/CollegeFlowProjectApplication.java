package com.flow.collegeflowproject;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.TimeZone;

@EnableEurekaServer
@SpringBootApplication
@EnableKafka
//(scanBasePackages={"com.collegeclassroom.*"})
/*@EnableJpaRepositories("com.collegeclassroom.repository.*")
@ComponentScan({"com.collegeclassroom.*"})
@EntityScan("com.collegeclassroom.db.*") */
public class CollegeFlowProjectApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Fortaleza"));
    }

    public static void main(String[] args) {
        SpringApplication.run(CollegeFlowProjectApplication.class, args);
    }

}
