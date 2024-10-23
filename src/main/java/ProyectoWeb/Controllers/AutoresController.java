package ProyectoWeb.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    		//nuevo;
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
