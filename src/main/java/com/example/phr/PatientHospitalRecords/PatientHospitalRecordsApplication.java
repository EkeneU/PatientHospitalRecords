package com.example.phr.PatientHospitalRecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.phr.PatientHospitalRecords")
public class PatientHospitalRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientHospitalRecordsApplication.class, args);
	}

}
