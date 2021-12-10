package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Cette classe comporte 2 attributs, un qui permet d'indentifier un Repas (RepasId) et la quantite de ce repas (quantite).
 * La classe permet de les recuperer et de leur donner une valeur.
 */

public class Repas implements Serializable{

	private static final long serialVersionUID = 8907491723679207420L;

	private Integer quantite;

	private RepasId Id;

	public Repas() {
		super();
	}

	public Repas(Integer quantite, RepasId Id) {
		super();
		this.quantite = quantite;
		this.Id = Id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public RepasId getId() {
		return Id;
	}

	public void setId(RepasId id) {
		Id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, quantite);
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
		return Objects.equals(Id, other.Id) && Objects.equals(quantite, other.quantite);
	}

	@Override
	public String toString() {
		return "Repas [quantite=" + quantite + ", Id=" + Id + "]";
	}



}
