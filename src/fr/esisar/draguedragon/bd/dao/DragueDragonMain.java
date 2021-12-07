package fr.esisar.draguedragon.bd.dao;

import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.Nourriture;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class DragueDragonMain {

	public static void main(String[] args) {
		
		DAO<Dragon, String> dragonDAO= new BDDragonDAO();
		DAO<Amour, AmourId> amourDAO= new BDAmourDAO();
		DAO<Nourriture, String> nourritureDAO= new BDNourritureDAO();
		DAO<Repas, RepasId> repasDAO= new BDRepasDAO();
		
		Dragon aimant = new Dragon();
		aimant.setNomDragon("Smeaghol");
		Dragon aime = new Dragon();
		aime.setNomDragon("Tarak");
		
		Nourriture nourriture = new Nourriture("Pomme",7);
		
		System.out.println(dragonDAO.findById("Smeaghol"));
//		System.out.println(amourDAO.findById(new AmourId(aimant,aime)));
//		System.out.println(nourritureDAO.findById("Pomme"));
//		System.out.println(repasDAO.findById(new RepasId(aimant, nourriture)));
		
	}

}
