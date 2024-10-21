package ProyectoWeb.model;

import java.util.ArrayList;
import java.util.List;

import ProyectoWeb.beans.Autor;

public class AutoresModel {
	
	public List<Autor> listarAutores(){
		
		ArrayList<Autor> autores=new ArrayList<Autor>();
		autores.add(new Autor(1, "Pepe", "Lucho"));
		autores.add(new Autor(2, "Luis", "Rios"));
		autores.add(new Autor(3, "Lupe", "Bartra"));
		autores.add(new Autor(4, "Olga", "Moreno"));
		autores.add(new Autor(5, "Leni", "Schurt"));
		return autores;
		
	}
	

}
