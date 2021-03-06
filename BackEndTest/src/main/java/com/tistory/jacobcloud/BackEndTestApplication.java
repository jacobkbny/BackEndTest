package com.tistory.jacobcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@EnableJpaAuditing
public class BackEndTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndTestApplication.class, args);
	}

}
