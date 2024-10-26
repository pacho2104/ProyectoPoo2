package ProyectoWeb.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ProyectoWeb.beans.Autor;

public class AutoresModel extends Conectar {

	CallableStatement cst;
	ResultSet rs;

	/*
	 * public List<Autor> listarAutores(){
	 * 
	 * ArrayList<Autor> autores=new ArrayList<Autor>(); autores.add(new Autor(1,
	 * "Pepe", "Lucho")); autores.add(new Autor(2, "Luis", "Rios")); autores.add(new
	 * Autor(3, "Lupe", "Bartra")); autores.add(new Autor(4, "Olga", "Moreno"));
	 * autores.add(new Autor(5, "Leni", "Schurt")); return autores;
	 * 
	 * }
	 */
	public List<Autor> listaAutores() throws SQLException {

		try {

			List<Autor> lista = new ArrayList<Autor>();
			String sql = "CALL sp_listarAutores()";
			this.abrirConectar();
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();

			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("Codigo_autor"));
				autor.setNombre(rs.getString("nombre_autor"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);

			}
			this.cerrarConectar();
			return lista;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	public int insertarAutor(Autor autor) {

		try {

			int filasAfectadas = 0;
			String sql = "CALL sp_insertarAutor(?,?)";
			this.abrirConectar();
			cst = con.prepareCall(sql);
			// cst.setInt(1,autor.getIdAutor());
			cst.setString(1, autor.getNombre());
			cst.setString(2, autor.getNacionalidad());
			filasAfectadas = cst.executeUpdate();
			return filasAfectadas;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en:" + e.getMessage());
			this.cerrarConectar();
			return 0;
		}

	}

	public int eliminarAutor(int id) {

		try {

			int filasAfectadas = 0;
			String SQL = "CALL sp_eliminarAutor(?)";
			this.abrirConectar();
			cst = con.prepareCall(SQL);
			cst.setInt(1, id);
			filasAfectadas = cst.executeUpdate();
			this.cerrarConectar();
			return filasAfectadas;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en eliminar:" + e.getMessage());
		}

		return 0;
	}

	public Autor obtenerAutor(int idautor) throws SQLException {

		Autor autor = new Autor();

		try {

			String sql = "CALL sp_obtenerAutor(?)";
			this.abrirConectar();
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();
			if (rs.next()) {

				autor.setIdAutor(rs.getInt("Codigo_autor"));
				autor.setNombre(rs.getString("nombre_autor"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
			}
			this.cerrarConectar();
			return autor;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en obtener 1:" + e.getMessage());
			return null;
		}

	}

	public int modificarAutor(Autor autor) {

		try {

			int filasAfectadas = 0;
			String sql = "CALL sp_modificarAutor(?,?,?)";
			this.abrirConectar();
			cst = con.prepareCall(sql);
			cst.setInt(1,autor.getIdAutor());
			cst.setString(1, autor.getNombre());
			cst.setString(2, autor.getNacionalidad());
			filasAfectadas = cst.executeUpdate();
			return filasAfectadas;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en:" + e.getMessage());
			this.cerrarConectar();
			return 0;
		}

	}

}
