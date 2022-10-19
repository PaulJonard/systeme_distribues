package fr.univ_smb.iae.mtii.bulletins;

import java.util.ArrayList;
import java.util.Iterator;

public class EnsembleDeBulletins extends ArrayList<Bulletin>{

	public void afficherBulletins() {
		System.out.println("===== Affichage des bulletins =====\n");
		for (Bulletin bulletin : this) { // this est UNE collection d'objets
			System.out.println(bulletin.toString());
		}
	}
	
	public void afficherBulletins(EnsembleDeBulletins bulletins) {
		System.out.println("===== Affichage des bulletins meteo =====\n");
		for (Bulletin bulletin : bulletins) { // ???? est UNE collection d'objets
			System.out.println(bulletin.toString());
		}
	}
	
	public EnsembleDeBulletins rechercherBulletins(String zoneG) {
		EnsembleDeBulletins bulletins = new EnsembleDeBulletins();
		for (Bulletin bulletin : this) {
			if (bulletin.getZone_geo() == zoneG)
				// Si la zoneGeo du bulletin correspond a celle recherchee on ajoute le bulletin
				bulletins.add(bulletin);
		}
		return bulletins;
	}
	// Elle permet de retourner le premier bulletin trouve
	// dans l'historique dont la zone geo correspond a celle
	// passee en parametre.
	public Bulletin rechercherBulletin(String zoneG) {
		Bulletin trouve = null;
		int i = 0;
		while (trouve == null && i < this.size()) {
			trouve = this.get(i);
			if (trouve.getZone_geo() != zoneG)
				trouve = null;
			i++;
		}
		return trouve;
	}
	public void supprimerTousLesBulletins(String zone) {
		Iterator<Bulletin> iter = this.iterator();
		while (iter.hasNext()) {
			Bulletin bulletin = iter.next();
			if (bulletin.getZone_geo() == zone)
				iter.remove();
			}
	}
	
	public void afficherBulletinCourant() {
		System.out.println("Bulletin actuel:\t" + this.getBulletin_courant().toString() + "\n");
	}
	


	public Bulletin getBulletin_precedent() {
		int nbBulletins = this.size();
		if (nbBulletins >= 2)
			// l'avant dernier se trouve a la place (la taille de la collection - 2)
			return this.get(nbBulletins - 2);
		else
			return null;
	}

	public Bulletin getBulletin_courant() {
		int nbBulletins = this.size();
		if (nbBulletins >= 1)
			// le dernier se trouve a la place (la taille de la collection - 1)
			return this.get(nbBulletins - 1);
		else
			return null;
	}
}
