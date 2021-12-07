package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.connexion.ConnexionBD;

public abstract class DAO<T, S> {

	protected ConnexionBD connexionBD;
	
	public ConnexionBD getConnexionBD(){
		return connexionBD;
	}
	
	public void setConnexionBD(ConnexionBD connexionBD) {
		this.connexionBD = connexionBD;
	}

	public DAO(ConnexionBD connexionBD) {
		super();
		this.connexionBD = connexionBD;
	}

	public DAO() {
		super();
		this.connexionBD=ConnexionBD.getInstance();
	}

	public abstract void create(T t);
	
	public abstract T findById(S id);
	
	public abstract List<T> findAll();
	
	public abstract void delete(T t);
}
