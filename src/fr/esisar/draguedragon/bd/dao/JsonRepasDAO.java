package fr.esisar.draguedragon.bd.dao;

import java.util.List;

import fr.esisar.draguedragon.bd.abstractfactory.RepasDAO;
import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class JsonRepasDAO implements RepasDAO {
	
	public JsonFile jsonfile = JsonFile.getInstance();

	@Override
	public void create(Repas t) {

	}

	@Override
	public Repas findById(RepasId id) {
		return null;
	}

	@Override
	public List<Repas> findAll() {
		return null;
	}

	@Override
	public void delete(Repas t) {

	}

}
