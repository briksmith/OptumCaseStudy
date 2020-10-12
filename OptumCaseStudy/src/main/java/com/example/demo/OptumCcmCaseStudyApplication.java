package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import model.UserRepository;

@SpringBootApplication()
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class OptumCcmCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptumCcmCaseStudyApplication.class, args);
	}

}
