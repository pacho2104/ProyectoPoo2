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

}
