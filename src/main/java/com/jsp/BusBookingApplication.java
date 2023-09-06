package com.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BusBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingApplication.class, args);
		System.out.println(Thread.currentThread().getName());
	}

}
