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
	public void getVoitureIndexZeroTest(){
		VoitureDAO dao = new VoitureDAO();
		assertNull(dao.get(0));
	}
	@Test
	public void getVoitureIndexNegatifTest(){
		VoitureDAO dao = new VoitureDAO();
		assertNull(dao.get(-1));
	}
	@Test
	public void getVoitureAfterAddTest(){
		VoitureDAO dao = new VoitureDAO();
		Voiture v = new Voiture(0,5000,"ABC-DEF-GHI","CITROEN",2009);
		dao.ajouter(v);
		assertEquals(v, dao.get(v.getId()));
		dao.supprimer(v);
	}
	
	
	@Test
	public void supprimerNullTest(){
		VoitureDAO dao = new VoitureDAO();
		Voiture v = null;
		dao.supprimer(v);
	}
	
	@Test
	public void supprimerVoiture(){
		Voiture v = new Voiture(1009,5000,"ABC-DEF-GHI","CITROEN",2009);
		VoitureDAO dao = new VoitureDAO();
		dao.ajouter(v);
		//dao.supprimer(v);
		assertNull(v);
		
	}
	
	
}
