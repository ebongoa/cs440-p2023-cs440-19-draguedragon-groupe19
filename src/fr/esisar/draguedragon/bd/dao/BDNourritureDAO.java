package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.entities.Nourriture;

public class BDNourritureDAO extends DAO<Nourriture, String>{

	@Override
	public void create(Nourriture t) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NOURRITURE VALUES = ?");
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
			stmt = connection.prepareStatement("SELECT * FROM NOURRITURE WHERE produit = ?");
			stmt.setString(1, nomProduit);
			ResultSet result = stmt.executeQuery();
			result.next();
			Nourriture nourriture = new Nourriture(nomProduit, result.getInt(2));
			stmt.close();
			return nourriture;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	
	@Override
	public List<Nourriture> findAll() {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		List<Nourriture> nourritures = new ArrayList<Nourriture>();
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM NOURRITURE");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Nourriture nourriture = new Nourriture(resultSet.getString(1), resultSet.getInt(1));
				nourritures.add(nourriture);
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nourritures;		
	}
	
	
	@Override
	public void delete(Nourriture nourriture) {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE * FROM NOURRITURE WHERE produit = ?");
			preparedStatement.setString(1, nourriture.getNomProduit());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
