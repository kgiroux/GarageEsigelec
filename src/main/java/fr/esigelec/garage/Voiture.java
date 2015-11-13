package fr.esigelec.garage;

public class Voiture {
	private int id;
	private int km;
	private String immatriculation;
	private String modele;
	private int anneeConstruction;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeConstruction;
		result = prime * result + id;
		result = prime * result + ((immatriculation == null) ? 0 : immatriculation.hashCode());
		result = prime * result + km;
		result = prime * result + ((modele == null) ? 0 : modele.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (anneeConstruction != other.anneeConstruction)
			return false;
		if (id != other.id)
			return false;
		if (immatriculation == null) {
			if (other.immatriculation != null)
				return false;
		} else if (!immatriculation.equals(other.immatriculation))
			return false;
		if (km != other.km)
			return false;
		if (modele == null) {
			if (other.modele != null)
				return false;
		} else if (!modele.equals(other.modele))
			return false;
		return true;
	}
	
	
}
