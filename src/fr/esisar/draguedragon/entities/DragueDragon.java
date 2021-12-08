package fr.esisar.draguedragon.entities;

import java.util.ArrayList;
import java.util.List;

public class DragueDragon {
	
	public List<Amour> amours;
	public List<Dragon> dragons;
	public List<Repas> repas;
	public List<Nourriture> nourritures;
	
	
	public DragueDragon() {
		super();
		this.amours = new ArrayList<Amour>();
		this.dragons = new ArrayList<Dragon>();
		this.repas = new ArrayList<Repas>();
		this.nourritures = new ArrayList<Nourriture>();
	}

	public DragueDragon(List<Amour> amours, List<Dragon> dragons, List<Repas> repas, List<Nourriture> nourritures) {
		super();
		this.amours = amours;
		this.dragons = dragons;
		this.repas = repas;
		this.nourritures = nourritures;
	}
	
	public List<Amour> getAmours() {
		return amours;
	}

	public List<Dragon> getDragons() {
		return dragons;
	}

	public List<Repas> getRepas() {
		return repas;
	}

	public List<Nourriture> getNourritures() {
		return nourritures;
	}	
}
