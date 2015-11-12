package fr.esigelec.garage;

import static org.junit.Assert.*;

import org.junit.Test;

public class VoitureDAOTest {

	@Test
	public void test() {
		VoitureDAO dao = new VoitureDAO();
		Voiture v = null;
		dao.ajouter(v);
		
	}

}
