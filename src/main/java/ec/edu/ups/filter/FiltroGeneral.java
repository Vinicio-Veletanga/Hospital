package ec.edu.ups.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.model.Persona;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter(
		servletNames = { "CreateUser", "CerrarSesionServlet"})
public class FiltroGeneral implements Filter {
	
	private PersonaDAO personaDAO;
	private Persona persona;

    /**
     * Default constructor. 
     */
    public FiltroGeneral() {
        personaDAO = FactoryDAO.getFactoryDAO().getPersonaDAO();
        persona = new Persona();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		
		if (session.getAttribute("persona")!=null) {
			try {
				Persona temporalPersona = new Persona();
				temporalPersona = (Persona)session.getAttribute("persona");
				persona = personaDAO.read(temporalPersona.getCedula());
				chain.doFilter(request, response);
			} catch (Exception e) {
				System.out.println("Error en filtro validando login: "+e.getMessage());
				e.printStackTrace();
				session.invalidate();
				((HttpServletResponse)response).sendRedirect("/Hospital/index.html");
			}
			
		}else {
			((HttpServletResponse)response).sendRedirect("/Hospital/index.html");
			session.invalidate();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro General");
	}

}
