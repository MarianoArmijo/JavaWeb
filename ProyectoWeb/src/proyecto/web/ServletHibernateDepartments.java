package proyecto.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import hibernate.services.EmployeesServices;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Employees;

public class ServletHibernateDepartments extends HttpServlet {

	private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
				throws ServletException, IOException {
			super.service(arg0, arg1);
		}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			ServletContext sc = req.getServletContext();
			SessionFactory sf = (SessionFactory) sc.getAttribute("sessionfactory");
			Session session = sf.openSession();
			session.close();
			
			EmployeesServices emp_ser = new EmployeesServices();
			
			/** Leo el objeto que me envía al usuario.
	         */
	        String department_name = req.getParameter("ID");
//	        int empleado_id = Integer.parseInt(empleado);
			
	        int DEPARTMENT_ID = emp_ser.recuperarIdDepartamento(department_name);
	        
			/** Dado un Id de Empleado devolver el empleados que
			* tiene ese Id.
			*/
	        List<Employees> list = emp_ser.recuperarListaEmployeesPorDepartamento(DEPARTMENT_ID);
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.printf("<h3>Los empleados del departamento "+department_name+" son:</h3><ol>");
			
			for(Employees empds : list){
				
				out.printf("<li>"+empds.toString()+"</li>");
				}
			out.printf("</ol>");
			
//			emp_ser.cerrarSessionFactory();
			
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		}
	
}
