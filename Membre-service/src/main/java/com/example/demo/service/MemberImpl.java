package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.MembreEveRepository;
import com.example.demo.dao.MembreOutilRepository;
import com.example.demo.dao.MembrePubRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.entities.Membre_Eve_Id;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Id;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberImpl implements IMemberService {
	MemberRepository memberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;
	MembrePubRepository membrepubrepository;
	MembreEveRepository membreeveRepository;
	MembreOutilRepository membreOutilRepository ;
	PublicationProxyService proxy;
	EvenementProxyService evenementProxyService;
	OutilProxyService outilProxyService;

	@Override
	public Member addMember(Member m) {
		memberRepository.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);

	}

	@Override
	public Member updateMember(Member p) {

		return memberRepository.saveAndFlush(p);
	}

	@Override
	public Member findMember(Long id) {
		Member member = memberRepository.findById(id).get();
		return member;
	}

	@Override
	public List<Member> findAll() {

		return memberRepository.findAll();
	}

	@Override
	public Member findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	@Override
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);

	}

	@Override
	public List<Member> findByNom(String nom) {
		return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affecterEtudiantToEnseignant(Long idEtd, Long idEns) {
		Etudiant etd = etudiantRepository.findById(idEtd).get();
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idEns).get();
		etd.setEncadrent(ens);
		etudiantRepository.save(etd);

	}

	@Override
	public List<Etudiant> getEdutiantsByEncadrementId(EnseignantChercheur enseignent) {
		return etudiantRepository.findByEncadrent(enseignent);

	}

	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Member mbr = memberRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Id(idpub, idauteur));
		membrepubrepository.save(mbs);
	}

	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();
		Member auteur = memberRepository.findById(idauteur).get();
		List<Membre_Publication> idpubs = membrepubrepository.findByAuteur(auteur);
		idpubs.forEach(s -> {
			System.out.println(s);
			pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
		});
		return pubs;
	}

	@Override
	public void affecterauteurToevenement(Long idauteur, Long idevens) {
		Member mbr = memberRepository.findById(idauteur).get();
		Membre_Evenement mbs = new Membre_Evenement();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Eve_Id(idevens, idauteur));
		membreeveRepository.save(mbs);
		
	}

	@Override
	public List<EvenementBean> findevenementsparauteur(Long idauteur) {
		List<EvenementBean> evens = new ArrayList<EvenementBean>();
		Member auteur = memberRepository.findById(idauteur).get();
		List<Membre_Evenement> idevens = membreeveRepository.findByAuteur(auteur);
		idevens.forEach(s -> {
			System.out.println(s);
			evens.add(evenementProxyService.findEvenementById(s.getId().getEvenement_id()));
		});
		return evens;
	}

	@Override
	public void affecterauteurTooutil(Long idauteur, Long idoutil) {
		Member mbr = memberRepository.findById(idauteur).get();
		Membre_Outil mbs = new Membre_Outil();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Outil_Id(idoutil, idauteur));
		membreOutilRepository.save(mbs);
		
	}

	@Override
	public List<OutilBean> findOutilparauteur(Long idauteur) {
		List<OutilBean> outils = new ArrayList<OutilBean>();
		Member auteur = memberRepository.findById(idauteur).get();
		List<Membre_Outil> idoutils = membreOutilRepository.findByAuteur(auteur);
		idoutils.forEach(s -> {
			System.out.println(s);
			outils.add(outilProxyService.findOutilById(s.getId().getOutil_id()));
		});
		return outils;
	}

}
