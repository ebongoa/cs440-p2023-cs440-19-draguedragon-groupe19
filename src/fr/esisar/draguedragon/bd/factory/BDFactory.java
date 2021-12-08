package fr.esisar.draguedragon.bd.factory;

public interface BDFactory<T> {
	
	public T newInstance();

	public DAO<Nourriture, String> getBDNourritureDAO() {
		return new BDNourritureDAO();
	}

	public DAO<Repas, RepasId> getBDRepasDAO() {
		return new BDRepasDAO();
	}

}

