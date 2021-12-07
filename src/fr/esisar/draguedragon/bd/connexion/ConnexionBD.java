package fr.esisar.draguedragon.bd.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

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

	public final static ConnexionBD getInstance() {
		synchronized(ConnexionBD.class) {
			if(ConnexionBD.connexionBD==null) {
				ConnexionBD.connexionBD = new ConnexionBD();

			}
		}
		return ConnexionBD.connexionBD;
	}

	public Connection getConnection() {
		return connection;
	}

}

