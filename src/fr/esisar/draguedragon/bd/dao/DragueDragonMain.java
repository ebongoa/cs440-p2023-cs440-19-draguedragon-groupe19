package fr.esisar.draguedragon.bd.dao;

import java.util.List;
import java.util.ArrayList;

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
		aimant.setSexe("M");
		aimant.setCracheFeu(true);
		aimant.setLongeur((float)152);;
		aimant.setEcailles(1857);
		aimant.setEnAmour("Macho");

		Dragon aime = new Dragon();
		aime.setNomDragon("Tarak");
		Nourriture nourriture = new Nourriture("Pomme",7);		
		
//		System.out.println(dragonDAO.findById("Smeaghol"));
//		System.out.println(amourDAO.findById(new AmourId(aimant,aime)));
//		System.out.println(nourritureDAO.findById("Pomme"));
//		System.out.println(repasDAO.findById(new RepasId(aimant, nourriture)));
		
//		System.out.println(dragonDAO.findAll().size());
//		System.out.println(amourDAO.findAll().size());
//		System.out.println(nourritureDAO.findAll().size());
//		System.out.println(repasDAO.findAll().size());
		
//		dragonDAO.delete(aimant);
//		amourDAO.delete(new Amour("un peu",new AmourId(aimant,aime)));
//		nourritureDAO.delete(nourriture);
//		repasDAO.delete(new Repas(16, new RepasId(aimant, nourriture)));

//		System.out.println(dragonDAO.findAll().size());
//		System.out.println(amourDAO.findAll().size());
//		System.out.println(nourritureDAO.findAll().size());
//		System.out.println(repasDAO.findAll().size());
		
//		dragonDAO.create(aimant);
//		amourDAO.create(new Amour("un peu",new AmourId(aimant,aime)));
//		nourritureDAO.create(nourriture);
//		repasDAO.create(new Repas(16, new RepasId(aimant, nourriture)));
		
//		System.out.println(dragonDAO.findAll().size());
//		System.out.println(amourDAO.findAll().size());
//		System.out.println(nourritureDAO.findAll().size());
//		System.out.println(repasDAO.findAll().size());
		
	}

}
