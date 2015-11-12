package fr.esigelec.garage;

public class main {

	public static void main(String[] args) {
		//on instancie le DAO
		VoitureDAO dao=new VoitureDAO();
		//cr�ation d'une personne
		Voiture v=new Voiture(1,1500,"S�bastien","CITROEN",2009);
		//ajout de la personne dans la base
		dao.ajouter(v);
		//affichage de la personne ajout�e (son id sera celui qui a �t� fix� par la base)
		System.out.println(v);
		//affichage de toute la table personne
		System.out.println(dao.getVoitures());
		//affichage des personnes dont le salaire est compris entre 20000 et 30000 euros
		System.out.println(dao.get(v.getId()));
		
		// Suppression des v�hicules
		dao.supprimer(v.getId());
		//dao.supprimer(4);
		
		}
}
