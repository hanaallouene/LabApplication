package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Evenement;

public interface IEvenementService {
	//crud
	public Evenement addEvenement(Evenement E);
	public Evenement updateEvenement(Evenement E);
	public Evenement findEvenement(Long id);
	public void deleteEvenement(Long id);
	public List<Evenement> findAll();

}
