package fr.esisar.draguedragon.bd.factory;

import fr.esisar.draguedragon.bd.dao.BDNourritureDAO;
import fr.esisar.draguedragon.bd.dao.BDRepasDAO;
import fr.esisar.draguedragon.bd.dao.DAO;
import fr.esisar.draguedragon.entities.Nourriture;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class BDFactory {

		public DAO<Nourriture, String> getBDNourritureDAO() {
			return new BDNourritureDAO();
		}
		
		public DAO<Repas, RepasId> getBDRepasDAO() {
			return new BDRepasDAO();
		}
		
}