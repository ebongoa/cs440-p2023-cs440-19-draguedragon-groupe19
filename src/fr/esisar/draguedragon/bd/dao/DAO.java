package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.connexion.ConnexionBD;
 /**
  * 
  * @author laurenal
  *
 * @param <T> T=Dragon pour BDDragonDAO, T=Amour pour BDAmourDAO, T=Nourriture pour BDNourritureDAO, T=Repas pour BDRepasDAO
 * @param <S> S=String pour BDDragonDAO, S=AmourId pour BDAmournDAO, S=String pour BDNourritureDAO, S=RepasId pour BDRepasDAO
  */
public abstract class DAO<T, S> {

	protected ConnexionBD connexionBD;

	public DAO(ConnexionBD connexionBD) {
		super();
		this.connexionBD = connexionBD;
	}

	public DAO() {
		super();
		this.connexionBD=ConnexionBD.getInstance();
	}

	/**
	 * 
	 * @param t Dragon, Amour, Nourriture ou Repas en fonction de ce que l'on veux créer
	 */
	public abstract void create(T t);
	
	/**
	 * 
	 * @param id nomDragon, AmourId, nomProduit ou RepasId en fonction de ce que l'on recherche
	 * @return Dragon, Amour, Nourriture ou Repas en fonction de ce que l'on recherche
	 */
	public abstract T findById(S id);
	
	/**
	 * 
	 * @return List<Dragon>, List<Amour>, List<Nourriture> ou List<Repas> en fonction de ce que l'on recherche
	 */
	public abstract List<T> findAll();
	
	/**
	 * 
	 * @param t Dragon, Amour, Nourriture ou Repas en fonction de ce que l'on veux supprimer
	 */
	public abstract void delete(T t);
	
	public ConnexionBD getConnexionBD(){
		return connexionBD;
	}
	
	public void setConnexionBD(ConnexionBD connexionBD) {
		this.connexionBD = connexionBD;
	}
}
