package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model.UserRepository;

@Configuration
public class LoadUsers {
	
	private static final Logger log = LoggerFactory.getLogger(LoadUsers.class);
	
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository) {
		return args -> {
			log.info("adding user " + userRepository.save(new User("Dennis", "Savard")));
		};
	}

}
