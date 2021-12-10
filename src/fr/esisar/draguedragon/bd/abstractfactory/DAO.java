package fr.esisar.draguedragon.bd.abstractfactory;

import java.util.List;

/**
 * 
 * @author laurenal
 *
 * @param <T> T=Dragon pour BDDragonDAO, T=Amour pour BDAmourDAO, T=Nourriture pour BDNourritureDAO, T=Repas pour BDRepasDAO
 * @param <S> S=String pour BDDragonDAO, S=AmourId pour BDAmournDAO, S=String pour BDNourritureDAO, S=RepasId pour BDRepasDAO
 */

public interface DAO<T,S> {
	

	public void create(T t);
	
	public T findById(S id);
	
	public List<T> findAll();
	
	public void delete(T t);
}
