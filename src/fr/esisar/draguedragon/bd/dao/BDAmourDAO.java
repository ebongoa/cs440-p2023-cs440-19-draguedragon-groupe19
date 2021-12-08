package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;


public class BDAmourDAO extends DAO<Amour, AmourId> {

	@Override
	public void create(Amour t) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Amour findById(AmourId id) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amour;
	}

	@Override
	public List<Amour> findAll() {
		// TODO Auto-generated method stub
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return amours;	
	}

	@Override
	public void delete(Amour amour) {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM AMOURS WHERE aimant = ? AND  aime = ?");
			preparedStatement.setString(1, amour.getAmourId().getAimant().getNomDragon());
			preparedStatement.setString(2, amour.getAmourId().getAime().getNomDragon());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
