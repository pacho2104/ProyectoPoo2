package ProyectoWeb.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ProyectoWeb.beans.Editorial;

public class EditorialModel extends Conectar {
	CallableStatement cst;
	ResultSet rs;

	public List<Editorial> listaEditorial() {

		try {

			List<Editorial> lista = new ArrayList<Editorial>();
			String sql = "CALL sp_listarEditorial()";
			this.abrirConectar();
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();

			while (rs.next()) {

				Editorial editorial = new Editorial();
				editorial.setIdLibro(rs.getInt("codigo_editorial"));
				editorial.setNombre(rs.getString("nombre_editorial"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
				lista.add(editorial);

			}
			this.cerrarConectar();
			return lista;

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error en listar 1:" + e.getMessage());
			return null;
		}

	}
	
	
	public int insertarEditorial(Editorial editorial) {
		
		try {
			
			int filasAfectadas=0;
			String sql="CALL sp_insertarEditorial(?,?,?)";
			this.abrirConectar();
			cst=con.prepareCall(sql);
			cst.setString(1, editorial.getNombre());
			cst.setString(2, editorial.getContacto());
			cst.setString(3, editorial.getTelefono());
			filasAfectadas=cst.executeUpdate();
			return filasAfectadas;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en insertar 1:"+e.getMessage());
			this.cerrarConectar();
			return 0;
		}
		
	}
	
	public int eliminarAutor(int id) {
		
		try {
			
			int filasAfcetadas=0;
			String sql="call sp_eliminarEditorial(?)";
			this.abrirConectar();
			cst=con.prepareCall(sql);
			cst.setInt(1, id);
			filasAfcetadas=cst.executeUpdate();
			this.cerrarConectar();
			return filasAfcetadas;
			
			
					
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en elimar 2:"+e.getMessage());
			return 0;
		}
	}
	
	public Editorial obtenerEditorial(int idAutor) {
		
		Editorial editorial=new Editorial();
		
		try {
			
			String sql="CALL sp_obtenerEditorial(?)";
			this.abrirConectar();
			cst=con.prepareCall(sql);
			cst.setInt(1, idAutor);
			rs=cst.executeQuery();
			if(rs.next()) {
				
				editorial.setIdLibro(rs.getInt("codigo_editorial"));
				editorial.setNombre(rs.getString("nombre_editorial"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
			}
			this.cerrarConectar();
			return editorial;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en obtener 1:"+e.getMessage());
			return null;
		}
		
	}
	
	public int modificarEditorial(Editorial editorial) {
		
		try {
			int filasAfectadas=0;
			String sql="CALL sp_modificarEditorial(?,?,?,?)";
			this.abrirConectar();
			cst=con.prepareCall(sql);
			cst.setInt(1, editorial.getIdLibro());
			cst.setString(2, editorial.getNombre());
			cst.setString(3, editorial.getContacto());
			cst.setString(4, editorial.getTelefono());
			filasAfectadas=cst.executeUpdate();
			return filasAfectadas;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en modificar 1:"+e.getMessage());
			this.cerrarConectar();
			return 0;
			
		}
		
		
	}

}
