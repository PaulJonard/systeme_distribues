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
		return super.toString();
	}

	
	public static ArrayList<Bulletin> genererUnHistorique() {
		ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();

		for (int i = 0; i < MAX_BULLETINS; i++) {
			bulletins.add(new BulletinMeteo());
		}
		return bulletins;
	}

	@Override
	public void interpreter() {
		System.out.println("Le bulletin est interprete par un meterologue.\n");		
	}
}