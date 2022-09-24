package fr.univ_smb.iae.mtii.jonardp.vehicules;

public class Voiture extends Vehicule{
	private int nbPortes;

	public Voiture(String _marque, int _nbPortes) {
		super(_marque);
		this.nbPortes = _nbPortes;
	}
	
	public int getNbPortes() {
		return nbPortes;
	}
	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}
	
	@Override
	public String toString() {
		return super.toString() 
			+ "Ce véhicule est une voiture " + this.getNbPortes() + " portes."; 
	}
	
}
