package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Eve_Id;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Id;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;

public interface MembreOutilRepository extends JpaRepository<Membre_Outil, Membre_Outil_Id> {
List<Membre_Outil> findByAuteur(Member auteur);
}
