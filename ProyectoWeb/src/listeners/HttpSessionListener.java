package listeners;

import javax.servlet.http.HttpSessionEvent;

public class HttpSessionListener implements javax.servlet.http.HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

			System.out.println("sessionCreated lo ha creado.");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

			System.out.println("sessionDestroyed lo ha destruido.");
	}

}
