package hibernate.services;

import hibernate.DAO.EmployeeDAO;
import hibernate.DAO.SuperDAO;
import hibernate.session.manager.SessionManager;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.Departments;
import clases.Employees;

public class EmployeesServices {
	
	private final static Logger log = LogManager.getRootLogger();
	
	private SuperDAO superdao = null; 
	
	public EmployeesServices(){
		
		superdao = new SuperDAO();
	}
	
	/** Método que incrementa el salario de los empleados un 20%
	 */
	public List<Employees> incrementarSalario() {
		
		Session session = null;
		Transaction transaction = null;
		List<Employees> list = null;
		EmployeeDAO emp = null;
		emp = new EmployeeDAO(superdao);

		try {
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			transaction = session.beginTransaction();
			
			list = emp.obtenerTodosLosEmpleados();
			
//			for(Employees employees : list){employees.setSalary(employees.getSalary().multiply(new BigDecimal(1.2)));}
			
			transaction.commit();
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}
		
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		return list;
	}
	
	// Método que lista los salarios más altos de cada departamento.
	public List<Employees> listarMayoresSalarios() {
		
		Session session = null;
		List<Employees> list = null;
		EmployeeDAO empdao = null;
		empdao = new EmployeeDAO(superdao);

		try {
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			list = empdao.obtenerListaSalariosMayores();
			
		}
		
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		log.info("Método listarMayoresSalarios terminado.");
		
		return list;
	}
	
	// Método que dado un id de empleado devuelve un Empleado.
		public List<Employees> recuperarListaEmployeesPorID(int EMPLOYEE_ID) {	
			
			Session session = null;
			List<Employees> list = null;
			EmployeeDAO emps_byid = null;
			emps_byid = new EmployeeDAO(superdao);
			
			try{	
				session = SessionManager.obtenerSesionNueva();
				superdao.setSession(session);
				
				list = emps_byid.obtenerEmpleadosPorID(EMPLOYEE_ID);
				
//				for(Employees empds : list){System.out.println(empds.toString());}
				
			}
			
			catch(Exception e){
				
				e.printStackTrace();
			}
			
			finally {
				
				SessionManager.cerrarSession(session);
			}
			
			log.info("Método recuperarListaEmployeesPorID terminado.");
			
			return list;
		}
	
	// Método que dado un id departamento devuelve un departamento.
	public List<Employees> recuperarDepartamentoPorID(int DEPARTMENT_ID) {	
		
		Session session = null;
		List<Employees> list = null;
		EmployeeDAO emps_byid = null;
		emps_byid = new EmployeeDAO(superdao);
		
		try {
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			list = emps_byid.obtenerEmpleadosDepartamento(DEPARTMENT_ID);
			
//				for(Employees empds : list){System.out.println(empds.toString());}
			
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
	
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
			log.info("Método recuperarListaEmployeesPorDepartamento terminado.");
		
		return list;
	}
	
	/**
	 * Método que dado un nombre de departamento devuelve el id de departamento.
	 */
	
	public int recuperarIdDepartamento(String DEPARTMENT_NAME){
		
		Session session = null;
		List list = null;
		EmployeeDAO dep_id = null;
		dep_id = new EmployeeDAO(superdao);
		int DEPARTMENT_ID = 0;
		
		try {
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			list = dep_id.obtenerDepartamento(DEPARTMENT_NAME);
			
			for(Object dep : list) {

				BigDecimal bg = (BigDecimal) dep;
				DEPARTMENT_ID = bg.intValue();

			}
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
	
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		log.info("Método recuperarListaEmployeesPorDepartamento terminado.");
		
		return DEPARTMENT_ID;
	}
	
	/** 
	 * Método que dado un departamento devuelve una lista de Empleados de ese departamento.
	 * @param DEPARTMENT_ID
	 */
	public List<Employees> recuperarListaEmployeesPorDepartamento(int DEPARTMENT_ID) {	
		
		Session session = null;
		List<Employees> list = null;
		EmployeeDAO emps_byid = null;
		emps_byid = new EmployeeDAO(superdao);
		
		try{
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			list = emps_byid.obtenerEmpleadosDepartamento(DEPARTMENT_ID);
			
//			for(Employees empds : list){System.out.println(empds.toString());}
			
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
	
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		log.info("Método recuperarListaEmployeesPorDepartamento terminado.");
		
		return list;
	}
	
	/**
	 * Método que cierra la session.
	 */
	
	public void cerrarSessionFactory() {
		
	SessionManager.cerrarSessionFactory();
	log.info("Método cerrarSessionFactory terminado.");
	}
}
