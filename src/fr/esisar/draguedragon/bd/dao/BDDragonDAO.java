package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.esisar.draguedragon.entities.Dragon;

public class BDDragonDAO extends DAO<Dragon, String> {

	public void create(Dragon dragon) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO DRAGON VALUES(?,?,?,?,?,?)");
			
			String cracheFeu = "N";
			if(dragon.getCracheFeu()) {
				cracheFeu = "O";
			}
			preparedStatement.setString(1, dragon.getNomDragon());
			preparedStatement.setString(2, dragon.getSexe());
			preparedStatement.setFloat(3, dragon.getLongeur());
			preparedStatement.setInt(4, dragon.getEcailles());
			preparedStatement.setString(5, cracheFeu);
			preparedStatement.setString(6, dragon.getEnAmour());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dragon findById(String nomDragon) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		Dragon dragon = new Dragon();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM DRAGON WHERE nom = ?");
			preparedStatement.setString(1, nomDragon);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			Boolean cracheFeu = false;
			if(resultSet.getString(5).equals("O")) {
				cracheFeu = true;
			}
			dragon = new Dragon(nom, resultSet.getString(2), resultSet.getFloat(3), resultSet.getInt(4), cracheFeu, resultSet.getString(6));
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dragon;	
	}

	@Override
	public List<Dragon> findAll() {
		
		return null;
	}

	@Override
	public void delete(Dragon t) {
		
		
	}
}
