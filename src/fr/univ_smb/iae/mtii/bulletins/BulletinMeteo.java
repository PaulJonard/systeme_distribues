package fr.univ_smb.iae.mtii.bulletins;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class BulletinMeteo extends Bulletin{

	
	// Constructeur
	public BulletinMeteo() {
		super();
	}

	// Constructeur 2
	public BulletinMeteo(String avis){
		// appel au constructeur sans parametre...qui initialise la date
		// on initialise l'avis
		super(avis);
	}
	
	public String toString() {
		return super.toString() + // appel de la methode de la super-classe
				" (" + this.getZone_geo() + ") "; // on specialise
	}

	
	public static ArrayList<Bulletin> genererUnHistorique() {
		ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();

		for (int i = 0; i < MAX_BULLETINS; i++) {
			bulletins.add(new BulletinMeteo());
		}
		return bulletins;
	}
}