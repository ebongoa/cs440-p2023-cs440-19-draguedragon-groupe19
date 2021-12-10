package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.abstractfactory.NourritureDAO;
import fr.esisar.draguedragon.bd.connexion.ConnexionBD;
import fr.esisar.draguedragon.entities.Nourriture;

//code pour l'utilisation sans AbstractFactory
//public class BDNourritureDAO extends DAO<Nourriture, String> {

/**
 * Permet de faire les operations de creation, selection, suppression sur la table Nourriture de la base de donnee
 * @author laurenal
 *
 */

public class BDNourritureDAO implements NourritureDAO{

	ConnexionBD connexionBD = ConnexionBD.getInstance();
	
	
	/**
	 * Permet d'ecrire dans la base de donnee un nouvel element dans la table Nourriture
	 */
	@Override
	public void create(Nourriture t) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NOURRITURE VALUES(?,?)");
			preparedStatement.setString(1, t.getNomProduit());
			preparedStatement.setLong(2, t.getCalories());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet de rechercher un element dans la table Nourriture de la base de donnee et le renvoie
	 */
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
	
	/**
	 * Permet de recuperer tous les elements de la table Nourriture de la base de donnee et les stockent dans une List
	 */
	@Override
	public List<Nourriture> findAll() {
		Connection connection = connexionBD.getConnection();
		List<Nourriture> nourritures = new ArrayList<Nourriture>();
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM NOURRITURE");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Nourriture nourriture = new Nourriture(resultSet.getString(1), resultSet.getInt(2));
				nourritures.add(nourriture);
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nourritures;		
	}
	
	/**
	 * Permet de supprimer un element de la table Nourriture de la base de donnee
	 */
	@Override
	public void delete(Nourriture nourriture) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM Repas WHERE produit = ?");
			preparedStatement.setString(1, nourriture.getNomProduit());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("DELETE FROM NOURRITURE WHERE produit = ?");
			preparedStatement.setString(1, nourriture.getNomProduit());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
