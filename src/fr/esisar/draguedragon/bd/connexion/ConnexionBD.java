package fr.esisar.draguedragon.bd.connexion;

import java.sql.Connection;

public class ConnexionBD {

	private static ConnexionBD connexionBD;
	
	private Connection connection;

	private ConnexionBD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ConnexionBD getInstance() {
		return connexionBD;
	}

	public Connection getConnection() {
		return connection;
	}

}
