package ProyectoWeb.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import ProyectoWeb.beans.Autor;
import ProyectoWeb.model.AutoresModel;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AutoresModel modelo=new AutoresModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoresController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getParameter("op")==null) {
    		listar(request, response);
    		return;
    	}
    	String operacion =request.getParameter("op");
    	switch(operacion) {
    	
    	case "lista":
    		listar(request, response);
    		break;
    	case "nuevo":
    		request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
    		break;
    	case "insertar":
    		insetar(request, response);
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
    
    
    private void listar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	/*
    	request.setAttribute("listaAutores",modelo.listarAutores() );
    	request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);*/
    	try {
    		request.setAttribute("listaAutores", modelo.listaAutores());
    		Iterator<Autor> it=modelo.listaAutores().iterator();
    		while(it.hasNext()) {
    			
    			Autor autor=it.next();
    			System.out.println(autor.getIdAutor()+" "+autor.getNombre()+" "+autor.getNacionalidad());
    		}
    		
    		request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    }
    
    private void insetar(HttpServletRequest request,HttpServletResponse response){
    	
    	try {
			
    		Autor miAutor=new Autor();
    		//miAutor.setIdAutor(Integer.parseInt(request.getParameter("codigo")));
    		miAutor.setNombre(request.getParameter("nombre"));
    		miAutor.setNacionalidad(request.getParameter("nacionalidad"));
    		
    		if(modelo.insertarAutor(miAutor)>0) {
    			
    			request.getSession().setAttribute("exito", "autor registrado exitosamente");
    			response.sendRedirect(request.getContextPath()+"/AutoresController?op=lista");
    			
    		}else {
    			
    			request.getSession().setAttribute("fracaso", "autor no registrado ya que hay autor con ese codigo");
    			response.sendRedirect(request.getContextPath()+"/AutoresController?op=lista");
    			
    			
    		}
    	
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
	          System.out.println("error en:"+e.getMessage());
		}
    	
    	
    	
    }
    
    
    
    
    
    private void eliminar(HttpServletRequest request,HttpServletResponse response) {
    	
    	try {
    		
    		int idAutor=Integer.parseInt(request.getParameter("id"));
    				
    				if(modelo.eliminarAutor(idAutor)>0) {
    					request.setAttribute("exito", "autor eliminado exitosamente");
    					
    				}else {
    					request.setAttribute("fracaso", "no se pudo eliminar al autor");
    				}
    		
    	request.getRequestDispatcher("/AutoresController?op=lista").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en elimar dos:"+e.getMessage());
		}
    }
    
    private void obtener(HttpServletRequest request,HttpServletResponse response) {
    	
    	try {
    		
    		String id=request.getParameter("id");
    		Autor miAutor=modelo.obtenerAutor(Integer.parseInt(id));
    		
    		if(miAutor!=null) {
    			request.setAttribute("autor", miAutor);
    			request.getRequestDispatcher("/autores/editarAutor.jsp").forward(request, response);
    		}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en obtener 2:"+e.getMessage());
		}
    }
    
    private void modificar(HttpServletRequest request,HttpServletResponse response) {
    	
    	try {
    		
    		Autor miAutor=new Autor();
    		
    		miAutor.setIdAutor(Integer.parseInt(request.getParameter("codigo")));
    		miAutor.setNombre(request.getParameter("nombre"));
    		miAutor.setNacionalidad(request.getParameter("nacionalidad"));
    		request.setAttribute("autor", miAutor);
    		//request.getRequestDispatcher("AutoresController?op=obtener").forward(request, response);
    		
    		if(modelo.modificarAutor(miAutor)>0) {
    			request.getSession().setAttribute("exito", "autor modificado correctamente");
    			response.sendRedirect(request.getContextPath()+"/AutoresController?op=lista");
    		}else {
    			
    			request.getSession().setAttribute("fracaso", "el autor no ha sido modificado");
    			response.sendRedirect(request.getContextPath()+"/AutoresController?op=lista");
    		}
    		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  processRequest(request, response);
	}

}
