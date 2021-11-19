package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

public class Repas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8907491723679207420L;
	private Integer quantite;

	public Repas() {
		super();
	}

	@Override
	public String toString() {
		return "Repas [quantite=" + quantite + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(quantite);
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
		return Objects.equals(quantite, other.quantite);
	}

	public Repas(Integer quantite) {
		super();
		this.quantite = quantite;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
}
