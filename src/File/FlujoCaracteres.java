package File;

import java.io.*;

public class FlujoCaracteres {
	public static void main(String[] args) {

		String archivoEntrada = "C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\entrada.txt";

		
		try {
			FileReader entrada = new FileReader(archivoEntrada); 
			
			int i; 
			String linea = "";
			while((i = entrada.read()) != -1) {
				linea += (char)i;
			}
			
			entrada.close();
			
			boolean salida = escribirInvertido(linea);
			
			if(salida == true) {
			System.out.println("Proceso completado");
			}
			
			else {
				System.out.println("Algo ha fallado");	
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
	public static boolean escribirInvertido(String linea) {
		boolean escribe = false;
		
		try {
			FileWriter archivoSalida = new FileWriter("C:\\\\Users\\\\jmpalomino\\\\Documents\\\\Nueva carpeta\\\\ACCESO A BBDD\\\\salida.txt");
			
			for(int i = linea.length() - 1; i >= 0; i--) {
				archivoSalida.write(linea.charAt(i));
				escribe = true;
			}
			
			archivoSalida.close();
		}catch(Exception e) {
			
		}
		return escribe;
		
	}

}
