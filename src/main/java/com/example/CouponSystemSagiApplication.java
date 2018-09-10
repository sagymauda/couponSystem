package com.example;

import com.example.database.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouponSystemSagiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponSystemSagiApplication.class, args);
	}
}
