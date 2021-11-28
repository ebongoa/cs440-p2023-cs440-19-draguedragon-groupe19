package fr.esisar.draguedragon.bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BDRepasDAO extends DAO<Repas, Dragon, Produit>{
	
	public List<Repas> findAll() {
		List<Repas> repas = null;
		Connection connection = connexionBD.getConnection();
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM REPAS";
		ResultSet res = stmt.executeQuery(sql);
		while(res.next()) {
			repas.add(new Repas(res.getInt("quantite"), res.))
		}
	}
	
	public void delete(Repas repas) {
		
	}

}
