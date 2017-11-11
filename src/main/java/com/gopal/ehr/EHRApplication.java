package com.gopal.ehr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//Patient Allergy

@SpringBootApplication
@ImportResource({ "classpath*:SpringJPA.xml" })
@ComponentScan({ "com.gopal.ehr" })
public class EHRApplication {

	public static void main(String[] args) {

		SpringApplication.run(EHRApplication.class, args);
	}
}
