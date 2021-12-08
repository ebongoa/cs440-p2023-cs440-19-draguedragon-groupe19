package fr.esisar.draguedragon.bd.dao;

import fr.esisar.draguedragon.bd.factory.BDFactory;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.Nourriture;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class DragueDragonMain {

	public static void main(String[] args) {
		
//		DAO<Dragon, String> dragonDAO= factory.getBDDragonDAO();
//		DAO<Amour, AmourId> amourDAO= factory.getBDAmourDAO();
//		DAO<Nourriture, String> nourritureDAO= factory.getBDNourritureDAO();
//		DAO<Repas, RepasId> repasDAO= factory.getBDRepasDAO();
		
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
//		
//		System.out.println("Taille table Dragon = " + dragonDAO.findAll().size());
//		System.out.println("Taille table Amour = " + amourDAO.findAll().size());
//		System.out.println("Taille table Nourriture = " + nourritureDAO.findAll().size());
//		System.out.println("Taille table Repas = " + repasDAO.findAll().size());
//		
//		dragonDAO.delete(aimant);
//		amourDAO.delete(new Amour("un peu",new AmourId(aimant,aime)));
//		nourritureDAO.delete(nourriture);
//		repasDAO.delete(new Repas(16, new RepasId(aimant, nourriture)));
//
//		System.out.println("Taille table Dragon = " + dragonDAO.findAll().size());
//		System.out.println("Taille table Amour = " + amourDAO.findAll().size());
//		System.out.println("Taille table Nourriture = " + nourritureDAO.findAll().size());
//		System.out.println("Taille table Repas = " + repasDAO.findAll().size());
//		
//		dragonDAO.create(aimant);
//		amourDAO.create(new Amour("un peu",new AmourId(aimant,aime)));
//		nourritureDAO.create(nourriture);
//		repasDAO.create(new Repas(16, new RepasId(aimant, nourriture)));
//		
//		System.out.println("Taille table Dragon = " + dragonDAO.findAll().size());
//		System.out.println("Taille table Amour = " + amourDAO.findAll().size());
//		System.out.println("Taille table Nourriture = " + nourritureDAO.findAll().size());
//		System.out.println("Taille table Repas = " + repasDAO.findAll().size());
		
	}

}
