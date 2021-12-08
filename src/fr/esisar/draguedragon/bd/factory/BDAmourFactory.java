package fr.esisar.draguedragon.bd.factory;

import fr.esisar.draguedragon.bd.dao.BDAmourDAO;
import fr.esisar.draguedragon.bd.dao.DAO;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;

public class BDAmourFactory implements BDFactory<DAO<Amour, AmourId>>{

	@Override
	public DAO<Amour, AmourId> newInstance() {
		// TODO Auto-generated method stub
		return new BDAmourDAO();
	}

}
