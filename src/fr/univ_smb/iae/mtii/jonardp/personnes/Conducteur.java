package fr.univ_smb.iae.mtii.jonardp.personnes;

public class Conducteur {
	private String nom;
	private int age;
	private int num_permis;
	
	public Conducteur(String _nom, int _age) {
		this.nom = _nom;
		this.age = _age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum_permis() {
		return num_permis;
	}

	public void setNum_permis(int num_permis) {
		this.num_permis = num_permis;
	}
	
}
