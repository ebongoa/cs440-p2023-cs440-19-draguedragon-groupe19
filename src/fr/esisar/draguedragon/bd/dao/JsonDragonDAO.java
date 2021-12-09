package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.DragonDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Dragon;

public class JsonDragonDAO implements DragonDAO {

	public JsonFile jsonfile = JsonFile.getInstance();
	
	@Override
	public void create(Dragon t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dragon findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dragon> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Dragon t) {
		// TODO Auto-generated method stub

	}

}
