package File;

import java.io.*;

public class FlujoCaracteres2 {

	public static void main(String[] args) {
		
		try {
		File entrada = new File("C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\nombres.txt");
		BufferedReader lectorEntrada = new BufferedReader(new FileReader(entrada)); //Lee linea a linea en lugar de caracter a caracter
		
		File salida = new File("C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\salidaNombres.txt");
		BufferedWriter escribirSalida = new BufferedWriter(new FileWriter(salida));
		
		String linea;
		
		while((linea = lectorEntrada.readLine())!= null) {
			String[] nombres = linea.split(" ");
			
			String nombre = nombres[0];
			System.out.println(nombre);
			escribirSalida.write(nombre);
			escribirSalida.newLine();
		}
		
		lectorEntrada.close();
		escribirSalida.close(); 
		
		}catch(Exception e) {
			
		}
		
		
	}
}
