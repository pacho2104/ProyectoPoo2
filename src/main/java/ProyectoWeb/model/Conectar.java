package ProyectoWeb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	private String url="jdbc:mysql://localhost/librospoo2";
	private String user="root";
	private String pass="123456";
	protected Connection con;
	
	
	public void abrirConectar() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			System.out.println("exito al conectar");
			
		} catch (ClassNotFoundException |  SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void cerrarConectar() {
		
		try {
			
			if(con != null && !con.isClosed()) {
				con.close();
				System.out.println("conexion cerrada");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
