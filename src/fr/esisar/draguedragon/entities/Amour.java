package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

public class Amour implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6871483013936964282L;
	
	private String force;

	private Dragon aimant;
	
	private Dragon aime;
	
	public Amour() {
		super();
	}
	
	public Amour(String force, Dragon aimant, Dragon aime) {
		super();
		this.force = force;
		this.aimant = aimant;
		this.aime = aime;
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

	public String getForce() {
		return force;
	}

	public void setForce(String force) {
		this.force = force;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aimant, aime, force);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amour other = (Amour) obj;
		return Objects.equals(aimant, other.aimant) && Objects.equals(aime, other.aime)
				&& Objects.equals(force, other.force);
	}
	
	@Override
	public String toString() {
		return "Amour [force=" + force + ", aimant=" + aimant + ", aime=" + aime + "]";
	}
	
}
