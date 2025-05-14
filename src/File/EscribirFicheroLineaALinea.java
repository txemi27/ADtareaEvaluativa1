package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class EscribirFicheroLineaALinea {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		File fEntrada = new File(args[0]);
		File fSalida = new File("C:\\Users\\jmpalomino\\Documents\\Nueva_carpeta");
		String palabra;
		System.out.println("Introduce la palabra a buscar: ");
		palabra = teclado.nextLine();

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(fEntrada));
			String linea;
			int lineaEncontrada = 1;
			int columnaEncontrada = 0;
			while ((linea = fichero.readLine()) != null) {
				int indice = 0;
				while ((indice = linea.indexOf(palabra, indice)) != -1) {
					
					columnaEncontrada++;
					System.out.println(
							"Texto encontrado en la linea " + lineaEncontrada + " Columna " + columnaEncontrada);
					indice += palabra.length();
				}
				lineaEncontrada++;
			}

		} catch (Exception e) {

		}

	}

}
