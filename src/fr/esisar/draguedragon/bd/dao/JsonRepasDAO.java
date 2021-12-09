package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.RepasDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.DragueDragon;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class JsonRepasDAO implements RepasDAO {
	
	public JsonFile jsonfile = JsonFile.getInstance();

	@Override
	public void create(Repas t) {
		DragueDragon draguedragon = jsonfile.loadFile();
		draguedragon.repas.add(t);
		jsonfile.saveFile(draguedragon);
	}

	@Override
	public Repas findById(RepasId id) {
		DragueDragon draguedragon = jsonfile.loadFile();
		Repas repas = null;
		for(Repas r: draguedragon.repas) {
			if(r.getId().equals(id)){
				repas = r;
			}
		} 
		return repas;
	}

	@Override
	public List<Repas> findAll() {
		DragueDragon draguedragon = jsonfile.loadFile();
		return draguedragon.repas;
	}

	@Override
	public void delete(Repas t) {
		DragueDragon draguedragon = jsonfile.loadFile();
		int i;
		for(i=0; i<draguedragon.repas.size(); i++) {
			if(draguedragon.repas.get(i).getId().equals(t.getId())){
				draguedragon.repas.remove(draguedragon.repas.get(i));
			}
		} 
		jsonfile.saveFile(draguedragon);
	}

}
