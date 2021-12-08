package fr.esisar.draguedragon.bd.factory;

import fr.esisar.draguedragon.bd.dao.BDRepasDAO;
import fr.esisar.draguedragon.bd.dao.DAO;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class BDRepasFactory implements BDFactory<DAO<Repas, RepasId>>{

	@Override
	public DAO<Repas, RepasId> newInstance() {
		return new BDRepasDAO();
	}

}
