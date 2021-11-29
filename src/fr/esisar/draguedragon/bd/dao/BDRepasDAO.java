package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.Repas;

public class BDRepasDAO extends DAO<Repas, Dragon>{
	
	public List<Repas> findAll() {
		return null;
	}
	
	public void delete(Repas repas) {
		
	}

	@Override
	public void create(Repas t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Repas findById(Dragon id) {
		// TODO Auto-generated method stub
		return null;
	}

}
