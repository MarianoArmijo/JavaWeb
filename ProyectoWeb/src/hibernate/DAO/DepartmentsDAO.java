package hibernate.DAO;

import hibernate.consultas.ConsultasSQL;
import hibernate.interfaz.CRUD;

import java.util.List;

import clases.Employees;

public class DepartmentsDAO extends SuperDAO implements CRUD {

	private SuperDAO superdao = null;

	public DepartmentsDAO(SuperDAO superdao) {
		this.superdao = superdao;
	}
	
	/** Este método llama a otro método que realiza una consulta en la base de datos
	 * 	y devuelve el número de Id de cada departamento.
	 */
	
	public List obtenerIDDepartments(){
		
		List list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerIDDepartmentos()).list();
		return list;
	}

	@Override
	public Employees read(Employees ObjectDTO) {
		return null;
	}

	@Override
	public Employees create(Employees ObjectDTO) {
		return null;
	}

	@Override
	public Employees update(Employees ObjectDTO) {
		return null;
	}

	@Override
	public Employees delete(Employees ObjectDTO) {
		return null;
	}
	
}
