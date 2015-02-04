package open4job.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import open4job.web.dao.*;
import open4job.web.vo.*;

public class AytoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AytoServlet() {
		super();
	}

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

		// if (id == -1) DILE QUE NO HACEMOS NADA Y SALIR
		if (id == -1) {
			// No hacer nada
		} else {

			// Modelo
			// DAO invocados con params, VO

			String driver = "oracle.jdbc.driver.OracleDriver";
			String host = "54.154.192.80";
			String puerto = "1521";
			String sid = "xe";
			String user = "open4job";
			String password = "open4job";
			String url = "jdbc:oracle:thin:" + user + "/" + password + "@"
					+ host + ":" + puerto + ":" + sid;

			RecursosDAO recursosDAO = new RecursosDAO(driver, url, user,
					password);

			// busqueda de 1 recurso en concreto
			RecursosVO recurso = recursosDAO.getDatosRecurso(id);

			// Tratar si no existe id, objeto nulo
			if (recurso == null) {
				//PrintWriter out = response.getWriter();
				//out.println("Recurso nulo");

				// Pasando la Vista a otro JSP
				request.getRequestDispatcher("AytoJSPError.jsp").forward(request, response);
				//return;
				
			} else {

				// VISTA
				/*
				 * PrintWriter out = response.getWriter();
				 * out.println("<html>"); out.println("<body>");
				 * out.println("Id : " + recurso.getId());
				 * out.println("Titulo : " + recurso.getTitulo());
				 * out.println("Latitud : " + recurso.getLatitud());
				 * out.println("Longitud : " + recurso.getLongitud());
				 * out.println("</body>"); out.println("</html>");
				 */

				// Pasando la Vista a un JSP
				request.setAttribute("RecursosVO", recurso);
				request.getRequestDispatcher("AytoJSP.jsp").forward(request, response);

			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
