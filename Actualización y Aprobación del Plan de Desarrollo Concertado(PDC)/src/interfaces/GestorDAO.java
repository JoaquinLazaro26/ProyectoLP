package interfaces;

import java.util.ArrayList;

import objetos.Gestor;

public interface GestorDAO {
	
	public int save(Gestor bean);
	public ArrayList<Gestor> findAll();

	public ArrayList<Gestor> findAll2();

}
