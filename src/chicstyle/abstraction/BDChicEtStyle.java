package chicstyle.abstraction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BDChicEtStyle {

	private static Connection connexion;

	/**
	 * driver JDBC
	 */
	private static final String jdbcDriver = "org.hsqldb.jdbcDriver";

	/**
	 * fichiers db
	 */
	private static final String database = "jdbc:hsqldb:file:db/chicdb";

	/**
	 * utilisateur qui se connecte à la base de données
	 */
	private static final String user = "sa";

	/**
	 * mot de passe pour se connecter à la base de données
	 */
	private static final String password = "";

	/**
	 * Connexion à la base de donnée
	 */
	public static void connexionBD() {
		try {
			// On commence par charger le driver JDBC d'HyperSQL
			Class.forName(jdbcDriver).newInstance();
		} catch (InstantiationException e) {
			System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// Puis on se connecte à la base de donnees
			connexion = DriverManager.getConnection(database, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Arrête correctement HyperSQL
	 * 
	 * @throws SQLException
	 */
	public static void arretBD() throws SQLException {
		Statement st = connexion.createStatement();
		// On envoie l'instruction pour arreter proprement HSQLDB
		st.execute("SHUTDOWN");
		// On ferme la connexion
		connexion.close();

	}

	public static Connection getConnexion() {
		return connexion;
	}

	public static void main(String[] args) {
		BDChicEtStyle.connexionBD();
		try {

			Statement s = BDChicEtStyle.getConnexion().createStatement();

//			// CREATION DES TABLES
//			System.out.println("creation des tables...");
//
//			s.executeUpdate("CREATE TABLE TAILLES( taille INT PRIMARY KEY);");
//
//			s.executeUpdate("CREATE TABLE PIECE ("
//					+ "client VARCHAR(40), "
//					+ "modele VARCHAR(40), "
//					+ "tissu VARCHAR(40),"
//					+ "couleur VARCHAR(40), "
//					+ "type VARCHAR(40), "
//					+ "id_piece VARCHAR(40) GENERATED ALWAYS AS (client+modele+tissu+couleur) PRIMARY KEY);");
//
//			s.executeUpdate("CREATE TABLE REFERENCAGE ("
//					+ "ref VARCHAR(40) PRIMARY KEY, "
//					+ "type VARCHAR(40), "
//					+ "estTissu BOOLEAN);");
//
//			s.executeUpdate("CREATE TABLE NOMENCLATURE ("
//					+ "id_piece VARCHAR(40), "
//					+ "ref VARCHAR(40), "
//					+ "qte_unit FLOAT,"
//					+ "fact BOOLEAN, "
//					+ "PRIMARY KEY (id_piece, ref)); ");
//
//			s.executeUpdate("CREATE TABLE LANCEMENT ("
//					+ "id_piece VARCHAR(40), "
//					+ "taille INT, "
//					+ "qte INT,"
//					+ "PRIMARY KEY (id_piece, taille)); ");
//
//			s.executeUpdate("CREATE TABLE LANCEMENT_PROD ("
//					+ "id_piece VARCHAR(40) PRIMARY KEY, "
//					+ "date DATE ); ");
//
//			s.executeUpdate("CREATE TABLE PATRON ("
//					+ "id_piece VARCHAR(40), "
//					+ "ref VARCHAR(40), "
//					+ "taille INT,"
//					+ "laize FLOAT,"
//					+ "longueur FLOAT,"
//					+ "PRIMARY KEY (id_piece, ref, taille)); ");
//
//			s.executeUpdate("CREATE TABLE RECEP_TISSU ("
//					+ "ref VARCHAR(40) PRIMARY KEY, "
//					+ "laize FLOAT, "
//					+ "longueur_rouleau FLOAT);");
//
//			s.executeUpdate("CREATE TABLE RECEP_FOURNITURES ("
//					+ "ref VARCHAR(40) PRIMARY KEY, "
//					+ "qte_recue INT);");
//
//			s.executeUpdate("CREATE TABLE BOITE ("
//					+ "id_piece VARCHAR(40), "
//					+ "ref VARCHAR(40), "
//					+ "ok BOOLEAN,"
//					+ "PRIMARY KEY (id_piece, ref)); ");
//
//			s.executeUpdate("CREATE TABLE HOUSSER ("
//					+ "id_piece VARCHAR(40), "
//					+ "taille INT, "
//					+ "qte INT,"
//					+ "PRIMARY KEY (id_piece, taille)); ");
//
//			s.executeUpdate("CREATE TABLE EXPEDIER ("
//					+ "id_piece VARCHAR(40), "
//					+ "taille INT, "
//					+ "qte INT,"
//					+ "PRIMARY KEY (id_piece, taille)); ");
//
//			s.executeUpdate("CREATE TABLE LOGIN ("
//					+ " login VARCHAR(20) PRIMARY KEY, "
//					+ "mdp VARCHAR(20), "
//					+ "direction BOOLEAN,"
//					+ "catherine BOOLEAN,"
//					+ "vanessa BOOLEAN,"
//					+ "claudie BOOLEAN,"
//					+ "marlene BOOLEAN);");
//
//			// Cl�s �trang�res
//
//			s.executeUpdate("ALTER TABLE NOMENCLATURE ADD CONSTRAINT C1 "
//					+ "FOREIGN KEY (id_piece) "
//					+ "REFERENCES PIECE (id_piece) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE NOMENCLATURE ADD CONSTRAINT C2 "
//					+ "FOREIGN KEY (ref) "
//					+ "REFERENCES REFERENCAGE (ref) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE LANCEMENT ADD CONSTRAINT C3 "
//					+ "FOREIGN KEY (id_piece) "
//					+ "REFERENCES PIECE (id_piece) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE LANCEMENT_PROD ADD CONSTRAINT C4 "
//					+ "FOREIGN KEY (id_piece) "
//					+ "REFERENCES PIECE (id_piece) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE PATRON ADD CONSTRAINT C5 "
//					+ "FOREIGN KEY (id_piece) "
//					+ "REFERENCES PIECE (id_piece) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE PATRON ADD CONSTRAINT C6 "
//					+ "FOREIGN KEY (taille) "
//					+ "REFERENCES TAILLES (taille) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE PATRON ADD CONSTRAINT C7 "
//					+ "FOREIGN KEY (ref) "
//					+ "REFERENCES REFERENCAGE (ref) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE RECEP_TISSU ADD CONSTRAINT C8 "
//					+ "FOREIGN KEY (ref) "
//					+ "REFERENCES REFERENCAGE (ref) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE BOITE ADD CONSTRAINT C9 "
//					+ "FOREIGN KEY (id_piece, ref) "
//					+ "REFERENCES NOMENCLATURE (id_piece, ref) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE HOUSSER ADD CONSTRAINT C10 "
//					+ "FOREIGN KEY (id_piece, taille) "
//					+ "REFERENCES LANCEMENT (id_piece, taille) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//
//			s.executeUpdate("ALTER TABLE EXPEDIER ADD CONSTRAINT C11 "
//					+ "FOREIGN KEY (id_piece, taille) "
//					+ "REFERENCES LANCEMENT (id_piece, taille) "
//					+ "ON DELETE CASCADE "
//					+ "ON UPDATE CASCADE;");
//			
//			// Insertion de donn�es
//			
//			s.executeUpdate(" INSERT INTO PIECE (client, modele, tissu, couleur, type) "
//					+ "VALUES ('Celine', '2M07', '645', '', 'jupe'), "
//					+ "('Celine', '2M07', '6139', '', 'jupe'), "
//					+ "('Louis Vuitton', '1123', '24R76', 'noir', 'robe');");
//			
//			s.executeUpdate("INSERT INTO REFERENCAGE (ref, type, estTissu) "
//					+ "VALUES ('MC75261139','tissu principal', true),"
//					+ "('MC100BTPIOCOR15','bouton', false),"
//					+ "('MC100THNX1080','thermocollant', false);");
//			
//			s.executeUpdate("INSERT INTO NOMENCLATURE (id_piece, ref, qte_unit , fact) "
//					+ "VALUES ('Celine2M07645','MC75261139', 2.6, false),"
//					+ "('Celine2M07645','MC100BTPIOCOR15', 2, false),"
//					+ "('Celine2M07645','MC100THNX1080', 0.38, true);");

			//Affichage des tuples de la table
			PreparedStatement ps;
			ps = BDChicEtStyle.getConnexion().prepareStatement("Select * from PIECE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString("id_piece")+" "+rs.getString("client")+" "+rs.getString("modele")+" "+rs.getString("tissu")+" "+rs.getString("couleur")+" "+rs.getString("type"));
			}


			BDChicEtStyle.arretBD();
			System.out.println("terminé !");


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
