package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.esisar.draguedragon.entities.Dragon;

public class BDDragonDAO extends DAO<Dragon, String> {

	public void create(Dragon dragon) throws SQLException {
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String cracheFeu = "N";
		if(dragon.getCracheFeu()) {
			cracheFeu = "O";
		}
		String sql = "INSERT INTO DRAGON VALUES "+
				"("+dragon.getNomDragon()+", "+
				dragon.getSexe()+", "+
				dragon.getLongeur()+", "+
				dragon.getEcailles()+", "+
				cracheFeu+", "+
				dragon.getEnAmour()+")" ;
		stmt.executeUpdate(sql);
		connection.close();
	}
	
	public Dragon findById(String nom) throws SQLException {
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM DRAGON WHERE nom = "+ nom;
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
			dragon = new Dragon(nom, sexe, longueur, ecailles, cracheFeu, enAmour);
		}
		connection.close();
		return dragon;
	}

	@Override
	public List<Dragon> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Dragon t) {
		// TODO Auto-generated method stub
		
	}
}
