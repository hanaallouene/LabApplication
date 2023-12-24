package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
public class PublicationRestController {
	IPublicationService iPublicationService;

	@RequestMapping(value = "/Publications", method = RequestMethod.GET)
	public List<Publication> findMembres() {
		return iPublicationService.findAll();
	}

	@GetMapping(value = "/Publications/{id}")
	public Publication findOnePublicationById(@PathVariable Long id) {
		return iPublicationService.findPublication(id);
	}

	@GetMapping(value = "/Publications/search/type")
	public List<Publication> findOnePublicationByType(@RequestParam String type) {
		return iPublicationService.findByType(type);
	}

	@GetMapping(value = "/Publications/search/sourcepdf")
	public List<Publication> findOnePublicationBySourcepdf(@RequestParam String sourcepdf) {
		return iPublicationService.findBySourcepdf(sourcepdf);
	}
	
	@GetMapping(value = "/Publications/search/lien")
	public List<Publication> findOnePublicationByLien(@RequestParam String lien) {
		return iPublicationService.findByLien(lien);
	}


	@GetMapping(value = "/Publications/search/titre")
	public List<Publication> findOnePublicationByTitre(@RequestParam String titre) {
		return iPublicationService.findByTitre(titre);
	}

	@PostMapping(value = "/Publications")
	public Publication addMembre(@RequestBody Publication e) {
		return iPublicationService.addPublication(e);
	}

	@DeleteMapping(value = "/Publications/{id}")
	public void deleteMembre(@PathVariable Long id) {
		iPublicationService.deletePublication(id);
	}

	@PutMapping(value = "/Publications/{id}")
	public Publication updatPublication(@PathVariable Long id, @RequestBody Publication e) {
		e.setId(id);
		return iPublicationService.updatePublication(e);
	}

}
