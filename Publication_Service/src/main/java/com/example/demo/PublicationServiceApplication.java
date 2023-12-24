package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class PublicationServiceApplication  implements CommandLineRunner {
	PublicationRepository publicationRepository;
	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Publication event1 = Publication.builder().date(new Date()).titre("titre1").lien("google.com").sourcepdf("pdf1.pdf").type("blog").build();
		Publication event2 = Publication.builder().date(new Date()).titre("titre2").lien("enis.rnu.tn").sourcepdf("pdf2.pdf").type("article").build();

		publicationRepository.save(event1);
		publicationRepository.save(event2);
		
	}

}
