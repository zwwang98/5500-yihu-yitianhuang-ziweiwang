package com.cs5500.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cs5500.fitness.model")
public class FitnessApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessApplication.class, args);
	}

}
