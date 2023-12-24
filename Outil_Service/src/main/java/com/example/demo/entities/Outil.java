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
public class Outil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Nonnull
	@Temporal(TemporalType.DATE)
	private Date date;
	@Nonnull
	private String source;
    @Builder 
    public Outil(String source ,Date date) {
    	this.source=source;
    	this.date=date ;	
    }
}
