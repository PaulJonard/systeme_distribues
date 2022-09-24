package fr.univ_smb.iae.mtii.jonardp.vehicules;

import fr.univ_smb.iae.mtii.jonardp.personnes.Conducteur;

public class Vehicule {
	private String marque;
	private String couleur;
	private String num_imat;
	private int vitesse_inst;
	Conducteur conducteur;
	
	public Vehicule(String _marque) {
		this.marque = _marque;
	}
	
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
	public Conducteur getConducteur() {
		return conducteur;
	}
	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	
	public String toString(){
		return "Vehicule de marque: "
		+ this.getMarque()
		+ " de couleur " +this.getCouleur()
		+ " roulant a une vitesse de " + this.getVitesse_inst()
		+ " km/h.\n"; // caractere de retour a la ligne
		}
	
	public void afficherCaracteristiques() {
		System.out.println( this.toString() ); // on appelle la m'ethode précédente
		}
}
