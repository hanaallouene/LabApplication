package com.example.demo.entities;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@Nonnull
	private String titre ;
	
	@Nonnull
	private String lieu;
	
	@Nonnull
	private Date dateEvent;

	
	@Builder
	public Evenement(String titre, String lieu, Date dateEvent) {
		super();
		this.titre = titre;
		this.lieu = lieu;
		this.dateEvent = dateEvent;
	}
	
	

}
