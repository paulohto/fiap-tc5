package com.fiap.tc5apicarts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Tc5ApiCartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tc5ApiCartsApplication.class, args);
	}

}
