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
	public void getVoitureTestIndexZero(){
		VoitureDAO dao = new VoitureDAO();
		System.out.println(dao.get(0));
		assertNull(dao.get(0));
	}
	
	
	@Test
	public void getVoitureTestIndexNegatif(){
		VoitureDAO dao = new VoitureDAO();
		assertNull(dao.get(-1));
	}
	
	@Test
	public void getVoitureTestAfterAdd(){
		VoitureDAO dao = new VoitureDAO();
		Voiture v = new Voiture(0,5000,"ABC-DEF-GHI","CITROEN",2009);
		dao.ajouter(v);
		assertEquals(v, dao.get(v.getId()));
	}
	
}
