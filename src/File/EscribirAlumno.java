package Ejercicio03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class EscribirAlumno {

	public static void main(String[] args) throws IOException {
		
		File fichero = new File("." + File.separator + "src" + File.separator + "Ejercicio03" + File.separator + "salida.txt");
	
		try {
			
			FileOutputStream fileOut = new FileOutputStream(fichero);
			ObjectOutputStream datOS = new ObjectOutputStream(fileOut);
			
			Alumno alumno1 = new Alumno("Txemi","Palomino",LocalDate.parse("1997-08-28"),23);
			
			datOS.writeObject(alumno1);
						
			datOS.close();
			fileOut.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		
	}
	
}
