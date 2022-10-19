package fr.univ_smb.iae.mtii.bulletins;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Bulletin {	
	private String zone_geo;
	private String avis;
	private Date date_avis;

	public String getZone_geo() {
		return zone_geo;
	}
	public void setZone_geo(String zone_geo) {
		this.zone_geo = zone_geo;
	}
	
	public Date getDate_Avis() {
		return this.date_avis;
	}
	public void setDate_Avis(Date date_avis) {
		this.date_avis = date_avis;
	}
	

	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
	}
	
	protected static final int MAX_BULLETINS = 30;
	
	private static final String[] GEO_ZONES = {"Annecy", "Paris", "Lyon", "Chambery"};
	private static final String[] TEMPS = {"Grand beau temps", "Pluie", "Quelques averses", "Brouillard givrant", "Vent fort", "Nuageux"};
	private static final String[] TEMPERATURES = {"Doux", "Chaud", "Froid", "De saison"};

	// Constructeur
	public Bulletin() {
		int randomTempsQuilFaitNum, randomTemperaturesNum, randomGeoZonesNum;
				
		randomTempsQuilFaitNum = ThreadLocalRandom.current().nextInt(0, TEMPS.length);
		randomTemperaturesNum = ThreadLocalRandom.current().nextInt(0, TEMPERATURES.length);
		randomGeoZonesNum = ThreadLocalRandom.current().nextInt(0, GEO_ZONES.length);

		this.setAvis(TEMPS[randomTempsQuilFaitNum] + " - " + TEMPERATURES[randomTemperaturesNum]);
		

		this.zone_geo = GEO_ZONES[randomGeoZonesNum];
		
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