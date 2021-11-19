package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

public class Amour implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6871483013936964282L;
	private String force;

	public Amour() {
		super();
	}

	@Override
	public String toString() {
		return "Amour [force=" + force + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(force);
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
		return Objects.equals(force, other.force);
	}

	public Amour(String force) {
		super();
		this.force = force;
	}

	public String getForce() {
		return force;
	}

	public void setForce(String force) {
		this.force = force;
	}
}
