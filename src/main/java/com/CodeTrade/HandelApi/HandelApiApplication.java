package com.CodeTrade.HandelApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class HandelApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(HandelApiApplication.class, args);
	}
}
