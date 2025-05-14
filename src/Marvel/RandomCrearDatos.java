package Tareas;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomCrearDatos {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		final int long_registro = 132; //Longitud del registro 
		File datos = new File("." + File.separator + "src" + File.separator + "Tareas" + File.separator + "marvel.dat");
		
		// Declaramos los arrays que se van a usar como datos del archivo.
				int[] ids = { 1, 2, 3, 4, 5, 6, 7 };
				String[] dnis = { "01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F" };
				String[] noms = { "Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin" };
				String[] identidades = { "Peter Parker", "Norman Osborn", "Ororo Munroe", "James Howlett", "Raven Darkholme",
						"Tony Stark", "Zhang Tong" };
				String[] tipos = { "heroe", "villano", "heroe", "heroe", "villano", "heroe", "villano" };
				int[] pesos = { 76, 84, 66, 136, 78, 102, 70 };
				int[] alturas = { 178, 183, 156, 152, 177, 182, 188 };
		
		
		try {
			
			StringBuffer buffer = null;
			int n = ids.length;
			RandomAccessFile rDatos = new RandomAccessFile(datos,"rw");
			
			for(int i = 0; i < n;i++) {
				// Escribimos los ids
				rDatos.writeInt(ids[i]);
				// Escribimos los dnis
				buffer = new StringBuffer(dnis[i]);
				buffer.setLength(10);
				rDatos.writeChars(buffer.toString());
				// Escribimos los nombres
				buffer = new StringBuffer(noms[i]);
				buffer.setLength(20);
				rDatos.writeChars(buffer.toString());
				// Escribimos los identidades
				buffer = new StringBuffer(identidades[i]);
				buffer.setLength(20);
				rDatos.writeChars(buffer.toString());
				// Escribimos los tipos
				buffer = new StringBuffer(tipos[i]);
				buffer.setLength(10);
				rDatos.writeChars(buffer.toString());
				
				rDatos.writeInt(pesos[i]);
				
				rDatos.writeInt(alturas[i]);
				
				
				
				
			}
			
			rDatos.close();
			
			System.out.println("Proceso de volcado completado");
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
