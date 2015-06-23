package proyecto.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import hibernate.services.EmployeesServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import clases.Employees;

public class ServletHibernateEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Logger log = LogManager.getRootLogger();
	
		@Override
		protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
				throws ServletException, IOException {
			super.service(arg0, arg1);
		}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			EmployeesServices emp_ser = new EmployeesServices();
			
			/** Leo el objeto que me envía al usuario.
	         */
	        String empleado = req.getParameter("ID");
	        int empleado_id = Integer.parseInt(empleado);
			
			/** Dado un Id de Empleado devolver el empleados que
			* tiene ese Id.
			*/
	        List<Employees> list = emp_ser.recuperarListaEmployeesPorID(empleado_id);
			
			resp.setContentType("text/html; charset=UTF-8");
			
			/**
			 * Con PrintWrite creo el fichero html para escribir.
			 */
			PrintWriter out = resp.getWriter();
			out.printf("<h3>El empleado con ID "+empleado+" es:</h3>");
			
			for(Employees empds : list){out.printf(empds.toString());}
			
			log.info("Esto va bien.");
//			emp_ser.cerrarSessionFactory();
			
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		}
	
}
