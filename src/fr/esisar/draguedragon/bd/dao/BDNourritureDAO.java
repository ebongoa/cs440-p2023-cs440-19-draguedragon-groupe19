package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.esisar.draguedragon.entities.Nourriture;

public class BDNourritureDAO extends DAO<Nourriture, String>{

	public List<Nourriture> findAll() {
		return null;
		
	}
	
	public void delete(Nourriture nourriture) {
		
	}

	@Override
	public void create(Nourriture t) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DRAGON VALUES = ?");
			preparedStatement.setString(1, t.getNomProduit());
			preparedStatement.setLong(2, t.getCalories());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Nourriture findById(String nomProduit) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement stmt;
			stmt = connection.prepareStatement("SELECT * FROM Nourriture WHERE nomProduit = ?");
			stmt.setString(1, nomProduit);
			ResultSet result = stmt.executeQuery();
			result.next();
			Nourriture nourriture = new Nourriture(nomProduit, result.getInt(2));
			connection.close();
			return nourriture;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
