package ProyectoWeb.Controllers;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

import ProyectoWeb.beans.Editorial;
import ProyectoWeb.model.EditorialModel;

/**
 * Servlet implementation class EditorialController
 */
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditorialModel model = new EditorialModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditorialController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("op") == null) {

			listar(request, response);

			return;
		}

		String operacion = request.getParameter("op");
		switch (operacion) {

		case "listar":
			listar(request, response);
			break;
			
		case "nuevo":
			
			request.getRequestDispatcher("/editoriales/nuevoEditorial.jsp").forward(request, response);
			break;
			
		case "insertar":
			
			insertar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;
		case "obtener":
			obtener(request, response);
			
			break;
		case "modificar":
			modificar(request, response);
			break;
		

		}

	}

	public void listar(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setAttribute("listaEditorial", model.listaEditorial());
			Iterator<Editorial> it = model.listaEditorial().iterator();
			while (it.hasNext()) {
				Editorial editorial = it.next();
				System.out.println(editorial.getIdLibro() + " " + editorial.getNombre() + " " + editorial.getContacto()
						+ " " + editorial.getTelefono());
				;
			}
			request.getRequestDispatcher("/editoriales/listaEditorial.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en listar 2:" + e.getMessage());
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			Editorial miEditorial=new Editorial();
			miEditorial.setNombre(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono(request.getParameter("telefono"));
			
			if(model.insertarEditorial(miEditorial)>0) {
				
				request.getSession().setAttribute("exito", "editorial registrado correctamente");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}else {
				
				request.getSession().setAttribute("fracaso", "editorial registrado incorrectamente");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en insertar 2:"+e.getMessage());
		}

	}
	
	private void eliminar(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			int idEditorial=Integer.parseInt(request.getParameter("id"));
			
			if(model.eliminarAutor(idEditorial)>0) {
				
				request.setAttribute("exito", "editorial elimado exitosamente");
			}else {
				request.setAttribute("fracaso", "editorial no eliminado");
			}
			
			request.getRequestDispatcher("/EditorialController?op=listar").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en eliminar 2:"+e.getMessage());
		}
	}
	
	private void obtener(HttpServletRequest request,HttpServletResponse response) {
		try {
			
			String id=request.getParameter("id");
			Editorial miEditorial=model.obtenerEditorial(Integer.parseInt(id));
			
			if(miEditorial !=null) {
				request.setAttribute("editorial", miEditorial);
				request.getRequestDispatcher("/editoriales/editarEditorial.jsp").forward(request, response);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en obtener 2:"+e.getMessage());
		}
		
	}
	
	private void modificar(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			Editorial miEditorial=new Editorial();
			miEditorial.setIdLibro(Integer.parseInt(request.getParameter("codigo")));
			miEditorial.setNombre(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono(request.getParameter("telefono"));
			request.setAttribute("editorial", miEditorial);
			
			if(model.modificarEditorial(miEditorial)>0) {
				
				request.getSession().setAttribute("exito", "autor modificado correctamente");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}else {
				
				request.getSession().setAttribute("fracaso", "autor modificado incorrectamente");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
				
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en modificar 2:"+e.getMessage());
		}
		
	}

}
