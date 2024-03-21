package com.fiap.tc5apipayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Tc5ApiPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tc5ApiPaymentsApplication.class, args);
	}
}
