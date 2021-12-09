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
		DragueDragon dragueDragon = jsonFile.loadFile();
		dragueDragon.dragons.add(t);
		jsonFile.saveFile(dragueDragon);
		
	}

	@Override
	public Dragon findById(String id) {
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
		DragueDragon dragueDragon = jsonFile.loadFile();
		List<Dragon> dragons = new ArrayList<Dragon>();
		
		for (Dragon dragon :dragueDragon.dragons) {
			dragons.add(dragon);
		}
		
		return dragons;
	}

	@Override
	public void delete(Dragon t) {
		DragueDragon dragueDragon = jsonFile.loadFile();
		int i;
		for (i=0; i<dragueDragon.dragons.size(); i++) {
			if(dragueDragon.dragons.get(i).getNomDragon().equals(t.getNomDragon())) {
				dragueDragon.dragons.remove(dragueDragon.dragons.get(i));
			}
		}
		
		jsonFile.saveFile(dragueDragon);
	}

}
