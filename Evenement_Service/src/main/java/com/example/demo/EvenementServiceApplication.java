package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EvenementRepository;

import com.example.demo.entities.Evenement;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableDiscoveryClient
@SpringBootApplication
public class EvenementServiceApplication implements CommandLineRunner{
	EvenementRepository event;

	public static void main(String[] args) {
		SpringApplication.run(EvenementServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Evenement E = Evenement.builder().lieu("gggg")
				.titre("rrr")
				.dateEvent(null)
				.build();
		event.save(E);
		
	}

}
