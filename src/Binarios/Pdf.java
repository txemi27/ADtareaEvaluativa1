package Binarios;

import java.io.*;

public class Pdf {
	public static void main(String[] args) {

	    try {
            
            File pdfFile = new File("C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\prueba.pdf");
            
            // Abrimos el archivo en modo binario
            FileInputStream entrada = new FileInputStream(pdfFile);

          
            int[] secuenciaPdf = {37, 80, 68, 70}; // %PDF en ASCII
            boolean esValido = true;

    
            for (int j = 0; j < secuenciaPdf.length; j++) {
                int byteLeido = entrada.read();
                if (byteLeido != secuenciaPdf[j]) {
                    esValido = false;
                    break; 
                }
            }

            entrada.close();

            // Resultado de la validación
            if (esValido) {
                System.out.println("El archivo es un PDF válido.");
            } else {
                System.out.println("El archivo no es válido.");
            }

        }catch (Exception e) {
			System.out.println("Fallo al leer el archivo");
		}
	}
}



