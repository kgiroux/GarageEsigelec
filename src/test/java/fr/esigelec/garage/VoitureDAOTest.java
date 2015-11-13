package fr.esigelec.garage;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

public class VoitureDAOTest {

	@Test
	public void ajouterNull() {
		VoitureDAO dao = new VoitureDAO();
		//dao.deleteVoitures();
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
 	public void getVoitureListAfterAddTest(){
 		VoitureDAO dao = new VoitureDAO();
 		//dao.deleteVoitures();
 		Voiture v = new Voiture(0,5000,"ABC-DEF-GHI","CITROEN",2009);
 		Voiture w = new Voiture(1,1,"JKL-MNO-PQR","PEUGEOT",-500);
 		dao.ajouter(v);
 		dao.ajouter(w);
 		assertEquals(dao.getVoitures().size(), 2);
 		dao.supprimer(v);
 		dao.supprimer(w);
 	}
	
	@Test(expected = AssertionError.class)  
	public void supprimerNullTest(){
		VoitureDAO dao = new VoitureDAO();
		Voiture v = null;
		dao.supprimer(v);
	}
	
	@Test
	public void supprimerVoitureTest(){
		Voiture v = new Voiture(1009,5000,"ABC-DEF-GHI","CITROEN",2009);
		VoitureDAO dao = new VoitureDAO();
		dao.ajouter(v);
		System.out.println("TEST : " + v);
		dao.supprimer(v);
		System.out.println("TEST : " + v);
		assertNull(dao.get(v.getId()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void supprimerByIDNegatifValueTest(){
		VoitureDAO dao = new VoitureDAO();
		dao.supprimer(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void supprimerByIDZeroValueTest(){
		VoitureDAO dao = new VoitureDAO();
		dao.supprimer(0);
	}
	
	@Test
	public void supprimerByIDValueTest(){
		VoitureDAO dao = new VoitureDAO();
		Voiture v = new Voiture(15,5000,"ABC-DEF-GHI","CITROEN",2009);
		dao.ajouter(v);
		dao.supprimer(v.getId());
		assertNull(dao.get(v.getId()));
	}
	
	
	@Test (expected = InvalidParameterException.class)
	public void roulerNegatifValue(){
		Voiture v = new Voiture(1009,5000,"ABC-DEF-GHI","CITROEN",2009);
		VoitureDAO dao = new VoitureDAO();
		dao.rouler(v, -1);
		
	}
	
	@Test (expected = AssertionError.class)
	public void roulerNullVoitureTest(){
		Voiture v = null;
		VoitureDAO dao = new VoitureDAO();
		dao.rouler(v, -1);
		
	}
	
	@Test
	public void roulerZeroValue(){
		Voiture v =  new Voiture(0,5000,"ABC-DEF-GHI","CITROEN",2009);
		VoitureDAO dao = new VoitureDAO();
		dao.rouler(v, 0);
		assertEquals(5000, v.getKm());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void roulerMaxValue(){
		Voiture v =  new Voiture(0,5000,"ABC-DEF-GHI","CITROEN",2009);
		VoitureDAO dao = new VoitureDAO();
		dao.rouler(v,  2147483647);
		//assertEquals(5000, v.getKm());
	}
	
	
}
