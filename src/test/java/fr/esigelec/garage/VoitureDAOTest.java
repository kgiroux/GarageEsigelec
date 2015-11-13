package fr.esigelec.garage;

import static org.junit.Assert.*;

import org.junit.Test;

public class VoitureDAOTest {

	@Test
	public void ajouterNull() {
		VoitureDAO dao = new VoitureDAO();
		Voiture v = null;
		dao.ajouter(v);
		System.out.println(dao.getVoitures());
		assertEquals(dao.getVoitures().size(),0);
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
	public void getVoitureListVideTest(){
		VoitureDAO dao = new VoitureDAO();
		assertNull(dao.getVoitures());
	}
	
	@Test
	public void getVoitureListAfterAddTest(){
		VoitureDAO dao = new VoitureDAO();
		Voiture v = new Voiture(0,5000,"ABC-DEF-GHI","CITROEN",2009);
		Voiture w = new Voiture(1,1,"JKL-MNO-PQR","PEUGEOT",-500);
		dao.ajouter(v);
		dao.ajouter(w);
		assertEquals(dao.getVoitures().size(), 2);
		dao.supprimer(v);
		dao.supprimer(w);
	}
	
}
