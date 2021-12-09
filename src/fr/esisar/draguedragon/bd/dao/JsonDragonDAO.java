package fr.esisar.draguedragon.bd.dao;

import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.DragonDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.DragueDragon;

public class JsonDragonDAO implements DragonDAO {

	public JsonFile jsonFile = JsonFile.getInstance();
	
	@Override
	public void create(Dragon t) {
		// TODO Auto-generated method stub
		DragueDragon dragueDragon = jsonFile.loadFile();
		dragueDragon.dragons.add(t);
		jsonFile.saveFile(dragueDragon);
		
	}

	@Override
	public Dragon findById(String id) {
		// TODO Auto-generated method stub
		DragueDragon dragueDragon = jsonFile.loadFile();
		
		for (Dragon dragon :dragueDragon.dragons) {
			if(dragon.getNomDragon().equals(id)) {
				return dragon;
			}
		}
		
		return null;
	}

	@Override
	public List<Dragon> findAll() {
		// TODO Auto-generated method stub
		DragueDragon dragueDragon = jsonFile.loadFile();
		List<Dragon> dragons = new ArrayList<Dragon>();
		
		for (Dragon dragon :dragueDragon.dragons) {
			dragons.add(dragon);
		}
		
		return dragons;
	}

	@Override
	public void delete(Dragon t) {
		// TODO Auto-generated method stub
		DragueDragon dragueDragon = jsonFile.loadFile();
		int i = 0;
		for (Dragon dragon :dragueDragon.dragons) {
			if(dragon.equals(t)) {
				dragueDragon.dragons.remove(i);
			}
			i++;
		}
		
		jsonFile.saveFile(dragueDragon);
	}

}
