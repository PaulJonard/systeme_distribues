package fr.univ_smb.iae.mtii.bulletins;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class BulletinMeteo extends Bulletin{
	private String zone_geo;
	public String getZone_geo() {
		return zone_geo;
	}

	public void setZone_geo(String zone_geo) {
		this.zone_geo = zone_geo;
	}
	
	
	// Constructeur
	public BulletinMeteo() {
		// on initialise la date de l'avis avec la date courante au moment 
		// de la creation de l'objet
		super();
	}

	// Constructeur 2
	public BulletinMeteo(String avis){
		// appel au constructeur sans parametre...qui initialise la date
		// on initialise l'avis
		super(avis);
	}

	public static BulletinMeteo randomBulletinMeteo() {
		String[] tempsQuilFait = {"Grand beau temps", "Pluie", "Quelques averses", "Brouillard givrant", "Vent fort", "Nuageux"};
		String[] temperatures = {"Doux", "Chaud", "Froid", "De saison"};
		String[] geoZones = {"Annecy", "Paris", "Lyon", "Chambery"};
		
		int randomTempsQuilFaitNum, randomTemperaturesNum, randomGeoZonesNum;
		
		BulletinMeteo bulletin;
		String avis;
		
		randomTempsQuilFaitNum = ThreadLocalRandom.current().nextInt(0, tempsQuilFait.length);
		randomTemperaturesNum = ThreadLocalRandom.current().nextInt(0, temperatures.length);
		randomGeoZonesNum = ThreadLocalRandom.current().nextInt(0, geoZones.length);
		
		avis = tempsQuilFait[randomTempsQuilFaitNum] + " - " + temperatures[randomTemperaturesNum];
		bulletin = new BulletinMeteo(avis);
		bulletin.setZone_geo(geoZones[randomGeoZonesNum]);
		
		return bulletin;
	}
	
	public static ArrayList<BulletinMeteo> genererUnHistorique() {
		ArrayList<BulletinMeteo> bulletins = new ArrayList<BulletinMeteo>();

		for (int i = 0; i < MAX_BULLETINS; i++) {
			bulletins.add(randomBulletinMeteo());
		}
		return bulletins;
	}

}