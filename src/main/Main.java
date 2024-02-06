package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Main.Articulo;
import Main.Menu;

public class Main {

	
public static final String fichero = "articulos.dat";
private static ArrayList<Articulo> listaArticulos;

	public static void main(String[] args) {
		
		File file = new File(fichero);
		
		listaArticulos = new ArrayList<Articulo>();
		
		System.out.println("Bienvenido a programa de gestión de stock");
		System.out.println("");
		if (file.exists()) {
				System.out.println("Existe un fichero con información");
			
			try(FileInputStream fis = new FileInputStream("articulos.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);) {
				
				listaArticulos = (ArrayList<Articulo>)ois.readObject();
				
				System.out.println(""
						+ "Fichero cargado");
				
			} catch (FileNotFoundException e) {
				System.out.println("no hay archivo");
				System.out.println("");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}	
		else
			System.out.println("NO existen ficheros");
		
		int opcion = 0;
		do {
			opcion= Menu.pintarMenu();
			switch (opcion) {
				case 1:
					anadirCoche();
				break;
				case 2:
					borrar();
				break;
				case 3:
					consultar();
				break;
				case 4:
					modificar();
				break;	
				case 5:
					listar();
				break;
				case 6:
					gestionPasageros;
				break;
				case 7:
				//	salir;
				break;
			}
		}while (opcion!=6);
		
		System.out.println("Fin del programa");
	}
}
