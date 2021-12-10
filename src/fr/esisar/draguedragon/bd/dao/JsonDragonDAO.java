package fr.esisar.draguedragon.bd.dao;

import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.DragonDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.DragueDragon;

/**
 * Permet de faire les operations de creation, selection, suppression d'un (ou plusieurs) element(s) Dragon dans un fichier Json
 * @author laurenal
 *
 */
public class JsonDragonDAO implements DragonDAO {

	public JsonFile jsonFile = JsonFile.getInstance();
	
	/**
	 * Permet d'ecrire dans un fichier Json un nouvel element Dragon
	 */
	@Override
	public void create(Dragon t) {
		DragueDragon dragueDragon = jsonFile.loadFile();
		dragueDragon.dragons.add(t);
		jsonFile.saveFile(dragueDragon);
		
	}

	/**
	 * Permet de rechercher un element Dragon dans un fichier Json et le renvoie
	 */
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

	/**
	 * Permet de recuperer tous les elements Dragon d'un fichier Json et les stockent dans une List
	 */
	@Override
	public List<Dragon> findAll() {
		DragueDragon dragueDragon = jsonFile.loadFile();
		List<Dragon> dragons = new ArrayList<Dragon>();
		
		for (Dragon dragon :dragueDragon.dragons) {
			dragons.add(dragon);
		}
		
		return dragons;
	}

	/**
	 * Permet de supprimer un element Dragon d'un fichier Json
	 */
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
