package listeners;

import javax.servlet.ServletRequestEvent;

public class ServletRequestListener implements javax.servlet.ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {

			System.out.println("requestDestroyed lo ha destruido.");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {

			System.out.println("requestInitialized lo ha inicializado.");
	}
	
}
