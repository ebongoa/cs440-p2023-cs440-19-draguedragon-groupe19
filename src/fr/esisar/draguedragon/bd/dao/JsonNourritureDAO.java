package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.NourritureDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Nourriture;

public class JsonNourritureDAO implements NourritureDAO {

	public JsonFile jsonfile = JsonFile.getInstance();
	
	@Override
	public void create(Nourriture t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Nourriture findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nourriture> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Nourriture t) {
		// TODO Auto-generated method stub

	}

}
