package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.connexion.ConnexionBD;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;

//code pour l'utilisation sans AbstractFactory
// public class BDAmourDAO extends DAO<Amour, AmourId> {

/** 
 * Permet de faire les operations de creation, selection, suppression sur la table Amour de la base de donnee
 * @author laurenal
 *
 */


public class BDAmourDAO implements AmourDAO {
	
	ConnexionBD connexionBD = ConnexionBD.getInstance();
	
	/**
	 * Permet d'ecrire dans la base de donnee un nouvel element dans la table Amour
	 */
	@Override
	public void create(Amour t) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO AMOURS VALUES(?,?,?)");
			preparedStatement.setString(1, t.getAmourId().getAimant().getNomDragon());
			preparedStatement.setString(2, t.getAmourId().getAime().getNomDragon());
			preparedStatement.setString(3, t.getForce());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Permet de rechercher un element dans la table Amour de la base de donnee et le renvoie
	 */
	@Override
	public Amour findById(AmourId id) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		Amour amour = new Amour();
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM AMOURS WHERE aime=? AND aimant=?");
			preparedStatement.setString(1, id.getAime().getNomDragon());
			preparedStatement.setString(2, id.getAimant().getNomDragon());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			amour = new Amour(resultSet.getString(3), id);
			 
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amour;
	}

	/**
	 * Permet de recuperer tous les elements de la table Amour de la base de donnee et les stockent dans une List
	 */
	@Override
	public List<Amour> findAll() {
				Connection connection = connexionBD.getConnection();
				List<Amour> amours = new ArrayList<Amour>();
				PreparedStatement preparedStatement;
				
				try {
					preparedStatement = connection.prepareStatement("SELECT * FROM AMOURS");
					ResultSet resultSet = preparedStatement.executeQuery();

					while(resultSet.next()) {
						Dragon aimant = new Dragon();
						Dragon aime = new Dragon();
						aimant.setNomDragon(resultSet.getString(1));
						aimant.setNomDragon(resultSet.getString(2));
						Amour amour = new Amour(resultSet.getString(3), new AmourId(aimant, aime));
						amours.add(amour);
					}
					
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return amours;	
	}

	
	/**
	 * Permet de supprimer un element de la table Amour de la base de donnee
	 */
	@Override
	public void delete(Amour amour) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM AMOURS WHERE aimant = ? AND  aime = ?");
			preparedStatement.setString(1, amour.getAmourId().getAimant().getNomDragon());
			preparedStatement.setString(2, amour.getAmourId().getAime().getNomDragon());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
