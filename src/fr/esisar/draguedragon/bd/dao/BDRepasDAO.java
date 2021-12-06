package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class BDRepasDAO extends DAO<Repas, RepasId>{
	
	public List<Repas> findAll() {
		return null;
	}
	
	public void delete(Repas repas) {
		
	}

	@Override
	public void create(Repas t) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REPAS VALUES = ?");
			preparedStatement.setInt(1, t.getQuantite());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Repas findById(RepasId id) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM REPAS WHERE Dragon = ? AND Nourriture = ?");
			stmt.setString(1, id.getDragon().getNomDragon());
			stmt.setString(2, id.getNourriture().getNomProduit());
			ResultSet result = stmt.executeQuery();
			result.next();
			Repas repas = new Repas(result.getInt(2), id);
			connection.close();
			return repas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
