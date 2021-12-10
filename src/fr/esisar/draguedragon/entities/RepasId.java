package fr.esisar.draguedragon.entities;

import java.util.Objects;

/**
 * @author laurenal
 * Cette classe permet de faire le lien entre un Dragon et une Nourriture, ce qui constitue l'indentificateur d'un Repas.
 * Elle represente le lien qui existe entre les tables Nourriture, Dragon et Repas dans la base de donnee. 
 */
public class RepasId {

	Dragon dragon;
	
	Nourriture nourriture;

	public RepasId() {
		super();
	}

	public RepasId(Dragon dragon, Nourriture nourriture) {
		super();
		this.dragon = dragon;
		this.nourriture = nourriture;
	}

	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

	public Nourriture getNourriture() {
		return nourriture;
	}

	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dragon, nourriture);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepasId other = (RepasId) obj;
		return Objects.equals(dragon, other.dragon) && Objects.equals(nourriture, other.nourriture);
	}

	@Override
	public String toString() {
		return "RepasId [dragon=" + dragon + ", nourriture=" + nourriture + "]";
	}
	
	
}
