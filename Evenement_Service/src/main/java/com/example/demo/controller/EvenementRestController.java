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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor
@CrossOrigin
public class EvenementRestController {
	
	
		IEvenementService evenementService;

		@RequestMapping(value = "/evenements", method = RequestMethod.GET)
		public List<Evenement> findMembres() {
			return evenementService.findAll();
		}

		@GetMapping(value = "/evenements/{id}")
		public Evenement findOneEvenementById(@PathVariable Long id) {
			return evenementService.findEvenement(id);
		}

		@PostMapping(value = "/evenements")
		public Evenement addMembre(@RequestBody Evenement e) {
			return evenementService.addEvenement(e);
		}	

		@DeleteMapping(value = "/evenements/{id}")
		public void deleteMembre(@PathVariable Long id) {
			evenementService.deleteEvenement(id);
		}

		@PutMapping(value = "/evenements/{id}")
		public Evenement updatEvenement(@PathVariable Long id, @RequestBody Evenement e) {
			e.setId(id);
			return evenementService.updateEvenement(e);
		}

	}



