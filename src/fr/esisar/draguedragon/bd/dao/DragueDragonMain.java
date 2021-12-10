package fr.esisar.draguedragon.bd.dao;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.esisar.draguedragon.bd.connexion.JsonFile;
import fr.esisar.draguedragon.bd.abstractfactory.AmourDAO;
//import fr.esisar.draguedragon.bd.factory.BDAmourFactory;
//import fr.esisar.draguedragon.bd.factory.BDDragonFactory;
import fr.esisar.draguedragon.bd.abstractfactory.BDFactory;
import fr.esisar.draguedragon.bd.abstractfactory.DragonDAO;
import fr.esisar.draguedragon.bd.abstractfactory.JsonFactory;
import fr.esisar.draguedragon.bd.abstractfactory.NourritureDAO;
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


/**
 * Permet de faire les tests sur la base de donnee et sur un fichier Json
 * @author laurenal
 *
 */
public class DragueDragonMain {

	public static void main(String[] args) {
		
		BDFactory BDfactory = new BDFactory();
		JsonFactory jsonFactory = new JsonFactory();
		
		RepasDAO repasDAO = BDfactory.createRepasDAO();
		DragonDAO dragonDAO = BDfactory.createDragonDAO();
		AmourDAO amourDAO = BDfactory.createAmourDAO();
		NourritureDAO nourritureDAO = BDfactory.createNourritureDAO();

// Recuperation de la BD cnmplete dans un fichier Json
//		DragueDragon draguedragon = new DragueDragon(
//				amourDAO.findAll(),dragonDAO.findAll(),repasDAO.findAll(),nourritureDAO.findAll()
//				);
//
//		ObjectMapper mapper = new ObjectMapper();
//		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//		try {
//			writer.writeValue(new File("src/test.json"), draguedragon);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		RepasDAO jsonrepasDAO = jsonFactory.createRepasDAO();
		DragonDAO jsondragonDAO = jsonFactory.createDragonDAO();
		AmourDAO jsonamourDAO = jsonFactory.createAmourDAO();
		NourritureDAO jsonnourritureDAO = jsonFactory.createNourritureDAO();
		
		
// Test Json	
		Dragon dragon = new Dragon("Smaug","M",(float)15,1567,true,"Macho");
		Dragon dragon2 = new Dragon("Gui","M",(float)16,1432,false,"Timide");
		Dragon dragon3 = new Dragon("Emma","F",(float)14,1365,false,"Volage");
		Nourriture nourriture = new Nourriture("tacos",555);
		Nourriture nourriture2 = new Nourriture("kebab",556);
		RepasId repasid = new RepasId(dragon,nourriture);
		Repas repas = new Repas(12,repasid);
		RepasId repasid2 = new RepasId(dragon2,nourriture2);
		Repas repas2 = new Repas(12,repasid2);
		AmourId amourid = new AmourId(dragon,dragon2);
		Amour amour = new Amour("Passionne",amourid);
		AmourId amourid2 = new AmourId(dragon,dragon3);
		Amour amour2 = new Amour("Passionne",amourid2);

		jsondragonDAO.create(dragon);
		jsondragonDAO.create(dragon2);
		jsonnourritureDAO.create(nourriture);
		jsonrepasDAO.create(repas);
		jsonamourDAO.create(amour);
		jsondragonDAO.create(dragon3);
		jsonnourritureDAO.create(nourriture2);
		jsonrepasDAO.create(repas2);
		jsonamourDAO.create(amour2);
		
		System.out.println(jsondragonDAO.findById("Emma"));
		System.out.println(jsonnourritureDAO.findById("kebab"));
		System.out.println(jsonrepasDAO.findById(repasid));
		System.out.println(jsonamourDAO.findById(amourid));
		
		System.out.println(jsondragonDAO.findAll());
		System.out.println(jsonnourritureDAO.findAll());
		System.out.println(jsonrepasDAO.findAll());
		System.out.println(jsonamourDAO.findAll());
		
		jsondragonDAO.delete(dragon);
		jsondragonDAO.delete(dragon2);
		jsonnourritureDAO.delete(nourriture);
		jsonrepasDAO.delete(repas);
		jsonamourDAO.delete(amour);
		jsondragonDAO.delete(dragon3);
		jsonnourritureDAO.delete(nourriture2);
		jsonrepasDAO.delete(repas2);
		jsonamourDAO.delete(amour2);
		
		
		
// Test BD
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
//		
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
		
		
		System.out.println("fin");
		
		
		

		
	}

}
	
