package fr.univ_smb.iae.mtii.bulletins;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BulletinAvalanche extends Bulletin{
	int hauteurNeigeFraiche, niveauRisque;
	
	public int getHauteurNeigeFraiche() {
		return this.hauteurNeigeFraiche;
	}
	public void setHauteurNeigeFraiche(int hauteurneigefraiche) {
		this.hauteurNeigeFraiche = hauteurneigefraiche;
	}
	
	public int getNiveauRisque() {
		return this.niveauRisque;
	}
	public void setNiveauRisque(int niveaurisque) {
		this.niveauRisque = niveaurisque;
	}
	
	private static final int[] HAUTEURS_NEIGE = {0, 10, 20, 30, 40, 50};
	private static final int[] NIVEAUX_RISQUE = {0, 1, 2, 3, 4, 5};
	
	public BulletinAvalanche() {
		super();
		
		int randomHauteurNeige, randomNiveauRisque;
		
		randomHauteurNeige = ThreadLocalRandom.current().nextInt(0, HAUTEURS_NEIGE.length);
		randomNiveauRisque = ThreadLocalRandom.current().nextInt(0, NIVEAUX_RISQUE.length);

		this.setHauteurNeigeFraiche(HAUTEURS_NEIGE[randomHauteurNeige]);
		
		this.setNiveauRisque(NIVEAUX_RISQUE[randomNiveauRisque]);
	}
	
	public BulletinAvalanche(String avis) {
		super(avis);
		this.setNiveauRisque(3);
	}
	
	public String toString() {
		return super.toString() + // appel de la methode de la super-classe
				" (" + this.getHauteurNeigeFraiche() + ") " +
				" (" + this.getNiveauRisque() + ") ";// on specialise
	}
	
	public static ArrayList<Bulletin> genererUnHistorique() {
		ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();

		for (int i = 0; i < MAX_BULLETINS; i++) {
			bulletins.add(new BulletinAvalanche());
		}
		return bulletins;
	}
}
