package fr.univ_smb.iae.mtii.bulletins;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class BulletinMeteo {
	private Date date_avis;
	private String zone_geo, avis;
	
	private static final int MAX_BULLETINS = 30;

	// Constructeur
	public BulletinMeteo() {
		// on initialise la date de l'avis avec la date courante au moment 
		// de la creation de l'objet
		this.date_avis = new Date(); 
	}

	// Constructeur 2
	public BulletinMeteo(String avis) {
		this(); // appel au constructeur sans parametre...qui initialise la date
		// on initialise l'avis
		this.setAvis(avis); 
	}

	public String getZone_geo() {
		return zone_geo;
	}

	public void setZone_geo(String zone_geo) {
		this.zone_geo = zone_geo;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}
	
	// Cette methode retourne la representation d'objet 
	// (ici un objet de type BulletinMeteo) sous forme de chaine de
	// caracteres.
	// Cette methode est couramment utilisee et son nom bien connu 
	// en Java est toString()
	public String toString() {
		return "Bulletin meteo du " +
				this.date_avis.toString() +
				" - Avis : " +
				this.getAvis();
	}
	
	public static BulletinMeteo randomBulletinMeteo() {
		String[] tempsQuilFait = {"Grand beau temps", "Pluie", "Quelques averses",
		"Brouillard givrant", "Vent fort", "Nuageux"};
		String[] temperatures = {"Doux", "Chaud", "Froid", "De saison"};
		String[] geoZones = {"Annecy", "Paris", "Lyon", "Chambery"};
		
		int randomTempsQuilFaitNum, randomTemperaturesNum, randomGeoZonesNum;
		
		BulletinMeteo bulletin;
		String avis;
		
		randomTempsQuilFaitNum = ThreadLocalRandom.current().nextInt(0,
		tempsQuilFait.length);
		randomTemperaturesNum = ThreadLocalRandom.current().nextInt(0,
		temperatures.length);
		randomGeoZonesNum = ThreadLocalRandom.current().nextInt(0,
		geoZones.length);
		
		avis = tempsQuilFait[randomTempsQuilFaitNum] + " - " + temperatures[randomTemperaturesNum];
		bulletin = new BulletinMeteo(avis);
		bulletin.setZone_geo(geoZones[randomGeoZonesNum]);
		
		return bulletin;
	}
	
	public static ArrayList<BulletinMeteo> genererUnHistorique() {
		ArrayList<BulletinMeteo> bulletins = new ArrayList<BulletinMeteo>();
		String[] tempsQuilFait = {"Grand beau temps", "Pluie", "Quelques averses", "Brouillard givrant", "Ventfort", "Nuageux"};
		String[] temperatures = {"Doux", "Chaud", "Froid", "De saison"};
		String[] geoZones = {"Annecy", "Paris", "Lyon", "Chambery"};
		int randomTempsQuilFaitNum, randomTemperaturesNum, randomGeoZonesNum;
		
		BulletinMeteo bulletin;
		String avis;
		for (int i = 0; i < MAX_BULLETINS; i++) {
			bulletins.add(randomBulletinMeteo());
		}
		return bulletins;
	}

}