package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;

public class JsonAmourDAO implements AmourDAO {

	public JsonFile jsonfile = JsonFile.getInstance();
	
	@Override
	public void create(Amour t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Amour findById(AmourId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Amour> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Amour t) {
		// TODO Auto-generated method stub

	}

}
