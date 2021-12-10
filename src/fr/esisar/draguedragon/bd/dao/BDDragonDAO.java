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


//code pour l'utilisation sans AbstractFactory
//public class BDDragonDAO extends DAO<Dragon, String> {


/**
 * Permet de faire les operations de creation, selection, suppression sur la table Dragon de la base de donnee
 * @author laurenal
 *
 */

public class BDDragonDAO implements DragonDAO {

	ConnexionBD connexionBD = ConnexionBD.getInstance();

	/**
	 * Permet d'ecrire dans la base de donnee un nouvel element dans la table Dragon
	 */
	@Override
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
			e.printStackTrace();
		}
	}

	/**
	 * Permet de rechercher un element dans la table Dragon de la base de donnee et le renvoie
	 */
	@Override
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
	/**
	 * 
	 * @param s valeur recuperer dans la table de donnee (correspond a "O" ou "N"
	 * @return un booleen qui represente si le dragon crache du feu ou non (true si s="O", false sinon)
	 */
	public Boolean testFeu(String s) {
		Boolean cracheFeu = false;
		if(s.equals("O")) {
			cracheFeu = true;
		}
		return cracheFeu;
	}

	/**
	 * Permet de recuperer tous les elements de la table Dragon de la base de donnee et les stockent dans une List
	 */
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

	/**
	 * Permet de supprimer un element de la table Dragon de la base de donnee.
	 * Supprime egalement tous les Repas et Amour etant conserne par le dragon a supprimer
	 */
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
