package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.Dragon;

public class BDAmourDAO extends DAO<Amour, Dragon, Dragon> {
	
	public void create(Amour amour) throws SQLException {
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String sql = "INSERT INTO AMOURS VALUES" +
				"(" + amour.getAimant().getNomDragon() + ", "+
				amour.getAime().getNomDragon() +"," +
				amour.getForce() +")" ;
		stmt.executeUpdate(sql);
		connection.close();
	}
	
	public Amour findById(Dragon id1, Dragon id2) throws SQLException {
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String sql = "SELECT force FROM AMOURS WHERE aimant = "+ id1.getNomDragon()+
				"AND aime = " + id2.getNomDragon();
		ResultSet result = stmt.executeQuery(sql);
		Amour amour = new Amour();
		if (result.first()) {
			amour = new Amour(result.getString("force"), id1, id2);
		}
		connection.close();
		return amour;
	}

}
