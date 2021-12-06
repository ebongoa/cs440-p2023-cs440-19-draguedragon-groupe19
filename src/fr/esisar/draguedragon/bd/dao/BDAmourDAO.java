package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;


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
		return null;
	}

	@Override
	public void delete(Amour t) {
		// TODO Auto-generated method stub
		
	}
	
}
