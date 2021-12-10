package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe comporte 4 attributs qui pemettent de stocker les donnees, une List de Dragon, une de Nourriture, une de Repas et une de Amour.
 * La classe permet uniquement de les recuperer.
 * @author laurenal
 */

public class DragueDragon implements Serializable{
	
	private static final long serialVersionUID = 641805476897111473L;
	
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
	
	@Override
	public String toString() {
		return "DragueDragon [amours=" + amours + ", dragons=" + dragons + ", repas=" + repas + ", nourritures="
				+ nourritures + "]";
	}
}
