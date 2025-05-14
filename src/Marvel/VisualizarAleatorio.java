package Tareas;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class VisualizarAleatorio {
	
	public static void main(String[] args) {
		final int long_registro = 132; //Longitud del registro 
		final int TPO_GENERO = 104;
		
		File fichero = new File("." + File.separator + "src" + File.separator + "Tareas" + File.separator + "marvel.dat");
		
		try {
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		String isbnFichero, tituloFichero, autorFichero, generoConsola, generoFichero;
		Boolean existeGenero = false;
		
		System.out.println("Introduce el género:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		generoConsola = in.readLine();
		
		for(int p = 0; p<file.length(); p+=long_registro) {
			file.seek(p);
			file.skipBytes(TPO_GENERO);
			char[] auxGenero =new char[10];
			for(int i=0;i<10;i++)
			{
				auxGenero[i]=file.readChar();
			}
			generoFichero = new String(auxGenero);
			if(generoFichero.trim().equalsIgnoreCase(generoConsola)){
				existeGenero = true;
				file.seek(p);
				file.skipBytes(4);//Salto el código
				//Recojo el ISBN
				char[] auxIsbn =new char[10];
				for(int i=0;i<10;i++)
				{
					auxIsbn[i]=file.readChar();
				}
				isbnFichero = new String(auxIsbn).trim();
				
				//Recojo el titulo
				char[] auxTitulo =new char[20];
				for(int i=0;i<20;i++)
				{
					auxTitulo[i]=file.readChar();
				}
				tituloFichero = new String(auxTitulo).trim();
				//Recojo el autor
				char[] auxAutor =new char[20];
				for(int i=0;i<20;i++)
				{
					auxAutor[i]=file.readChar();
				}
				autorFichero = new String(auxAutor).trim();
			

				file.skipBytes(20); // Saltar el tipo (10 chars = 20 bytes)

				// Leer peso y altura
				int peso = file.readInt();
				int altura = file.readInt();
									
				System.out.println("\tDNI: "+isbnFichero);
				System.out.println("\tHeroe: "+tituloFichero);
				System.out.println("\tNombre Real: "+autorFichero);
				System.out.println("\tTipo: "+generoFichero);
				System.out.println("\tPeso: "+peso);
				System.out.println("\tAltura: "+altura);
				System.out.println();
			}
		
		if(!existeGenero)
			System.out.println("El género introducido no existe.");
		}
		
		file.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
