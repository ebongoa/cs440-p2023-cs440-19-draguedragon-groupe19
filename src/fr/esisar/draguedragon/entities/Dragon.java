package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Cette classe comporte 6 attributs, un qui permet d'indentifier un Dragon(nomDragon) et le sexe(sexe), la longueur(longueur), le nombre d'ecailles(ecailles), 
 * si le dragon crache du feu(cracheFeu) et si le dragon est amoureux(enAmour).
 * La classe permet de les recuperer et de leur donner une valeur. 
 * @author laurenal
 */

public class Dragon implements Serializable{

	private static final long serialVersionUID = -3052471461815549088L;
	
	private String nomDragon;
	
	private String sexe;
	
	private Float longueur;
	
	private Integer ecailles;
	
	private Boolean cracheFeu;
	
	private String enAmour;
	
	public Dragon() {
		super();
	}
	
	public Dragon(String nomDragon, String sexe, Float longueur, Integer ecailles, Boolean cracheFeu, String enAmour) {
		super();
		this.nomDragon = nomDragon;
		this.sexe = sexe;
		this.longueur = longueur;
		this.ecailles = ecailles;
		this.cracheFeu = cracheFeu;
		this.enAmour = enAmour;
	}

	public String getNomDragon() {
		return nomDragon;
	}
	
	public void setNomDragon(String nomDragon) {
		this.nomDragon = nomDragon;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public Float getLongeur() {
		return longueur;
	}
	
	public void setLongeur(Float longeur) {
		this.longueur = longeur;
	}
	
	public Integer getEcailles() {
		return ecailles;
	}
	
	public void setEcailles(Integer ecailles) {
		this.ecailles = ecailles;
	}
	
	public Boolean getCracheFeu() {
		return cracheFeu;
	}

	public void setCracheFeu(Boolean cracheFeu) {
		this.cracheFeu = cracheFeu;
	}
	
	public String getEnAmour() {
		return enAmour;
	}
	
	public void setEnAmour(String enAmour) {
		this.enAmour = enAmour;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cracheFeu, ecailles, enAmour, longueur, nomDragon, sexe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dragon other = (Dragon) obj;
		return Objects.equals(cracheFeu, other.cracheFeu) && Objects.equals(ecailles, other.ecailles)
				&& Objects.equals(enAmour, other.enAmour) && Objects.equals(longueur, other.longueur)
				&& Objects.equals(nomDragon, other.nomDragon) && Objects.equals(sexe, other.sexe);
	}
	
	@Override
	public String toString() {
		return "Dragon [nomDragon=" + nomDragon + ", sexe=" + sexe + ", longeur=" + longueur + ", ecailles=" + ecailles
				+ ", cracheFeu=" + cracheFeu + ", enAmour=" + enAmour + "]";
	}

		
}
