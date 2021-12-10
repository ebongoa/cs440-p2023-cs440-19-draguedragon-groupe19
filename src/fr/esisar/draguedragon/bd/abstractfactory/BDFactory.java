package fr.esisar.draguedragon.bd.abstractfactory;

import fr.esisar.draguedragon.bd.dao.BDAmourDAO;
import fr.esisar.draguedragon.bd.dao.BDDragonDAO;
import fr.esisar.draguedragon.bd.dao.BDNourritureDAO;
import fr.esisar.draguedragon.bd.dao.BDRepasDAO;

/**
 * Implemente les methodes de creation des differents BD...DAO
 * 
 * @author laurenal
 *
 */

public class BDFactory implements AbstractFactory{

	@Override
	public AmourDAO createAmourDAO() {
		return new BDAmourDAO();
	}

	@Override
	public DragonDAO createDragonDAO() {
		return new BDDragonDAO();
	}

	@Override
	public NourritureDAO createNourritureDAO() {
		return new BDNourritureDAO();
	}

	@Override
	public RepasDAO createRepasDAO() {
		return new BDRepasDAO();
	}

}
