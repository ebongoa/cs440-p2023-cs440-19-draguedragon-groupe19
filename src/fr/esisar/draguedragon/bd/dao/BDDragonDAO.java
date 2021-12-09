package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.abstractfactory.DragonDAO;
import fr.esisar.draguedragon.bd.connexion.ConnexionBD;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.Nourriture;


//public class BDDragonDAO extends DAO<Dragon, String> {

public class BDDragonDAO implements DragonDAO {

	ConnexionBD connexionBD = ConnexionBD.getInstance();
	
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
		PreparedStatement preparedStatement;
		Dragon dragon = new Dragon();
		try {
			preparedStatement = connexionBD.getConnection().prepareStatement("SELECT * FROM DRAGON WHERE nom=?");
			preparedStatement.setString(1, nomDragon);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			
			dragon.setNomDragon(nomDragon);
			dragon.setSexe(resultSet.getString("sexe"));
			dragon.setCracheFeu(testFeu(resultSet.getString("cracheFeu")));
			dragon.setLongeur(resultSet.getFloat("longueur"));
			dragon.setEcailles(resultSet.getInt("ecailles"));
			dragon.setEnAmour(resultSet.getString("enAmour"));

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dragon;	
	}

	public Boolean testFeu(String s) {
		Boolean cracheFeu = false;
		if(s.equals("O")) {
			cracheFeu = true;
		}
		return cracheFeu;
	}

	@Override
	public List<Dragon> findAll() {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		List<Dragon> dragons = new ArrayList<Dragon>();
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM DRAGON");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Dragon dragon = new Dragon(resultSet.getString("nom"),resultSet.getString("sexe"), resultSet.getFloat("longueur"),resultSet.getInt("ecailles"),testFeu(resultSet.getString("cracheFeu")),resultSet.getString("enAmour"));
				dragons.add(dragon);
			}

			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return dragons;	
	}

	@Override
	public void delete(Dragon dragon) {
		// TODO Auto-generated method stub
		Connection connection = connexionBD.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM AMOURS WHERE AIMANT = ? OR AIME = ?");
			preparedStatement.setString(1, dragon.getNomDragon());
			preparedStatement.setString(2, dragon.getNomDragon());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("DELETE FROM REPAS WHERE DRAGON = ?");
			preparedStatement.setString(1, dragon.getNomDragon());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("DELETE FROM DRAGON WHERE nom = ?");
			preparedStatement.setString(1, dragon.getNomDragon());	
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
