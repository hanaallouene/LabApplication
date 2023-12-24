package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
	public Optional<Evenement> findById(Long id);
	public List<Evenement> findAll();

}
