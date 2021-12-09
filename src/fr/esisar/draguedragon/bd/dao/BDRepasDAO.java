package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.abstractfactory.RepasDAO;
import fr.esisar.draguedragon.bd.connexion.ConnexionBD;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.Nourriture;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

//public class BDRepasDAO extends DAO<Repas,RepasId> {

public class BDRepasDAO implements RepasDAO{
	
	ConnexionBD connexionBD = ConnexionBD.getInstance();
	
	public List<Repas> findAll() {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		List<Repas> listRepas = new ArrayList<Repas>();
		PreparedStatement preparedStatement;	
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM REPAS");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Dragon dragon = new Dragon();
				dragon.setNomDragon(resultSet.getString(1));
				Nourriture nourriture = new Nourriture();
				nourriture.setNomProduit(resultSet.getString(2));
				Repas repas = new Repas(resultSet.getInt(3), new RepasId(dragon, nourriture));
				listRepas.add(repas);
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return listRepas;
	}
	
	public void delete(Repas repas) {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM REPAS WHERE dragon=? AND produit=?");
			preparedStatement.setString(1, repas.getId().getDragon().getNomDragon());
			preparedStatement.setString(2, repas.getId().getNourriture().getNomProduit());
					
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create(Repas t) {
		try {
			Connection connection = connexionBD.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REPAS VALUES(?,?,?)");
			preparedStatement.setString(1, t.getId().getDragon().getNomDragon());
			preparedStatement.setString(2, t.getId().getNourriture().getNomProduit());
			preparedStatement.setInt(3, t.getQuantite());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Repas findById(RepasId id) {
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		Repas repas = new Repas();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM REPAS WHERE dragon=? AND produit=?");
	
			preparedStatement.setString(1, id.getDragon().getNomDragon());
			preparedStatement.setString(2, id.getNourriture().getNomProduit());
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			repas = new Repas(result.getInt("quantite"), id);
			preparedStatement.close();
			return repas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
