package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.Dragon;

public class BDDragonDAO extends DAO<Dragon, String> {

	public void create(Dragon dragon) throws SQLException {
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String cracheFeu = "N";
		if(dragon.getCracheFeu) {
			cracheFeu = "O";
		}
		String sql = "INSERT INTO DRAGON VALUES "+
				"("+dragon.getNomDragon()+", "+
				dragon.getSexe()+", "+
				dragon.getLongueur()+", "+
				dragon.getEcailles()+", "+
				cracheFeu+", "+
				dragon.getEnAmour()+")" ;
		stmt.executeUpdate(sql);
		connection.close();
	}
	
	public Dragon findById(String id) throws SQLException {
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM DRAGON WHERE nom = "+ id;
		ResultSet result = stmt.executeQuery(sql);
		Dragon dragon =new Dragon();
		if (result.first()) {
			String sexe = result.getString("sexe");
			Float longueur = result.getFloat("longueur");
			Integer ecailles = result.getInt("ecailles");
			Boolean cracheFeu = false;
			if(result.getString("cracheFeu").equals("O")) {
				cracheFeu = true;
			}
			String enAmour = result.getString("enAmour");
			dragon = new Dragon(id, sexe, longueur, ecailles, cracheFeu, enAmour);
		}
		connection.close();
		return dragon;
	}
}
