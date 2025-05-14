package Ejercicio03;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class RepetirVocal {
	
	public static void main(String[] args) {
		
		File f = new File("." + File.separator + "src" + File.separator + "ejercicio03" + File.separator + "entrada.txt");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce vocal a buscar: ");
		char letra = teclado.next().charAt(0);
		
		try {
			
			FileReader leerF = new FileReader(f);
			int i;
			char caracter = 0;
			int cont = 0;
			while((i = leerF.read())!=-1) {
				caracter = (char)i;
				
				if(caracter == letra) {
					cont++;
				}
				
			}
			
			System.out.println("La letra: " + letra + " se repite " + cont + " veces.");
			
		}
		catch(Exception e) {
			e.getMessage();
			
		}
	}

}
