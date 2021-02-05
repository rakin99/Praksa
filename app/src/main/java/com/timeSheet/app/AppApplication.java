package com.timeSheet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.timeSheet.modelDB")
@EnableJpaRepositories("com.timeSheet.repository")
@ComponentScan(basePackages = {"com.timeSheet.controller","com.timeSheet.service","com.timeSheet.config","com.timeSheet.repository"})
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
