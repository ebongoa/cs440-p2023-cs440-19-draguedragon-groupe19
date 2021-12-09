package fr.esisar.draguedragon.bd.dao;

import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.DragueDragon;

public class JsonAmourDAO implements AmourDAO {

	public JsonFile jsonFile = JsonFile.getInstance();
	
	@Override
	public void create(Amour t) {
		DragueDragon dragueDragon = jsonFile.loadFile();
		dragueDragon.amours.add(t);
		jsonFile.saveFile(dragueDragon);
		
	}

	@Override
	public Amour findById(AmourId id) {
		DragueDragon dragueDragon = jsonFile.loadFile();
		
		for (Amour amour :dragueDragon.amours) {
			if(amour.getAmourId().equals(id)) {
				return amour;
			}
		}
		
		return null;
	}

	@Override
	public List<Amour> findAll() {
		DragueDragon dragueDragon = jsonFile.loadFile();
		List<Amour> amours = new ArrayList<Amour>();
		
		for (Amour amour :dragueDragon.amours) {
			amours.add(amour);
		}
		
		return amours;
	}

	@Override
	public void delete(Amour t) {
		DragueDragon dragueDragon = jsonFile.loadFile();
		int i;
		for (i=0; i<dragueDragon.amours.size(); i++) {
			if(dragueDragon.amours.get(i).getAmourId().equals(t.getAmourId())) {
				dragueDragon.amours.remove(dragueDragon.amours.get(i));
			}
		}
		
		jsonFile.saveFile(dragueDragon);
	}

}
