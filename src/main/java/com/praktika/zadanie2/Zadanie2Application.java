package com.praktika.zadanie2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Zadanie2Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Zadanie2Application.class);
		application.setAdditionalProfiles("fakedb");
		application.run(args);
		
	}

}
