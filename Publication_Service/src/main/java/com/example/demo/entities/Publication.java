package com.example.demo.entities;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Nonnull
	private String type;
	@Nonnull
	private String titre;
	@Nonnull
	private String lien;
	@Nonnull
	@Temporal(TemporalType.DATE)
	private Date date;
	@Nonnull
	private String sourcepdf;

	@Builder
	public Publication(String type, Date date, String titre, String lien, String sourcepdf) {
		this.date = date;
		this.lien=lien;
		this.titre= titre;
		this.type=type;
		this.sourcepdf=sourcepdf;
	}

}
