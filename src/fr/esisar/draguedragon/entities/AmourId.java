package fr.esisar.draguedragon.entities;

import java.util.Objects;

/**
 * @author laurenal
 * Cette classe permet de faire le lien entre deux Dragon, ce qui constitue l'indentificateur d'un Amour.
 * Elle represente les liens qui existe entre les tables Dragon et Amour dans la base de donnee. 
 */

public class AmourId {

	private Dragon aimant;
	
	private Dragon aime;

	public AmourId(Dragon aimant, Dragon aime) {
		super();
		this.aimant = aimant;
		this.aime = aime;
	}
	
	public AmourId() {
		super();
	}

	public Dragon getAimant() {
		return aimant;
	}

	public void setAimant(Dragon aimant) {
		this.aimant = aimant;
	}

	public Dragon getAime() {
		return aime;
	}

	public void setAime(Dragon aime) {
		this.aime = aime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aimant, aime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmourId other = (AmourId) obj;
		return Objects.equals(aimant, other.aimant) && Objects.equals(aime, other.aime);
	}

	@Override
	public String toString() {
		return "AmourId [aimant=" + aimant + ", aime=" + aime + "]";
	}
	
}
