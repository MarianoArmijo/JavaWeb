package hibernate.interfaz;

import clases.Employees;

/**
 * Clase Interface en la que se crean los métodos comunes 
 * a todas las clases DAO.
 * 
 * @author Mariano
 *
 */

public interface CRUD {
	
	public Employees read(Employees ObjectDTO);

	public Employees create(Employees ObjectDTO);
	
	public Employees update(Employees ObjectDTO);
	
	public Employees delete(Employees ObjectDTO);
	
}
