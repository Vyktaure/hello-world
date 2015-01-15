package chicstyle.abstraction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ChicEtStyleJDBC extends ChicEtStyle {

	protected Statement statement;
	protected Connection connexion;

	//Constructeur

	public ChicEtStyleJDBC() {
		super();
		BDChicEtStyle.connexionBD();
		this.connexion=BDChicEtStyle.getConnexion();
		try {
			statement = connexion.createStatement();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<String> findAllClients() {
		Vector<String> clients = new Vector<String>();
		try {
			String myQuery = "SELECT DISTINCT client FROM PIECE;";
			ResultSet r = statement.executeQuery(myQuery);
			while(r.next()) {
				clients.add(r.getString("client"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	public Vector<String> findAllModelesClient(String client) {
		Vector<String> modeles = new Vector<String>();
		try {
			String myQuery = "SELECT DISTINCT modele FROM PIECE WHERE PIECE.client = '"+client+"'";
			ResultSet r = statement.executeQuery(myQuery);
			while(r.next()) {
				modeles.add(r.getString("modele"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return modeles;
	}

	public Vector<String> findAllTissusModele(String modele) {
		Vector<String> tissus = new Vector<String>();
		try {
			String myQuery = "SELECT DISTINCT tissu FROM PIECE WHERE PIECE.modele = '"+modele+"'";
			ResultSet r = statement.executeQuery(myQuery);
			while(r.next()) {
				tissus.add(r.getString("tissu"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return tissus;
	}

	public Vector<String> findAllCouleursTissu(String tissu) {
		Vector<String> couleurs = new Vector<String>();
		try {
			String myQuery = "SELECT DISTINCT couleur FROM PIECE WHERE PIECE.tissu = '"+tissu+"'";
			ResultSet r = statement.executeQuery(myQuery);
			while(r.next()) {
				couleurs.add(r.getString("tissu"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return couleurs;
	}


	public Piece findPiece(String client, String modele, String tissu, String couleur) {
		Piece p = null;
		try {
			String myQuery = "SELECT id_piece , client , modele, tissu, couleur, type FROM PIECE WHERE Competition.client = '"+client+"' AND Competition.modele = '"+modele+"' AND Competition.tissu = '"+tissu+"'AND Competition.couleur = '"+couleur+"'";
			ResultSet r = statement.executeQuery(myQuery);
			while (r.next()) {
				p = new Piece(r.getString("client"), r.getString("modele"),r.getString("tissu"), r.getString("couleur"),
						r.getString("type"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public Piece findPiece(String id_piece) {
		Piece p = null;
		try {
			String myQuery = "SELECT id_piece , client , modele, tissu, couleur, type FROM PIECE WHERE PIECE.id_piece = '"+id_piece+"' ";
			ResultSet r = statement.executeQuery(myQuery);
			while (r.next()) {
				p = new Piece(r.getString("client"), r.getString("modele"),r.getString("tissu"), r.getString("couleur"), r.getString("type"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public int findQteExpedier(int idpiece, int taille) {
		int quantiteExpediee = 0;
		try {
			String myQuery = "SELECT qte FROM EXPEDIER WHERE id_piece ="+idpiece+" AND taille="+taille+"";
			ResultSet r = statement.executeQuery(myQuery);
			while (r.next()) {
				quantiteExpediee = Integer.parseInt(r.getString("qte"));
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return quantiteExpediee;
	}

	public void savePiece(Piece p, boolean creation) {
		try {
			if((creation)&&(this.findPiece(p.getId_piece())==null)) {
				String myQuery = "INSERT INTO PIECE(client, modele, tissu, couleur, type) VALUES ('"+p.getClient()+"','"+p.getModele()+"','"+p.getTissu()+"','"+p.getCouleur()+"','"+p.getType()+"')";
				statement.executeUpdate(myQuery);
				statement.execute("CHECKPOINT");
			}
			else {
				String myQuery = "UPDATE PIECE SET PIECE.client = '"+p.getClient()+"', PIECE.modele = '"+p.getModele()+"', PIECE.tissu = '"+p.getTissu()+"', PIECE.couleur = '"+p.getCouleur()+"', PIECE.type = '"+p.getType()+"' WHERE PIECE.id_piece = '"+this.getPieceCourante().getId_piece()+"'";
				statement.executeUpdate(myQuery);
				statement.execute("CHECKPOINT");
			}
			this.setChanged();
			this.notifyObservers(CHANGEMENT_PIECES);
			this.setPieceCourante(p);
			this.notifyObservers(CHANGEMENT_PIECE_COURANT);
			this.setChanged();
			this.notifyObservers(CHANGEMENT_ATHLETES);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}


	}
}
