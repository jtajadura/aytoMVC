package open4job.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmarOpcServlet
 */
public class ConfirmarOpcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmarOpcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Controlador
		// Params, validas, compruebas
		String idStr = (String) request.getParameter("id");
		int id = -1;

		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
		}

		//Creamos el objeto sesion y si ya existe lo usa
		HttpSession session = request.getSession(true);

		//Pasamos al objeto sesion el parámetro id que es un String
		session.setAttribute("idRecurso", id);
		
		//Llevamos el objeto sesion al JSP indicado para que lo utilice y lo muestre
		request.getRequestDispatcher("ConfirmarOpc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
