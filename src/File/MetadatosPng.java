package Ejercicio03;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MetadatosPng {

	public static void main(String[] args) {
		
		File fichero = new File("." + File.separator + "src" + File.separator + "Ejercicio03" + File.separator + "Compras.PNG");
		
		   int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10}; //cabecera de PNG en decimal
	        byte[] ihdrSignature = {73, 72, 68, 82};
		
		try(FileInputStream entradaFichero = new FileInputStream(fichero)){
			int[] pngHeader = new int[8];
			
			for(int i = 0; i < 8; i++) {
				pngHeader[i] = entradaFichero.read(); 
			}
			
			 if (!Arrays.equals(pngHeader, pngSignature)) {
	            	System.out.println("No es un fichero PNG");
	                System.exit(-1);
	            }
			 
			 byte[] longitud = new byte[4];
			 entradaFichero.skip(4);
			 entradaFichero.read(longitud);
			 
			 
			 
			  if (!Arrays.equals(longitud, ihdrSignature)) {
	                System.out.println("La cabecera IHDR no es v lida");
	                System.exit(-1);
	            }
	 
			  // lee los siguientes 4 bytes para obtener anchura (width) 
	            byte[] bytes = new byte[4];
	            entradaFichero.read(bytes);
	            ByteBuffer wrapped = ByteBuffer.wrap(bytes);
	            int width = wrapped.getInt();
	 
	            System.out.println("Width = " + width);
	 
	            // lee los siguientes 4 bytes para obtener altura (height) 
	            // dos formas diferentes de obtener int desde un array de bytes
	            entradaFichero.read(bytes);
	            int height = new BigInteger(bytes).intValue();
	 
	            System.out.println("Height = " + height);
			 
			
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	
}
