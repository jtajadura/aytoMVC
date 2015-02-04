package open4job.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import open4job.web.dao.RecursosDAO;
import open4job.web.vo.RecursosVO;

/**
 * Servlet implementation class VisualizarOpcServlet
 */
public class VisualizarOpcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizarOpcServlet() {
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

		// Creamos el objeto sesion y si ya existe lo usa
		HttpSession session = request.getSession();
		
		//El objeto sesion recoge el parámetro idRecurso y lo convierte a String guardándolo en la variable idStr
		Integer idInteger = (Integer) session.getAttribute("idRecurso");
		
		//Convertimos a entero el objeto session guardándolo en la variable id
		int id = idInteger.intValue();
		
		// Modelo
		// DAO invocados con params, VO

		/*Lo comentamos ahora ya que se lo pasaremos desde el context.xml
		String driver = "oracle.jdbc.driver.OracleDriver";
		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";
		String user = "open4job";
		String password = "open4job";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;

		RecursosDAO recursosDAO = new RecursosDAO(driver, url, user, password);
		*/
		
		RecursosDAO recursosDAO = new RecursosDAO();
		
		// busqueda de 1 recurso en concreto, llamamos al método getDatosRecurso
		RecursosVO recurso = recursosDAO.getDatosRecurso(id);

		// Tratar si no existe id, objeto nulo
		if (recurso == null) {

			// Pasando la Vista al JSP Error
			request.getRequestDispatcher("AytoJSPError.jsp").forward(request, response);
			// return;

		} else {

			// Pasando la Vista al JSP Visualiza
			request.setAttribute("RecursosVO", recurso);

			//Lo podríamos hacer con session:
			//session.setAttribute("idRecurso", idStr);

			request.getRequestDispatcher("VisualizarOpc.jsp").forward(request, response);

						
		}

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
