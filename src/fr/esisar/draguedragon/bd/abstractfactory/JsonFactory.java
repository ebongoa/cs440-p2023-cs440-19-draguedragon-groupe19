package fr.esisar.draguedragon.bd.abstractfactory;

import fr.esisar.draguedragon.bd.dao.JsonAmourDAO;
import fr.esisar.draguedragon.bd.dao.JsonDragonDAO;
import fr.esisar.draguedragon.bd.dao.JsonNourritureDAO;
import fr.esisar.draguedragon.bd.dao.JsonRepasDAO;

public class JsonFactory implements AbstractFactory {

	@Override
	public AmourDAO createAmourDAO() {
		return new JsonAmourDAO();
	}

	@Override
	public DragonDAO createDragonDAO() {
		return new JsonDragonDAO();
	}

	@Override
	public NourritureDAO createNourritureDAO() {
		return new JsonNourritureDAO();
	}

	@Override
	public RepasDAO createRepasDAO() {
		return new JsonRepasDAO();
	}

}
