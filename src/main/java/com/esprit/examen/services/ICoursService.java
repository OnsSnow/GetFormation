package com.esprit.examen.services;

import java.util.List;
import java.util.Set;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;

public interface ICoursService {
	Long addCours(Cours cours);

	Long modifierCours(Cours cours);

	void supprimerCours(Long coursId);
	
	List<Cours> getCours();
	
	void affecterCoursASession(Long coursId, Long sessionId);
	
	Cours  getCoursById(Long id);
}
