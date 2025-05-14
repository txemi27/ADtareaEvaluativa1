package Ejercicio03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerAlumno {
	
	public static void main(String[] args) throws IOException {
		
		Alumno alumno = new Alumno();
		File fichero = new File("." + File.separator + "src" + File.separator + "Ejercicio03" + File.separator + "salida.txt");
		ObjectInputStream fileOut = new ObjectInputStream(new FileInputStream(fichero));
		try {
			
			
			
			
			while(true) {
				alumno = (Alumno) fileOut.readObject();
				System.out.printf("Nombre: %s, Apellido: %s\n", alumno.getNombre(), alumno.getApellido());
			}
			
			
			
		}
		
		catch(EOFException e) {
			System.out.println("Fin del archivo alcanzado.");
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		
fileOut.close();
	}

}
