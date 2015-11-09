package fr.esigelec.garage;

public class Voiture {
	private int id;
	private int km;
	private String immatriculation;
	private String modele;
	
	public Voiture() {
		
	}
	public Voiture(int id, int km, String immatriculation, String modele, int anneeConstruction) {
		super();
		this.id = id;
		this.km = km;
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.anneeConstruction = anneeConstruction;
	}
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", km=" + km + ", immatriculation=" + immatriculation + ", modele=" + modele
				+ ", anneeConstruction=" + anneeConstruction + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public int getAnneeConstruction() {
		return anneeConstruction;
	}
	public void setAnneeConstruction(int anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}
	private int anneeConstruction;
	
}
