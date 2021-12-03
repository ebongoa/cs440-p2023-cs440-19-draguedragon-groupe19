package fr.esisar.draguedragon.bd.dao;

import java.sql.SQLException;
import java.util.List;

import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.Dragon;

public class BDAmourDAO extends DAO<Amour, Dragon> {
	
	public void create(Amour amour) {
	}
	
	public Amour findById(Dragon id1, Dragon id2) throws SQLException {
		return null;
	}

	@Override
	public Amour findById(Dragon id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Amour> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Amour t) {
		// TODO Auto-generated method stub
		
	}

}
