package com.praktika.zadanie2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Zadanie2Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Zadanie2Application.class);
		
		//profiles: 
		//	"fakedb" (simulates db by list)
		//	"postgres" (uses real db postgresql)
		//	"mysql" (uses real db mysql)
		application.setAdditionalProfiles("postgres");
		application.run(args);
		
	}

}
