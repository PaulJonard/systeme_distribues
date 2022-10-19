package fr.univ_smb.iae.mtii.jonardp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import fr.univ_smb.iae.mtii.bulletins.*;

public class ServeurMeteo {

	// On gere desormais l'historique des bulletins meteo:
	// une collection d'objets, instances de la classe BulletinMeteo
	private ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();
	private int port = 9090;	
	private ServerSocket serveurSocket;

	public ArrayList<Bulletin> getBulletins() {
		return bulletins;
	}

	public void setBulletins(ArrayList<Bulletin> bulletins) {
		this.bulletins = bulletins;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		if (port >= 8500 && port <= 9500) {// Intervalle de valeur autorisee du port
			this.port = port;
			System.out.println("Le port a ete modifie. Il faudrait relancer le serveur !\n");
		} else
			System.out.println("Valeur non autorisee: le port n'a pas ete modifie.\n");
	}
	
	public ServeurMeteo() {
	}
	// Méthode pour ouvrir une connexion
	public void ouvrirConnexion() throws IOException {
		this.serveurSocket = new ServerSocket(this.getPort());
	}

	public void donnerMeteo() throws IOException {
		System.out.println("Le serveur est prêt à donner la météo. "
				+ "Il est en attente de demandes de client(s) sur le port " + this.getPort() + ".\n");
		try {
			int nbRequetesTraitees = 0;
			while (true) {
				Socket socket = this.serveurSocket.accept();
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					String messageDuServeur = this.getBulletin_courant().toString() + "\n";
					out.println(messageDuServeur);
					nbRequetesTraitees++;
					if ((nbRequetesTraitees % 5) == 0) {
						
						afficherBulletins(getBulletins());
						this.getBulletins().add(new BulletinMeteo());
					}
						
				} finally {
					socket.close();
				}
			}
		} finally {
			this.serveurSocket.close();
		}
	}

	public void afficherBulletinCourant() {
		System.out.println("Bulletin actuel:\t" + this.getBulletin_courant().toString() + "\n");
	}

	public void afficherBulletins() {
		System.out.println("===== Historique des bulletins meteo =====\n");
		for (Bulletin bulletin : this.getBulletins()) { // this.bulletinsMeteo est la collection d'objets
			System.out.println(bulletin.toString()); // element joue
		}
	}
	
	public static void afficherBulletins(ArrayList<Bulletin> bulletins) {
		System.out.println("===== Affichage des bulletins meteo =====\n");
		for (Bulletin bulletin : bulletins) { // ???? est UNE collection d'objets
			System.out.println(bulletin.toString());
		}
	}

		public Bulletin getBulletin_precedent() {
		int nbBulletins = this.getBulletins().size();
		if (nbBulletins >= 2)
			// l'avant dernier se trouve a la place (la taille de la collection - 2)
			return this.getBulletins().get(nbBulletins - 2);
		else
			return null;
	}

	public Bulletin getBulletin_courant() {
		int nbBulletins = this.getBulletins().size();
		if (nbBulletins >= 1)
			// le dernier se trouve a la place (la taille de la collection - 1)
			return this.getBulletins().get(nbBulletins - 1);
		else
			return null;
	}

	public void ajouterBulletin(Bulletin bulletin) {
		if (!this.getBulletins().contains(bulletin))
			this.getBulletins().add(bulletin);
	}
	
	public ArrayList<Bulletin> rechercherBulletins(String zoneG) {
		ArrayList<Bulletin> bulletins = new ArrayList<Bulletin>();
		for (Bulletin bulletin : this.getBulletins()) {
			if (bulletin.getZone_geo() == zoneG)
				bulletins.add(bulletin);
		}
		return bulletins;
	}

	// Question 17
	public void supprimerTousLesBulletins(String zone) {
		Iterator<Bulletin> iter = this.getBulletins().iterator();

		while (iter.hasNext()) {
			Bulletin bulletin = iter.next();

			if (bulletin.getZone_geo() == zone)
				iter.remove();
		}
	}
	

	public void afficherPort() {
		System.out.println("La valeur du port est : " + this.getPort() + "\n");
	}

	// Illustration des modifications
	public static void main(String[] args) {
		// On cree un objet...
		// ServeurMeteo obj = new ServeurMeteo();
		ServeurMeteo serveur = new ServeurMeteo();

		serveur.setBulletins(BulletinMeteo.genererUnHistorique());
		BulletinAvalanche ba1 = new BulletinAvalanche();
		ba1.setHauteurNeigeFraiche(10);
		ba1.setNiveauRisque(2);
		
		BulletinAvalanche ba2 = new BulletinAvalanche();
		ba2.setHauteurNeigeFraiche(50);
		
		serveur.ajouterBulletin(ba1);
		serveur.ajouterBulletin(ba2);
		
		serveur.afficherBulletins();
		serveur.supprimerTousLesBulletins("Annecy");
		
		ServeurMeteo.afficherBulletins(serveur.rechercherBulletins("Annecy"));

		try {
			serveur.ouvrirConnexion();
			serveur.donnerMeteo();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}