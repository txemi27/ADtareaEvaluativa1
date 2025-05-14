package ejercicio04;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LibrosAleatorio {
	
	public static void main(String[] args)throws IOException {
		
		File fichero = new File("." + File.separator + "src" + File.separator + "Ejercicio04" + File.separator + "libros.dat");
		RandomAccessFile file = new RandomAccessFile(fichero,"rw");
		
		int [] ids= {1, 2, 3, 4, 5, 6};
		String[] isbns= {"978-6-0654-9819-8", "978-8-9523-1353-9", "978-3-2580-1238-4", "978-2-9722-8669-9", "978-6-4710-4331-9", "978-0-2782-5910-2"};
		String[] titulos= {"Harry Potter", "1984", "Yo, Robot", "Neuromante" , "American Gods", "La casa alemana"};
		String[] autores = {"JK Rowling", "George Orwell", "Isaac Asimov", "William Gibson", "Neil Gaiman", "Annette Heiss"};
		String[] generos = {"Accion", "Ciencia Ficcion", "Ciencia Ficcion", "Ciencia Ficcion", "Accion", "Accion"};
		int[] ejemplaresVendidos = {76664, 44478, 54578, 35467, 65677, 74788};
		
		StringBuffer buffer = null;
		int n= isbns.length;
		
		for(int i = 0; i < n; i++) {
			file.writeInt(ids[i]);
			buffer = new StringBuffer(isbns[i]);
			buffer.setLength(20);
			file.writeChars(buffer.toString());
			
			buffer = new StringBuffer(titulos[i]);
			buffer.setLength(20);
			file.writeChars(buffer.toString());
			
			buffer = new StringBuffer(autores[i]);
			buffer.setLength(20);
			file.writeChars(buffer.toString());
			
			buffer = new StringBuffer(generos[i]);
			buffer.setLength(20);
			file.writeChars(buffer.toString());
			
			file.writeInt(ejemplaresVendidos[i]);
			
		}
		
		file.close();
		
	}

}
