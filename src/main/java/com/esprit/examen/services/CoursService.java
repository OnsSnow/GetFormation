package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;

	
	@Autowired
	private SessionRepository sessionRepository;
	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}              

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);

	}

	@Override
	public List<Cours> getCours() {

		List<Cours> cours = coursRepository.findAll();
		return cours;
	}
	@Override
	public Cours getCoursById(Long id) {
		// TODO Auto-generated method stub
		return coursRepository.findById(id).orElse(null);
	}

	@Override
	public void affecterCoursASession(Long coursId, Long sessionId) {

		Cours cours = coursRepository.findById(coursId).orElse(null);

		Session session = sessionRepository.findById(sessionId).orElse(null);
//	session.getCours().add(cours);
//	sessionRepository.save(session);
		cours.getSessions().add(session);
//		
		coursRepository.save(cours);
	}

}
