package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.connexion.ConnexionBD;

public abstract class DAO<T, S> {

	protected ConnexionBD connexionBD = ConnexionBD.getInstance();
	
	public abstract void create(T t);
	
	public abstract T findById(S id);
	
	public abstract List<T> findAll();
	
	public abstract void delete(T t);
}
