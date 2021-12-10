package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Cette classe comporte 2 attributs, un qui permet d'indentifier une Nourriture (nomProduit) et les calories de cette Nourriture (calories).
 * La classe permet de les recuperer et de leur donner une valeur 
 * @author laurenal
 */

public class Nourriture implements Serializable{

	private static final long serialVersionUID = -327096012265611052L;
	private String nomProduit;
	private Integer calories;
	
	public Nourriture() {
		super();
	}
	
	public Nourriture(String nomProduit, Integer calories) {
		super();
		this.nomProduit = nomProduit;
		this.calories = calories;
	}
	
	public String getNomProduit() {
		return nomProduit;
	}
	
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	public Integer getCalories() {
		return calories;
	}
	
	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calories, nomProduit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nourriture other = (Nourriture) obj;
		return Objects.equals(calories, other.calories) && Objects.equals(nomProduit, other.nomProduit);
	}
	
	@Override
	public String toString() {
		return "Nourriture [nomProduit=" + nomProduit + ", calories=" + calories + "]";
	}

}
