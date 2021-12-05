package ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.FactoryDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.model.Persona;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonaDAO personaDAO;
	private List<Persona>listaPersonas;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        personaDAO = FactoryDAO.getFactoryDAO().getPersonaDAO();
        listaPersonas = personaDAO.find();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/index.html").forward(request, response);
		HttpSession session = request.getSession(true);
		System.out.println("Session GET: " + session);
		/*
		 * if (request.getParameter("CerrarSesionServlet") != null) {
		 * session.invalidate(); response.sendRedirect("/index.jsp"); }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String url = null;
		
		
		listaPersonas = personaDAO.find();
		
		
		for (Persona persona : listaPersonas) {
			
			if (persona.getPassword().equals(password) && persona.getCorreo().equals(email)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("persona", persona);
				
				if (persona.getRol().equals("Doctor")) {
					url = "/Doctores/Doctor.jsp";
				}
				if (persona.getRol().equals("Secretaria")) {
					url = "/Secretarias/homeSecretaria.jsp";
				}
				if (persona.getRol().equals("Administrador")) {
					url = "/Administradores/index.jsp";
				}
				if (persona.getRol().equals("Paciente")) {
					url = "/Pacientes/homePaciente.jsp";
				}
				break;
			} else {
				url = "/Public/error.jsp";
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
