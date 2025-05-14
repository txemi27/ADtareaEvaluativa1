package Ejercicio03;

import java.io.File;
import java.io.FileReader;

public class MayusculasYMinusculasCambia {
	
	public static void main(String[] args) {
		
		File ficheroEntrada = new File("." + File.separator + "src" + File.separator + "ejercicio03" + File.separator + "entrada.txt");
		
		try {
			FileReader leerEntrada = new FileReader(ficheroEntrada);
			int i;
			char caracter = 0;
			while((i = leerEntrada.read()) !=-1) {
				caracter = (char)i;
				if(caracter>=97 && caracter<=122) {
					caracter-=32;
				}
				else if(caracter>=65 && caracter<=90) {
					caracter+=32;
				}
				
				System.out.print(caracter);
			}
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
