package fr.esisar.draguedragon.bd.factory;

import fr.esisar.draguedragon.bd.dao.BDDragonDAO;
import fr.esisar.draguedragon.bd.dao.DAO;
import fr.esisar.draguedragon.entities.Dragon;

public class BDDragonFactory implements BDFactory<DAO<Dragon, String>>{

	@Override
	public DAO<Dragon, String> newInstance() {
		// TODO Auto-generated method stub
		return new BDDragonDAO();
	}

}
