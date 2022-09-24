package fr.univ_smb.iae.mtii.jonardp.vehicules;

public class Voiture {
	private String marque;
	private String couleur;
	private String num_imat;
	private int vitesse_inst;
	private int nbPortes;
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getNum_imat() {
		return num_imat;
	}
	public void setNum_imat(String num_imat) {
		this.num_imat = num_imat;
	}
	public int getVitesse_inst() {
		return vitesse_inst;
	}
	public void setVitesse_inst(int vitesse_inst) {
		this.vitesse_inst = vitesse_inst;
	}
	public int getNbPortes() {
		return nbPortes;
	}
	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}
	
}
