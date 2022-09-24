package fr.univ_smb.iae.mtii.jonardp.vehicules;

import fr.univ_smb.iae.mtii.jonardp.personnes.Conducteur;

public class VehiculeApp {

	public static void main(String[] args) {
		Vehicule v1 = new Voiture("Peugeot", 5);
		Vehicule v2 = new Camion("Volvo", 1);
		Vehicule v3 = new Camion("Mercedes", 2);
		
		v1.setCouleur("rouge");
		v1.setNum_imat("AA-001-AA");
		v1.setVitesse_inst(110);
		
		v2.setCouleur("grise");
		v2.setNum_imat("AA-002-AA");
		v2.setVitesse_inst(90);
		
		v3.setCouleur("blanche");
		v3.setNum_imat("AA-003-AA");
		v2.setVitesse_inst(80);
		
		Conducteur c1 = new Conducteur("Holmes", 34);
		Conducteur c2 = new Conducteur("Calvin", 53);
		
		v1.setConducteur(c1);
		System.out.println(v1.getConducteur().getNom());
	
		
		v1.afficherCaracteristiques();
		v2.afficherCaracteristiques();
		v3.afficherCaracteristiques();
	}

}
