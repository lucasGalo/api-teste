package com.galo.apiteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ApiTesteApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiTesteApplication.class, args);
  }

}
