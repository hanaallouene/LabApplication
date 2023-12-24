package com.example.demo.beans;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class EvenementBean {

	private Long id;
	private String titre;
	private Date date;
	private String lieu;
}
