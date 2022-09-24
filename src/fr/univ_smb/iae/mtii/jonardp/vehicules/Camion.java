package fr.univ_smb.iae.mtii.jonardp.vehicules;

public class Camion extends Vehicule{
	private int categorie;
	
	public Camion(String _marque, int _categorie) {
		super(_marque);
		this.categorie = _categorie;
	}
	
	
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		return super.toString() 
			+ "Ce véhicule est un camion de catégorie " + this.getCategorie(); 
	}
	
}
