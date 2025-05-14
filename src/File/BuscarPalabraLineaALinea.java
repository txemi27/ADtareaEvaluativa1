package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuscarPalabraLineaALinea {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Indica por favor la cadena que quieres buscar");
		String cadena=Consola.readString();
		
		    try (BufferedReader fbr = new BufferedReader(new FileReader("C:"+ File.separator + "Users" + File.separator + "jmpalomino" + File.separator + "Documents" + File.separator + "Nueva_carpeta" + File.separator + "ejercicio2Tarea1.txt"))) {
		      int i = 1;
		      int columna = 0;
		      String linea = fbr.readLine();
		      while (linea != null) {
		        if (linea.indexOf(cadena)!=-1) {
		        	columna = linea.indexOf(cadena);
		           	System.out.format("[%d,%d] %s", i, columna, linea);
		           	System.out.println();
		        }
		        i++;   	
		        linea = fbr.readLine();
		      }
		    } catch (FileNotFoundException e) {
		      System.out.println("No existe fichero ");
		    } catch (IOException e) {
		      System.out.println("Error de E/S: " + e.getMessage());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

}