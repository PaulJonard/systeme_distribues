package fr.univ_smb.iae.mtii.bulletins;

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
	

	public BulletinAvalanche() {
		super();
		this.setNiveauRisque(3);
	}
	
	public BulletinAvalanche(String avis) {
		super(avis);
		this.setNiveauRisque(3);
	}
}
