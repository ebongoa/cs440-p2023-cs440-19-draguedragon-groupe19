package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

public class Amour implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6871483013936964282L;
	
	private String force;

	private AmourId amourId;
	
	public Amour() {
		super();
	}
	
	public Amour(String force, AmourId amourId) {
		super();
		this.force = force;
		this.amourId = amourId;
	}

	public String getForce() {
		return force;
	}

	public void setForce(String force) {
		this.force = force;
	}

	public AmourId getAmourId() {
		return amourId;
	}

	public void setAmourId(AmourId amourId) {
		this.amourId = amourId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amourId, force);
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
		return Objects.equals(amourId, other.amourId) && Objects.equals(force, other.force);
	}

	@Override
	public String toString() {
		return "Amour [force=" + force + ", amourId=" + amourId + "]";
	}
	
}
