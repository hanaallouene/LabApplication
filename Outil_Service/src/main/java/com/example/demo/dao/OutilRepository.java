package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Outil;
import java.util.List;
import java.util.Date;



public interface OutilRepository extends JpaRepository<Outil, Long> {
	List<Outil>  findBySource(String source);
	List<Outil> findByDate(Date date);
}
