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
	private EnsembleDeBulletins bulletins = new EnsembleDeBulletins(); 
	private int port = 9090;	
	private ServerSocket serveurSocket;

	public EnsembleDeBulletins getBulletins() {
		return bulletins;
	}

	public void setBulletins(EnsembleDeBulletins bulletins) {
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
					String messageDuServeur = this.getBulletins().getBulletin_courant().toString() + "\n";
					out.println(messageDuServeur);
					nbRequetesTraitees++;
					if ((nbRequetesTraitees % 5) == 0) {
						
						this.getBulletins().afficherBulletins();
						this.getBulletins().getBulletin_courant().interpreter();
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

	public void afficherPort() {
		System.out.println("La valeur du port est : " + this.getPort() + "\n");
	}

	// Illustration des modifications
	public static void main(String[] args) {
		// On cree un objet...
		// ServeurMeteo obj = new ServeurMeteo();
		ServeurMeteo serveur = new ServeurMeteo();

		ArrayList<Bulletin> bm = BulletinMeteo.genererUnHistorique();
		ArrayList<Bulletin> ba = BulletinAvalanche.genererUnHistorique();
				
		EnsembleDeBulletins edb = new EnsembleDeBulletins();
		edb.addAll(ba);
		edb.addAll(bm);
		
		serveur.setBulletins(edb);
		
		serveur.getBulletins().afficherBulletins();
		serveur.getBulletins().supprimerTousLesBulletins("Annecy");
				
		serveur.getBulletins().afficherBulletins(serveur.getBulletins().rechercherBulletins("Annecy"));
		
		try {
			serveur.ouvrirConnexion();
			serveur.donnerMeteo();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}