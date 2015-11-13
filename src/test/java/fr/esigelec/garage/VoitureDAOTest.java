package fr.esigelec.garage;

import static org.junit.Assert.*;

import org.junit.Test;

public class VoitureDAOTest {

	@Test
	public void ajouterTest() {
		VoitureDAO dao = new VoitureDAO();
		Voiture v = null;
		dao.ajouter(v);
		System.out.println(dao.getVoitures());
		assertEquals(dao.getVoitures(),null);
	}
	
	@Test
	public void getVoitureTest(){
		VoitureDAO dao = new VoitureDAO();
	}

}
