package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;
import com.example.demo.service.IMemberService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@AllArgsConstructor

public class DemoApplication implements CommandLineRunner {
	MemberRepository memberRepository;
	IMemberService memberService;
	PublicationProxyService proxyService;
	EvenementProxyService evenementProxyService;
	OutilProxyService outilProxyService;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Etudiant etd1 = Etudiant.builder().cin("123456").dateInscription(new Date()).dateNaissance(new Date())
				.diplome("mastère").email("etd1@gmail.com").password("pass1").encadrant(null).cv("cv1").nom("abid")
				.prenom("youssef").sujet("blockhain").build();
		Etudiant etd2 = Etudiant.builder().cin("991234").dateInscription(new Date()).dateNaissance(new Date())
				.diplome("mastère").email("etd2@gmail.com").password("pass2").encadrant(null).cv("cv12").nom("zahani")
				.prenom("asma").sujet("blockhain").build();
		memberRepository.save(etd1);
		memberRepository.save(etd2);
		EnseignantChercheur ens1 = EnseignantChercheur.builder().cin("991234").nom("abid").prenom("youssef")
				.dateNaissence(new Date()).cv("cv1222").email("ens1@gmail.com")

				.password("pass1").etablissement("enis").grade("professeur").build();
		EnseignantChercheur ens2 = EnseignantChercheur.builder().cin("551234").nom("abid").prenom("youssef")
				.dateNaissence(new Date()).cv("cv1252").email("ens2@gmail.com")

				.password("pass2").etablissement("enis").grade("docteur").build();
		memberRepository.save(ens1);
		memberRepository.save(ens2);

		System.out.println("liste des menbres");
		List<Member> listmember = memberRepository.findAll();
		for (Member member : listmember) {
			System.out.println(member);
		}

		System.out.println("find by id :");
		Member membre = memberRepository.findById(1L).get();
		System.out.println(membre);
		System.out.println("update :");

		membre.setEmail("etudiant@enis.tn");
		memberRepository.save(membre);
//		System.out.println("delete :");
//		memberRepository.delete(membre);
		
		System.out.println("liste des membres");
		listmember = memberRepository.findAll();
		for (Member member : listmember) {
			System.out.println(member);
		}
		
		// Update a Member
		Member m= memberService.findMember(2L);
		System.out.println(m);
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
		// Delete a Member
//		memberService.deleteMember(2L);
		memberService.affecterEtudiantToEnseignant(2L,3L);
		memberService.affecterEtudiantToEnseignant(1L,3L);

		List<Etudiant> l = memberService.getEdutiantsByEncadrementId(ens1);
		System.out.println("liste des etudiant que l'ens1 les encadres");
		System.out.println(l);
		
		PublicationBean bean = proxyService.findPublicationById(1L);
		System.out.println("***********************************");

		System.out.println(bean.getTitre());
		
		PublicationBean pub = proxyService.findPublicationById(1L);
		System.out.println(pub.getTitre()+ " " + pub.getType());
		memberService.affecterauteurTopublication(1L, 1L);
		memberService.affecterauteurTopublication(1L, 2L);
		memberService.affecterauteurTopublication(2L, 2L);
		
		//***************************************************************************
		EvenementBean bean1 = evenementProxyService.findEvenementById(1L);
		System.out.println("#################################################");

		System.out.println(bean1);
		memberService.affecterauteurToevenement(1L, 1L);
		memberService.affecterauteurToevenement(1L, 2L);
		memberService.affecterauteurToevenement(2L, 2L);
		
		OutilBean bean2 = outilProxyService.findOutilById(1L);
		System.out.println("#################################################");

		System.out.println(bean2.getSource());
		OutilBean outil  = outilProxyService.findOutilById(1L);
		System.out.println(outil.getSource()+ " " + outil.getDate());
		memberService.affecterauteurTooutil(1L, 1L);
		memberService.affecterauteurTooutil(1L, 2L);
		memberService.affecterauteurTooutil(2L, 2L);
		

		
	}

}
