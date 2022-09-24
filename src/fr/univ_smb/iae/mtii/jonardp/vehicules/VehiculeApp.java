package fr.univ_smb.iae.mtii.jonardp.vehicules;

import fr.univ_smb.iae.mtii.jonardp.personnes.Conducteur;

public class VehiculeApp {

	public static void main(String[] args) {
		Vehicule v1 = new Voiture("Peugeot", 5);
		Vehicule v2 = new Camion("Volvo", 1);
		Vehicule v3 = new Camion("Mercedes", 2);
		
		v1.setCouleur("rouge");
		v1.setNum_imat("AA-001-AA");
		v1.setVitesse_inst(50);
		
		v2.setCouleur("grise");
		v2.setNum_imat("AA-002-AA");
		v2.setVitesse_inst(90);
		
		v3.setCouleur("jaune");
		v3.setNum_imat("AA-003-AA");
		v3.setVitesse_inst(40);
		
		Conducteur c1 = new Conducteur("Holmes", 34);
		Conducteur c2 = new Conducteur("Calvin", 53);
		
		v1.setConducteur(c1);
		System.out.println(v1.getConducteur().getNom());
	
		
		v1.afficherCaracteristiques();
		v2.afficherCaracteristiques();
		v3.afficherCaracteristiques();
		
		c2.getVehiculeConduits().add(v2);
		c2.getVehiculeConduits().add(v3);
		
		//Besoin pour la question 18
		Vehicule v4 = new Voiture("Renault",3);
		Vehicule v5 = new Camion("MAN",4);
		
		v4.setCouleur("noire");
		v4.setNum_imat("AA-004-AA");
		v4.setVitesse_inst(30);
		
		v5.setCouleur("blanche");
		v5.setNum_imat("AA-005-AA");
		v5.setVitesse_inst(50);
		
		Conducteur c3 = new Conducteur("Dédé", 58);
		c3.getVehiculeConduits().add(v4);
		c3.getVehiculeConduits().add(v5);
		
		c3.listingVehiculeConduits();
	}

}
