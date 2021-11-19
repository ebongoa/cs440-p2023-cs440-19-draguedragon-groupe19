package fr.esisar.draguedragon.entities;

import java.io.Serializable;
import java.util.Objects;

public class Dragon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3052471461815549088L;
	private String nomDragon;
	private String sexe;
	private Float longeur;
	private Integer ecailles;
	private Boolean cracheFeu;
	private String enAmour;
	
	public Dragon() {
		super();
	}

	@Override
	public String toString() {
		return "Dragon [nomDragon=" + nomDragon + ", sexe=" + sexe + ", longeur=" + longeur + ", ecailles=" + ecailles
				+ ", cracheFeu=" + cracheFeu + ", enAmour=" + enAmour + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cracheFeu, ecailles, enAmour, longeur, nomDragon, sexe);
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
				&& Objects.equals(enAmour, other.enAmour) && Objects.equals(longeur, other.longeur)
				&& Objects.equals(nomDragon, other.nomDragon) && Objects.equals(sexe, other.sexe);
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
		return longeur;
	}
	
	public void setLongeur(Float longeur) {
		this.longeur = longeur;
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
	
	public Dragon(String nomDragon, String sexe, Float longeur, Integer ecailles, Boolean cracheFeu, String enAmour) {
		super();
		this.nomDragon = nomDragon;
		this.sexe = sexe;
		this.longeur = longeur;
		this.ecailles = ecailles;
		this.cracheFeu = cracheFeu;
		this.enAmour = enAmour;
	}
	
}
