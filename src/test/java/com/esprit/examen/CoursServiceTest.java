package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.services.ICoursService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CoursServiceTest {

	@Autowired
	private ICoursService coursService;

	@Test
	public void createCours() {
		Cours cours = new Cours();
		cours.setDescription("Cours");
		cours.setIntitule("Java");
		cours.setTypeCours(TypeCours.Informatique);

		Long id = coursService.addCours(cours);
		assertThat(id).isNotNull();
		log.info("add success");
	}
	@Test
	public void modifierCours() {
		Cours cours = new Cours();
		cours.setDescription("Cours");
		cours.setIntitule("Spring11");
		cours.setTypeCours(TypeCours.Informatique);

		Long id = coursService.modifierCours(cours);

		Cours c = coursService.getCoursById(id);

		assertEquals(cours.getIntitule(), c.getIntitule());

	}
	
	/*@Test
	public void supprimerCours() {

		coursService.supprimerCours(8l);

		Cours c = coursService.getCoursById(8l);

		assertTrue(c == null);
		

	}*/
	@Test
	public void listCours() {

		List<Cours> cours = coursService.getCours();
		assertThat(cours).size().isNotNull();

	}

	/*@Test
	public void affectSessionToCours() {

		coursService.affecterCoursASession(3l, 3l);
		Set<Session> sessions = coursService.getCours().get(0).getSessions();
		assertThat(sessions).size().isGreaterThanOrEqualTo(1);
	}*/

}
