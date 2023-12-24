package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicationImpl implements IPublicationService {
	PublicationRepository publicationRepository;

	@Override
	public Publication addPublication(Publication p) {
		publicationRepository.save(p);
		return p;
	}

	@Override
	public void deletePublication(Long id) {
		publicationRepository.deleteById(id);

	}

	@Override
	public Publication updatePublication(Publication p) {
		return publicationRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		
		return publicationRepository.findById(id).get();
	}

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findByTitre(String titre) {
		return publicationRepository.findByTitre(titre);
	}

	@Override
	public List<Publication> findByType(String type) {
		return publicationRepository.findByType(type);
	}

	@Override
	public List<Publication> findByLien(String lien) {
		return publicationRepository.findByLien(lien);
	}

	@Override
	public List<Publication> findBySourcepdf(String sourcepdf) {
		return publicationRepository.findBySourcepdf(sourcepdf);
	}

}
