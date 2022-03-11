package servlets;

import java.io.IOException;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		String nomUsuario1 = "JorgePJ13";
		String nomUsuario2 = "JordiPlayer55";
		String nomUsuario3 = "JorgeMatamoscas";
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setPassword(password);

		if ((nombre.equals(nomUsuario1) && password.equals("jorgepando98"))
				|| (nombre.equals(nomUsuario2) && password.equals("jorgeplayer55"))
				|| (nombre.equals(nomUsuario3) && password.equals("matamoscas"))) {
			RequestDispatcher rdLogin = request.getRequestDispatcher("ResultadoLogin.jsp");
			request.setAttribute("info", u);
			request.getSession().setAttribute("nombre", nombre);
			rdLogin.forward(request, response);
			//response.sendRedirect("ResultadoLogin.jsp");
		} else {
			RequestDispatcher rdError = request.getRequestDispatcher("Error.jsp");
			rdError.forward(request, response);
			//response.sendRedirect("ErrorLogin.jsp");
		}		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
