package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerFicheroLineaALinea {
	
	public static void main(String[] args) {
		File fichero = new File(args[0]);
		
		
		try {
			/* Fihcero leido caracter a caracter 
			 * FileReader fic = new FileReader(fichero);
			 
			
			int i;
			while((i=fic.read()) != - 1)
				System.out.print((char)i);
			*/
			
			BufferedReader leerFichero = new BufferedReader(new FileReader(fichero));
			
			String linea;
			int cont = 0;
			while((linea = leerFichero.readLine())!=null) {
				cont++;
				System.out.println(cont + ". " + linea);
			
			}
			leerFichero.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
