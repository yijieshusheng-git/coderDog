package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MyFirstSpringBootAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyFirstSpringBootAppApplication.class, args);
		log.info("MyFirstSpringBootAppApplication starting...");
	}

}
