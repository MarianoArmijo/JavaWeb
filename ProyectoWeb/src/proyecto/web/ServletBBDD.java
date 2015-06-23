package proyecto.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBBDD extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	Connection conn = null;
	ResultSet rset = null;
	Statement stmt = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/** Leo el objeto que me envía al usuario.
         */
        String empleado = req.getParameter("ID");
        
        /**
         * Traducir un String a un int utilizando el método
         * parseInt
         */
        int empleado_id = Integer.parseInt(empleado);
		
		try	{
			
			conn = Pool.getConnection();
	        stmt = conn.createStatement();
			
		    //Ejecuto la consuta
			rset = stmt.executeQuery("SELECT * from EMPLOYEES where EMPLOYEE_ID = "+empleado_id);
	      
			String nombre;
			
			// La consulta recoge un result set.
			if (rset.next()){
				
	         nombre = ("El empleado con id "+empleado_id+" es: "+rset.getString(2)+" "+rset.getString(3)+
	        		 ". <br> Su salario es: "+rset.getString(8)+" €.");
			}
			else { 
				nombre = "No existe un empleado con ese id.";
				}
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.printf(nombre);
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		finally { //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
			
			Pool.liberarRecursos(conn, stmt);
		}
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

//		super.doPost(req, resp);
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.service(arg0, arg1);
	}
}
