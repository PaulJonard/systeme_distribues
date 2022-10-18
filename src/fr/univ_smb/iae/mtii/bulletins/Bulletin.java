package fr.univ_smb.iae.mtii.bulletins;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Bulletin {
	private Date date_avis;
	public Date getDate_Avis() {
		return this.date_avis;
	}
	public void setDate_Avis(Date date_avis) {
		this.date_avis = date_avis;
	}
	
	private String avis;
	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}
	
	protected static final int MAX_BULLETINS = 30;

	// Constructeur
	public Bulletin() {
		// on initialise la date de l'avis avec la date courante au moment 
		// de la creation de l'objet
		this.setDate_Avis(new Date()); 
	}

	// Constructeur 2
	public Bulletin(String avis) {
		this(); // appel au constructeur sans parametre...qui initialise la date
		// on initialise l'avis
		this.setAvis(avis); 
	}
	
	// Cette methode retourne la representation d'objet 
	// (ici un objet de type BulletinMeteo) sous forme de chaine de
	// caracteres.
	// Cette methode est couramment utilisee et son nom bien connu 
	// en Java est toString()
	public String toString() {
		return "Bulletin du " + 
				this.date_avis.toString() + 
				" - Avis : " + 
				this.getAvis();
	}
}