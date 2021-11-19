package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

public class Repas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8907491723679207420L;
	
	private Integer quantite;

	private Dragon dragon;
	
	private Nourriture nourriture;
	
	public Repas() {
		super();
	}
	
	public Repas(Integer quantite, Dragon dragon, Nourriture nourriture) {
		super();
		this.quantite = quantite;
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

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dragon, nourriture, quantite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repas other = (Repas) obj;
		return Objects.equals(dragon, other.dragon) && Objects.equals(nourriture, other.nourriture)
				&& Objects.equals(quantite, other.quantite);
	}
	
	@Override
	public String toString() {
		return "Repas [quantite=" + quantite + ", dragon=" + dragon + ", nourriture=" + nourriture + "]";
	}

}
