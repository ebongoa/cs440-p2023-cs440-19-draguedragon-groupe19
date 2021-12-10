package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.NourritureDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.DragueDragon;
import fr.esisar.draguedragon.entities.Nourriture;

/**
 * Permet de faire les operations de creation, selection, suppression d'un (ou plusieurs) element(s) Nourriture dans un fichier Json
 * @author laurenal
 *
 */
public class JsonNourritureDAO implements NourritureDAO {

	public JsonFile jsonfile = JsonFile.getInstance();
	
	/**
	 * Permet d'ecrire dans un fichier Json un nouvel element Nourriture
	 */
	@Override
	public void create(Nourriture t) {
		DragueDragon draguedragon = jsonfile.loadFile();
		draguedragon.nourritures.add(t);
		jsonfile.saveFile(draguedragon);
	}

	/**
	 * Permet de rechercher un element Nourriture dans un fichier Json et le renvoie
	 */
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

	/**
	 * Permet de recuperer tous les elements Nourriture d'un fichier Json et les stockent dans une List
	 */
	@Override
	public List<Nourriture> findAll() {
		DragueDragon draguedragon = jsonfile.loadFile();
		return draguedragon.nourritures;
	}

	/**
	 * Permet de supprimer un element Nourriture d'un fichier Json
	 */
	@Override
	public void delete(Nourriture t) {
		DragueDragon draguedragon = jsonfile.loadFile();
		int i;
		for(i=0; i<draguedragon.nourritures.size(); i++) {
			if(draguedragon.nourritures.get(i).getNomProduit().equals(t.getNomProduit())){
				draguedragon.nourritures.remove(draguedragon.nourritures.get(i));
			}
		}
		jsonfile.saveFile(draguedragon);
	}

}
