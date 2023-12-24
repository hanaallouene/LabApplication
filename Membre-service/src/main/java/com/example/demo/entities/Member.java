package com.example.demo.entities;


import java.util.Collection;
import java.util.Date;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;

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
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING)
public abstract class Member {
	@Transient
	Collection<PublicationBean> pubs;
	@Transient
	Collection<EvenementBean> evens;
	@Transient
	Collection<OutilBean> outils;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Nonnull
	private String cin;
	@Nonnull
	private String nom;
	@Nonnull
	private String prenom;
	@Nonnull
	@Temporal(TemporalType.DATE)
	private Date dateNaissence;
	@Nonnull
	private String cv;
	private byte[] photo;
	@Nonnull
	private String email;
	@Nonnull
	private String password;

}
