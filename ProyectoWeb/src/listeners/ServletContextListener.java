package listeners;

import hibernate.session.manager.SessionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.hibernate.SessionFactory;

/**
 * El contexto es un objeto que se crea al iniciar la aplicación.
 */

public class ServletContextListener implements javax.servlet.ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		ServletContext sc = arg0.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sessionfactory");
		sf.close();
		
		System.out.println("contextDestroyed lo ha destruido.");
	}
	
	/**
	 * Sirve para almacenar las cosas que quiera que duren todo el
	 * proceso del programa en ejecución. (Por ejemplo el tiempo de 
	 * ejecución del programa.)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ServletContext sc;
		SessionFactory sf;
		
		sc = arg0.getServletContext();
		sf = SessionManager.getSessionFactory();
		
		sc.setAttribute("sessionfactory", sf);
		
		System.out.println("contextInitialized lo ha inicializado.");
	}
	
}
