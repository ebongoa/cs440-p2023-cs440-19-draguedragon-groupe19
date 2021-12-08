package fr.esisar.draguedragon.bd.factory;

import fr.esisar.draguedragon.bd.dao.BDAmourDAO;
import fr.esisar.draguedragon.bd.dao.BDDragonDAO;
import fr.esisar.draguedragon.bd.dao.DAO;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;

public class BDFactory {
	
	public DAO<Amour, AmourId> getBDAmourDAO() {
		return new BDAmourDAO();
	}
	
	public DAO<Dragon, String> getBDDragonDAO() {
		return new BDDragonDAO();
	}

}
