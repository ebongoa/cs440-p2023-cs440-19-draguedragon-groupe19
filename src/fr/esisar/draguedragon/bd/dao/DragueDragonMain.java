package fr.esisar.draguedragon.bd.dao;

import java.io.File;

import fr.esisar.draguedragon.bd.connexion.JsonFile;
//import fr.esisar.draguedragon.bd.factory.BDAmourFactory;
//import fr.esisar.draguedragon.bd.factory.BDDragonFactory;
import fr.esisar.draguedragon.bd.abstractfactory.BDFactory;
import fr.esisar.draguedragon.bd.abstractfactory.RepasDAO;
//import fr.esisar.draguedragon.bd.factory.BDNourritureFactory;
//import fr.esisar.draguedragon.bd.factory.BDRepasFactory;
import fr.esisar.draguedragon.entities.Amour;
import fr.esisar.draguedragon.entities.AmourId;
import fr.esisar.draguedragon.entities.Dragon;
import fr.esisar.draguedragon.entities.DragueDragon;
import fr.esisar.draguedragon.entities.Nourriture;
import fr.esisar.draguedragon.entities.Repas;
import fr.esisar.draguedragon.entities.RepasId;

public class DragueDragonMain {

	public static void main(String[] args) {
		
		BDFactory BDfactory = new BDFactory();
		RepasDAO repastest = BDfactory.createRepasDAO();
		Dragon dragon =new Dragon("test","M",(float)15.0,1567,true,"Passionne");
		Nourriture nourriture = new Nourriture("tacos",5555);
		Repas repas = new Repas(12,new RepasId(dragon,nourriture));
		JsonRepasDAO test = new JsonRepasDAO();
		test.create(repas);
		System.out.println("fin");
		
		
		
//		BDAmourFactory amourFactory = new BDAmourFactory();
//		BDDragonFactory dragonFactory = new BDDragonFactory();
//		BDNourritureFactory nourritureFactory = new BDNourritureFactory();
//		BDRepasFactory repasFactory = new BDRepasFactory();
		
//		DAO<Dragon, String> dragonDAO= dragonFactory.newInstance();
//		DAO<Amour, AmourId> amourDAO= amourFactory.newInstance();
//		DAO<Nourriture, String> nourritureDAO= nourritureFactory.newInstance();
//		DAO<Repas, RepasId> repasDAO= repasFactory.newInstance();
//		
//		Dragon aimant = new Dragon();
//		aimant.setNomDragon("Smeaghol");
//		aimant.setSexe("M");
//		aimant.setCracheFeu(true);
//		aimant.setLongeur((float)152);;
//		aimant.setEcailles(1857);
//		aimant.setEnAmour("Macho");
//
//		Dragon aime = new Dragon();
//		aime.setNomDragon("Tarak");
//		Nourriture nourriture = new Nourriture("Pomme",7);		
		
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
