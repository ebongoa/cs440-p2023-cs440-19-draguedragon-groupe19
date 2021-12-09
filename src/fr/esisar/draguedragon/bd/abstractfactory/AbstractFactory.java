package fr.esisar.draguedragon.bd.abstractfactory;

public interface AbstractFactory {

	public AmourDAO createAmourDAO();

	public DragonDAO createDragonDAO();

	public NourritureDAO createNourritureDAO();

	public RepasDAO createRepasDAO();


}
