package fr.esisar.draguedragon.bd.abstractfactory;

/**
 * Cette interface permet de referencer les methodes des factory Json et BD 
 * 
 * @author laurenal
 *
 */

public interface AbstractFactory {

	public AmourDAO createAmourDAO();

	public DragonDAO createDragonDAO();

	public NourritureDAO createNourritureDAO();

	public RepasDAO createRepasDAO();


}
