package Marvel;

import java.io.*;
import java.util.Scanner;

public class DatosPersonajes {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Declaramos los arrays que se van a usar como datos del archivo.
		int[] ids = { 1, 2, 3, 4, 5, 6, 7 };
		String[] dnis = { "01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F" };
		String[] noms = { "Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin" };
		String[] identidades = { "Peter Parker", "Norman Osborn", "Ororo Munroe", "James Howlett", "Raven Darkholme",
				"Tony Stark", "Zhang Tong" };
		String[] tipos = { "heroe", "villano", "heroe", "heroe", "villano", "heroe", "villano" };
		int[] pesos = { 76, 84, 66, 136, 78, 102, 70 };
		int[] alturas = { 178, 183, 156, 152, 177, 182, 188 };

		File personajes = new File("C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\Marvel.dat");

		try {
			// Proceso de escritura en el archivo Marvel.dat
			RandomAccessFile escribirPersonajes = new RandomAccessFile(personajes, "rw");

			StringBuffer bufferDnis = null;
			int n = ids.length;

			for (int i = 0; i < ids.length; i++) {
				escribirPersonajes.writeInt(ids[i]);

				bufferDnis = new StringBuffer(dnis[i]);
				bufferDnis.setLength(9); // Ajusta el tamaño de las cadenas para escribir DNIs
				escribirPersonajes.writeChars(bufferDnis.toString());

				StringBuffer bufferNoms = new StringBuffer(noms[i]);
				bufferNoms.setLength(15); // Ajusta el tamaño de las cadenas para escribir nombres
				escribirPersonajes.writeChars(bufferNoms.toString());

				StringBuffer bufferIdentidades = new StringBuffer(identidades[i]);
				bufferIdentidades.setLength(20); // Ajusta el tamaño para escribir las identidades
				escribirPersonajes.writeChars(bufferIdentidades.toString());

				StringBuffer bufferTipos = new StringBuffer(tipos[i]);
				bufferTipos.setLength(10); // Ajusta el tamaño para escribir los tipos
				escribirPersonajes.writeChars(bufferTipos.toString());

				escribirPersonajes.writeInt(pesos[i]);

				escribirPersonajes.writeInt(alturas[i]);

			}

			escribirPersonajes.close();

			System.out.println("La carga de los personajes ha terminado correctamente");

			// He añadido este metodo que permite visualizar el listado de personajes por si
			// no se acuerdan del dni.
			System.out.print("¿Desea visualizar la lista? (si o no): ");
			String visualizarListado = teclado.next();

			if (visualizarListado.equalsIgnoreCase("si")) {
				mostrar(personajes);
			}

			// Creamos una instancia de la clase que modifica el peso.
			modificarPeso peso = new modificarPeso();

			// Modificamos el peso
			System.out.println("Introduzca el dni (con letra) del personaje para control de peso");
			String dniTeclado = teclado.next();
			boolean existeDni = comprobarDni(dniTeclado, dnis);
			if (existeDni == true) {
				System.out.println("Introduzca su peso actual:");
				int pesoActual = teclado.nextInt();
				peso.modificar(pesoActual, dniTeclado); // Llamamos al metodo de la clase modificarPeso para realizar la
														// comparacion.
			} else {
				System.out.println("El DNI no existe");
			}

			// Creamos una instacia de la clase donde se encuentra el metodo para visualizar
			// el tipo.
			visualizarTipo tipo = new visualizarTipo();

			// Buscamos por tipo de personaje.
			System.out.print("Introduce un tipo de personaje: ");
			String tipoTeclado = teclado.next();

			tipo.VerTipo(tipoTeclado); // Llamamos al metodo de la clase visualizarTipo para comprobar cuantos
										// personajes son del tipo introducido.

			teclado.close();

		} catch (Exception e) {
			System.out.println("Error al guardar los datos en el archivo: ");
		}
	}

	// Metodo que he añadido por si necesitamos visualizar la lista de personajes en
	// el fichero.
	public static void mostrar(File personajes) {

		try {
			RandomAccessFile leerPersonajes = new RandomAccessFile(personajes, "r");

			int id = 0;
			int peso, altura;
			char[] dni = new char[9];

			for (int i = 0; i < 7; i++) {
				id = leerPersonajes.readInt();

				for (int j = 0; j < dni.length; j++) {
					dni[j] = leerPersonajes.readChar();
				}
				String dniPersonaje = new String(dni).trim();

				char[] nomChars = new char[15];
				for (int j = 0; j < 15; j++) {
					nomChars[j] = leerPersonajes.readChar();
				}
				String nomPersonaje = new String(nomChars).trim(); // Elimina espacios en blanco

				char[] identidadChars = new char[20];
				for (int j = 0; j < 20; j++) {
					identidadChars[j] = leerPersonajes.readChar();
				}
				String identidadPersonajes = new String(identidadChars).trim();

				char[] tipoChars = new char[10];
				for (int j = 0; j < 10; j++) {
					tipoChars[j] = leerPersonajes.readChar();
				}
				String tipoPersonaje = new String(tipoChars).trim();

				peso = leerPersonajes.readInt();
				altura = leerPersonajes.readInt();

				System.out.printf("ID: " + id + "" + "\nDNI: " + dniPersonaje + "\nNombre: " + nomPersonaje
						+ "\nIdentidad secreta: " + identidadPersonajes + "\nTipo: " + tipoPersonaje + "\nPeso: " + peso
						+ "\nAltura: " + altura + "\n");
			}

			leerPersonajes.close();

		} catch (Exception e) {
			System.out.println("Error al guardar los datos en el archivo: ");
		}

	}

	// Metodo que comprueba si existe el Dni introducido.
	public static boolean comprobarDni(String comprobarDni, String[] dnis) {

		boolean resultado = false;
		for (String dni : dnis) {
			if (dni.equals(comprobarDni)) {
				resultado = true;
			}
		}

		return resultado;
	}
}
