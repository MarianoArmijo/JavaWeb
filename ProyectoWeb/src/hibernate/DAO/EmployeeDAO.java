package hibernate.DAO;

import hibernate.consultas.ConsultasSQL;
import hibernate.interfaz.CRUD;

import java.math.BigDecimal;
import java.util.List;
import java.util.LinkedList;

import clases.Departments;
import clases.Employees;

public class EmployeeDAO extends SuperDAO implements CRUD {
	
	private SuperDAO superdao = null;

	public EmployeeDAO(SuperDAO superdao) {
		this.superdao = superdao;
	}
	
	/**
	 * Método que llama a otro método que hace una consulta para obtener todos los empleados de 
	 * la base de datos y devuelve una lista de empleados.
	 */
	public List<Employees> obtenerTodosLosEmpleados() {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleados()).addEntity(Employees.class).list();
		return list;
	}
	
	/**
	 * Método que devuelve el empleado que tiene mayor salario y es de distinto departamento 
	 * a partir del Id de departamento y otra consulta que esta en el método obetenerEmpleadosPorDepartamento.
	 */
	public List<Employees> obtenerListaSalariosMayores(){
		
		List l_dep = null;
		List<Employees> l_emp = null;
		LinkedList<Employees> emp_ordenado = new LinkedList<Employees>();
		
		DepartmentsDAO departamento = new DepartmentsDAO(superdao);
		l_dep = departamento.obtenerIDDepartments();
		
		for (Object departament : l_dep) {
			
			BigDecimal department = (BigDecimal)departament;
			l_emp = obtenerEmpleadosPorDepartamento(department.intValue());
			emp_ordenado.add(l_emp.get(0));
		}
		return emp_ordenado;
	}
	
	/**
	 *	Método que recibe un Id de empleado y devuelve el empleado asociado a ese Id. 
	 * 
	 * @param EMPLOYEE_ID
	 */
	public List<Employees> obtenerEmpleadosPorID(int EMPLOYEE_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleadosID(EMPLOYEE_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	/**
	 * Método que recibe un Id de departamento y devuelve todos los empleados asociados a ese departamento 
	 * 
	 * @param DEPARTMENT_ID
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(int DEPARTMENT_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleadosPorDepartamento(DEPARTMENT_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	public List<Employees> obtenerEmpleadosDepartamento(int DEPARTMENT_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleadosDepartamentos(DEPARTMENT_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	public List<Employees> obtenerDepartamentoPorId(int DEPARTMENT_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerDepartamentoPorId(DEPARTMENT_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	public List obtenerDepartamento(String DEPARTMENT_NAME) {
		
		List list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerDepartamentos(DEPARTMENT_NAME)).list();
		return list;
	}
	
	public Employees read(Employees DTO){
		return DTO;}

	public Employees create(Employees DTO){
		return DTO;}
	
	public Employees update(Employees DTO){
		return DTO;}
	
	public Employees delete(Employees DTO){
		return DTO;}

}
