package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Publication;
import java.util.List;


public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication>  findByType(String type);
	List<Publication>  findByLien(String lien);
	List<Publication>  findBySourcepdf(String sourcepdf);
	List<Publication>  findByTitre(String titre);
}
