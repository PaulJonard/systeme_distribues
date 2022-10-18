package fr.univ_smb.iae.mtii.jonardp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import fr.univ_smb.iae.mtii.bulletins.BulletinMeteo;

public class ServeurMeteo {

	// On gere desormais l'historique des bulletins meteo:
	// une collection d'objets, instances de la classe BulletinMeteo
	private ArrayList<BulletinMeteo> bulletinsMeteo = new ArrayList<BulletinMeteo>();
	public ArrayList<BulletinMeteo> getBulletinsMeteo() {
		return bulletinsMeteo;
	}

	public void setBulletinsMeteo(ArrayList<BulletinMeteo> bulletinsMeteo) {
		this.bulletinsMeteo = bulletinsMeteo;
	}

	private int port = 9090;
	private ServerSocket serveurSocket;

	// Méthode pour ouvrir une connexion
	public void ouvrirConnexion() throws IOException {
		this.serveurSocket = new ServerSocket(this.getPort());
	}

	// On utilise desormais les sockets pour avoir une application client-serveur
	// Modifications exigees
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
					if ((nbRequetesTraitees % 5) == 0)
						this.afficherBulletins(); // toutes les 5 requetes traitees on affiche l'historique
				} finally {
					socket.close();
				}
			}
		} finally {
			this.serveurSocket.close();
		}
	}

	// Utilisation des accesseurs, modificateurs !!!!
	// Modifications exigees
	public void afficherBulletinCourant() {
		System.out.println("Bulletin actuel:\t" + this.getBulletin_courant().toString() + "\n");
	}

	// Utilisation des accesseurs, modificateurs !!!!
	// Modifications exigees
	public void afficherBulletins() {
		System.out.println("===== Historique des bulletins meteo =====\n");
		for (BulletinMeteo bulletin : this.bulletinsMeteo) { // this.bulletinsMeteo est la collection d'objets
			System.out.println(bulletin.toString()); // element joue
		}
	}

	/*
	 * Cette methode demanderSaisieAvisMeteo devient inutile lorsqu'on gere
	 * l'historique des bulletins. On peut donc la supprimer.
	 */
	/*
	 * public String demanderSaisieAvisMeteo() { Scanner clavier = new
	 * Scanner(System.in); System.out.println("Saisir l'avis meteo: "); String avis
	 * = clavier.nextLine(); return avis; }
	 */
	// Modifications exigees
	public BulletinMeteo getBulletin_precedent() {
		int nbBulletins = this.nbBulletins();
		if (nbBulletins >= 2)
			// l'avant dernier se trouve a la place (la taille de la collection - 2)
			return this.bulletinsMeteo.get(nbBulletins - 2);
		else
			return null;
	}

	// Modifications exigees
	public BulletinMeteo getBulletin_courant() {
		int nbBulletins = this.nbBulletins();
		if (nbBulletins >= 1)
			// le dernier se trouve a la place (la taille de la collection - 1)
			return this.bulletinsMeteo.get(nbBulletins - 1);
		else
			return null;
	}

	// avant question 15
	/*
	 * public void ajouterBulletin(BulletinMeteo bulletin) {
	 * this.bulletinsMeteo.add(bulletin); }
	 */
	// apres question 15
	public void ajouterBulletin(BulletinMeteo bulletin) {
		if (!this.bulletinsMeteo.contains(bulletin))
			this.bulletinsMeteo.add(bulletin);
	}

	public int nbBulletins() {
		return this.bulletinsMeteo.size();
	}

	// Modifications exigees
	public ServeurMeteo() {
		this.setBulletinsMeteo(BulletinMeteo.genererUnHistorique());
	}

	// Il faudrait nommer cette methode rechercherBulletin
	// Elle permet de retourner le premier bulletin trouve
	// dans l'historique dont la zone geo correspond a celle
	// passee en parametre.
	public BulletinMeteo methodeToto(String zoneG) {
		BulletinMeteo trouve = null;
		int i = 0;
		while (trouve == null && i < this.bulletinsMeteo.size()) {
			trouve = this.bulletinsMeteo.get(i);
			if (trouve.getZone_geo() != zoneG)
				trouve = null;
			i++;
		}
		return trouve;
	}

	// Question 17
	public void supprimerTousLesBulletins(String zone) {
		Iterator<BulletinMeteo> iter = this.bulletinsMeteo.iterator();

		while (iter.hasNext()) {
			BulletinMeteo bulletin = iter.next();

			if (bulletin.getZone_geo() == zone)
				iter.remove();
		}
		/*
		 * Autre forme aussi: for (Iterator<BulletinMeteo> it =
		 * this.bulletinsMeteo.iterator(); it.hasNext(); ) { BulletinMeteo bulletin =
		 * it.next(); if (bulletin.getZone_geo() == zone) { it.remove(); } }
		 */
	}
	
	public ArrayList<BulletinMeteo> rechercherBulletins(String zoneG) {
		ArrayList<BulletinMeteo> bulletins = new ArrayList<BulletinMeteo>();
		for (BulletinMeteo bulletin : this.getBulletinsMeteo()) {
			if (bulletin.getZone_geo() == zoneG)
			// Si la zoneGeo du blletin correspond a celle recherchee on ajoute le bulletin
			bulletins.add(bulletin);
		}
		return bulletins;
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

	public void afficherPort() {
		System.out.println("La valeur du port est : " + this.getPort() + "\n");
	}

	// Illustration des modifications
	public static void main(String[] args) {
		// On cree un objet...
		// ServeurMeteo obj = new ServeurMeteo();
		ServeurMeteo serveur = new ServeurMeteo();
		
		System.out.println(serveur.bulletinsMeteo.size());
		
		System.out.println(serveur.rechercherBulletins("Paris"));

		try {
			serveur.ouvrirConnexion();
			serveur.donnerMeteo();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}