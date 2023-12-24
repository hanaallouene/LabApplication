package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("ens")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnseignantChercheur extends Member{
	private String grade ;
	private String etablissement ;
	@JsonIgnore
	@OneToMany(mappedBy = "encadrent")
	private Collection <Etudiant> etudiants;
	
	@Builder
	public  EnseignantChercheur (String cin , String nom , String prenom ,Date dateNaissence ,String cv ,String email ,String password, String etablissement, String grade ) {
		super(cin , nom ,prenom , dateNaissence , cv , email , password);
		this.etablissement = etablissement;
		this.grade = grade;
	}
	
	
	
}
