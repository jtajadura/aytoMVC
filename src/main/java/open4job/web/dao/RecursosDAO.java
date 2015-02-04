package open4job.web.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.PreparedStatement;

import open4job.web.vo.RecursosVO;

public class RecursosDAO extends GenericDAO {

	public static final Logger logger = Logger.getLogger(RecursosDAO.class
			.getName());

	// constructor
	public RecursosDAO() {
		super();
	}

	// constructor
	public RecursosDAO(String driver, String url, String user, String password) {
		super(driver, url, user, password);
		// TODO Auto-generated constructor stub
	}

	// Listado de recursos
	public List<RecursosVO> getListadoRecursos() {

		List<RecursosVO> recursos = new ArrayList<RecursosVO>();

		String query = "SELECT * FROM RECURSO";
		// String query = "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO";

		Statement st = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			// rs = connection.createStatement().executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt(1);
				float latitud = rs.getFloat(2);
				float longitud = rs.getFloat(3);
				String servicios = rs.getString(4);
				String horario = rs.getString(5);
				String titulo = rs.getString(6);
				String descripcion = rs.getString(7);
				String gradoacc = rs.getString(8);
				String tipo = rs.getString(9);
				String relacionado = rs.getString(10);
				String clasificación = rs.getString(11);
				String precio = rs.getString(12);
				String email = rs.getString(13);
				String url = rs.getString(14);
				String accesibilidad = rs.getString(15);
				String poblacion = rs.getString(16);
				String telefono = rs.getString(17);

				RecursosVO recurso = new RecursosVO(id, latitud, longitud,
						servicios, horario, titulo, descripcion, gradoacc,
						tipo, relacionado, clasificación, precio, email, url,
						accesibilidad, poblacion, telefono);
				recursos.add(recurso);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recursos;
	}

	// Obtiene los datos de un registro en concreto
	public RecursosVO getDatosRecurso(int idEquipo) {

		RecursosVO recurso = null;

		// Version con CreateStatement

		// String query =
		// "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO WHERE ID = "
		// + idEquipo;

		// Version con PreparedStatement
		String query = "SELECT ID, TITULO, LATITUD, LONGITUD FROM RECURSO WHERE ID = ?";

		// Statement st = null;
		ResultSet rs = null;

		PreparedStatement pstmt = null;

		try {

			this.abrirConexion();

			pstmt = connection.prepareStatement(query);

			// st = connection.createStatement();
			// rs = st.executeQuery(query);
			// rs = connection.createStatement().executeQuery(query);

			pstmt.setInt(1, idEquipo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String titulo = rs.getString(2);
				float latitud = rs.getFloat(3);
				float longitud = rs.getFloat(4);

				// RecursosVO recurso = new RecursosVO(id, titulo, latitud,
				// longitud);
				// recursos.add(recurso);
				recurso = new RecursosVO(id, latitud, longitud, null, null,
						titulo, null, null, null, null, null, null, null, null,
						null, null, null);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recurso;

	}

	// Update de un recurso
	public RecursosVO setUpdateDatosRecurso(int idEquipo) {

		RecursosVO recurso = null;

		// Version con PreparedStatement
		String query = "UPDATE RECURSO SET TITULO = ? WHERE ID = ?";

		ResultSet rs = null;

		PreparedStatement pstmt = null;

		try {

			this.abrirConexion();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, "UpdateTitulo");
			pstmt.setInt(2, idEquipo);
			rs = pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recurso;

	}

	// Insertar un recurso
	public RecursosVO setInsertDatosRecursos(int idEquipo, String titulo) {

		RecursosVO recurso = null;

		// Version con PreparedStatement
		String query = "INSERT INTO RECURSO (ID, TITULO, LATITUD, LONGITUD) VALUES (?, ?, ?, ?)";

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {

			this.abrirConexion();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, idEquipo);
			pstmt.setString(2, titulo);
			pstmt.setFloat(3, 33333);
			pstmt.setFloat(4, 44444);

			rs = pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return recurso;

	}

	// Dame el id siguiente de un recurso
	public int getSiguiente(int idEquipo) {

		// Declaramos la variable fuera y la inicializamos
		int valor = 0;

		// Version con CallableStatement
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();

			cstmt = connection.prepareCall("{ ? = call siguiente (?)}");

			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);

			cstmt.setInt(2, idEquipo);

			rs = cstmt.executeQuery();

			valor = cstmt.getInt(1);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (cstmt != null) {
				try {
					cstmt.close();
				} catch (Exception e) {
				}
			}
		}
		this.cerrarConexion();

		return valor;

	}

	public void ejTransacciones() {

	}

}
