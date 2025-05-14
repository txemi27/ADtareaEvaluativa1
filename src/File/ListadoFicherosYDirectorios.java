package File;

import java.io.File;

public class ListadoFicherosYDirectorios {
	
	public static void main(String[] args) {
		System.out.println("Informacion:");
		File f = new File("C:\\Windows");
		String[] lista = f.list();		
		
		if(args.length > 0 && !args[0].isEmpty()) {
			File fArgs = new File(args[0]);
			System.out.println("Informacion del directorio " + fArgs.isAbsolute());
		}
		else {
			for(int i = 0; i < lista.length; i++) {
				File f2 = new File(f, lista[i]);
				System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", lista[i], f2.isFile(), f2.isDirectory());
			}
		}
	}

}
