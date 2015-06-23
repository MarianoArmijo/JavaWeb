package hibernate.DAO;

import org.hibernate.Session;

/**
 * 
 * @author Mariano
 */
public class SuperDAO {
	
	private Session sesion = null;

	public Session getSession() {
		
		return sesion;
	}

	public void setSession(Session session) {
		
		sesion = session;
	}

}
