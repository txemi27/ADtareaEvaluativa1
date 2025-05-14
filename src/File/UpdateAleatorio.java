package ejercicio04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class UpdateAleatorio {
	
	public static void main(String[] args) throws IOException {
		final int long_registro = 168; //Longitud del registro 
		try	{
			File fichero = new File("." + File.separator + "src" + File.separator + "Ejercicio04" + File.separator + "libros.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			int idConsola, idFichero, ejemplaresConsola, ejemplaresFichero, ejemplaresTotal, posicion;
			String tituloFichero, autorFichero, generoFichero, isbnFichero;
			char [] aux = new char[20];
			
			System.out.println("Introduzca el identificador del Libro:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			idConsola = Integer.valueOf(in.readLine());
			posicion = (idConsola-1) * long_registro;
			
			if(posicion >= file.length()){
				System.out.println("El libro no existe");
			}
			else
			{
				file.seek(posicion);
				idFichero=file.readInt();
			
				if(idFichero!=idConsola) {
					System.out.println("El Libro no existe");
				}
				else {
					System.out.println("Introduzca los ejemplares vendidos este mes:");
					ejemplaresConsola = Integer.valueOf(in.readLine());
					file.seek(posicion);
					idFichero=file.readInt();
					
					for (int i=0;i<20;i++) {
						aux[i]=file.readChar();
					}
					isbnFichero= new String(aux).trim();
					
					for (int i=0;i<20;i++) {
						aux[i]=file.readChar();
					}
					tituloFichero= new String(aux).trim();
					
					for (int i=0;i<20;i++) {
						aux[i]=file.readChar();
					}
					autorFichero= new String(aux).trim();
					
					for (int i=0;i<20;i++) {
						aux[i]=file.readChar();
					}
					generoFichero= new String(aux).trim();
					
					ejemplaresFichero = file.readInt();
					ejemplaresTotal = ejemplaresFichero + ejemplaresConsola;
					file.seek(posicion+164); //Saltamos hasta ejemplares
					file.writeInt(ejemplaresTotal);
					System.out.println("ID del libro:" +isbnFichero);
					System.out.println("ISBN del libro:" +isbnFichero);
					System.out.println("Titulo del libro:" +tituloFichero);
					System.out.println("Autor del libro:" +autorFichero);
					System.out.println("Genero del libro:" +generoFichero);
					System.out.println("N mero de ejemplares anterior:" +ejemplaresFichero);
					System.out.println("Nuevo n mero de ejemplares:" +ejemplaresTotal);
					
				}
			}
			file.close();
		} 
		catch (FileNotFoundException e){}
	}

}