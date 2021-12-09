package fr.esisar.draguedragon.bd.abstractfactory;

import java.util.List;

public interface DAO<T,S> {
	
	public void create(T t);
	
	public T findById(S id);
	
	public List<T> findAll();
	
	public void delete(T t);
}
