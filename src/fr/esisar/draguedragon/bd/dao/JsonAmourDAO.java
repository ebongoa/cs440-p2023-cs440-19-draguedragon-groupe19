package fr.esisar.draguedragon.bd.dao;

import java.util.ArrayList;
import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.DragueDragon;


/**
 * Permet de faire les operations de creation, selection, suppression d'un (ou plusieurs) element(s) Amour dans un fichier Json
 * @author laurenal
 *
 */
public class JsonAmourDAO implements AmourDAO {

	public JsonFile jsonFile = JsonFile.getInstance();
	
	/**
	 * Permet d'ecrire dans un fichier Json un nouvel element Amour
	 */
	@Override
	public void create(Amour t) {
		DragueDragon dragueDragon = jsonFile.loadFile();
		dragueDragon.amours.add(t);
		jsonFile.saveFile(dragueDragon);
		
	}

	/**
	 * Permet de rechercher un element Amour dans un fichier Json et le renvoie
	 */
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

	/**
	 * Permet de recuperer tous les elements Amour d'un fichier Json et les stockent dans une List
	 */
	@Override
	public List<Amour> findAll() {
		DragueDragon dragueDragon = jsonFile.loadFile();
		List<Amour> amours = new ArrayList<Amour>();
		
		for (Amour amour :dragueDragon.amours) {
			amours.add(amour);
		}
		
		return amours;
	}

	/**
	 * Permet de supprimer un element Amour d'un fichier Json
	 */
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
