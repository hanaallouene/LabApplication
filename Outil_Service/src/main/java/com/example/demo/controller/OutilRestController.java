package com.example.demo.controller;

import java.util.Date;
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

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
public class OutilRestController {
	IOutilService iOutilService;

	@RequestMapping(value = "/Outils", method = RequestMethod.GET)
	public List<Outil> findMembres() {
		return iOutilService.findAll();
	}

	@GetMapping(value = "/Outils/{id}")
	public Outil findOneOutilById(@PathVariable Long id) {
		return iOutilService.findOutil(id);
	}

	@GetMapping(value = "/Outils/search/source")
	public List<Outil> findOneOutilBySource(@RequestParam String source) {
		return iOutilService.findBySource(source);
	}

	@GetMapping(value = "/Outils/search/date")
	public List<Outil> findOneOutilByDate(@RequestParam Date date) {
		return iOutilService.findByDate(date);
	}
	



	@PostMapping(value = "/Outils")
	public Outil addMembre(@RequestBody Outil e) {
		return iOutilService.addOutil(e);
	}

	

	@DeleteMapping(value = "/Outils/{id}")
	public void deleteMembre(@PathVariable Long id) {
		iOutilService.deleteOutil(id);
	}

	@PutMapping(value = "/Outils/{id}")
	public Outil updatOutil(@PathVariable Long id, @RequestBody Outil e) {
		e.setId(id);
		return iOutilService.updateOutil(e);
	}

}
