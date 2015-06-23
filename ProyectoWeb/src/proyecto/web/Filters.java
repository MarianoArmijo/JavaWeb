package proyecto.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Filters implements javax.servlet.Filter {

	private final static Logger log = LogManager.getRootLogger();

	
	@Override
	public void destroy() {

		log.info("Se ha iniciado el filtro.");
	}

	@Override
	public void doFilter(ServletRequest srg, ServletResponse sr,
			FilterChain fc) throws IOException, ServletException {
		
		fc.doFilter(srg, sr); //llama al servlet o a otro filtro
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		log.info("Se ha finalizado el filtro.");
	}

	
}
