package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.NourritureDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.DragueDragon;
import fr.esisar.draguedragon.entities.Nourriture;
import fr.esisar.draguedragon.entities.Repas;

public class JsonNourritureDAO implements NourritureDAO {

	public JsonFile jsonfile = JsonFile.getInstance();
	
	@Override
	public void create(Nourriture t) {
		DragueDragon draguedragon = jsonfile.loadFile();
		draguedragon.nourritures.add(t);
		jsonfile.saveFile(draguedragon);
	}

	@Override
	public Nourriture findById(String id) {
		DragueDragon draguedragon = jsonfile.loadFile();
		Nourriture nourriture = null;
		for(Nourriture n: draguedragon.nourritures) {
			if(n.getNomProduit().equals(id)){
				nourriture = n;
			}
		} 
		return nourriture;
	}

	@Override
	public List<Nourriture> findAll() {
		DragueDragon draguedragon = jsonfile.loadFile();
		return draguedragon.nourritures;
	}

	@Override
	public void delete(Nourriture t) {
		DragueDragon draguedragon = jsonfile.loadFile();
		for(Nourriture n: draguedragon.nourritures) {
			if(n.getNomProduit().equals(t.getNomProduit())){
				draguedragon.repas.remove(n);
			}
		}
	}

}
