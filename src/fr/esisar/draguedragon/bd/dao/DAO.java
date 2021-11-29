package fr.esisar.draguedragon.bd.dao;

import java.sql.SQLException;
import java.util.List;

import fr.esisar.draguedragon.bd.connexion.ConnexionBD;

public abstract class DAO<T, S> {

	protected ConnexionBD connexionBD = ConnexionBD.getInstance();
	
	public abstract void create(T t) throws SQLException;
	
	public abstract T findById(S id) throws SQLException;
	
	public abstract List<T> findAll();
	
	public abstract void delete(T t);
}
