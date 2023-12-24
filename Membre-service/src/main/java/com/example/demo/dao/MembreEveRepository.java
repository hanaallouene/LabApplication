package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Eve_Id;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;

public interface MembreEveRepository extends JpaRepository<Membre_Evenement, Membre_Eve_Id> {
List<Membre_Evenement> findByAuteur(Member auteur);
}
