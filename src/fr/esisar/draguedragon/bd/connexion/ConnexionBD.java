package fr.esisar.draguedragon.bd.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Cette classe initie la connexion avec la base de donnees.
 * 
 * @author laurenal
 *
 */

public final class ConnexionBD {

	private static ConnexionBD connexionBD = null;

	private Connection connection;

	private ConnexionBD(){
		super();
		try {
			Class.forName(Constants.DRIVER);
			this.connection = DriverManager.getConnection(Constants.URL, Constants.LOGIN, Constants.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return Une connexionBD vers la base de donnee (a avant si elle n'existe pas deja)
	 */
	public final static ConnexionBD getInstance() {
		synchronized(ConnexionBD.class) {
			if(ConnexionBD.connexionBD==null) {
				ConnexionBD.connexionBD = new ConnexionBD();

			}
		}
		return ConnexionBD.connexionBD;
	}
	/**
	 * 
	 * @return La connexion a la base de donnee
	 */
	public Connection getConnection() {
		return connection;
	}

}

