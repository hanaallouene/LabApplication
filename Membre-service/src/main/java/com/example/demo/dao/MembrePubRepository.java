package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;

public interface MembrePubRepository extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
List<Membre_Publication> findByAuteur(Member auteur);
}
