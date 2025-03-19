package com.soft.technology.transactions_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class TransactionsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsManagementApplication.class, args);
	}

}
