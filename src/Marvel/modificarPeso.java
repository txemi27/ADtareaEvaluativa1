package Marvel;

import java.io.*;

public class modificarPeso {

	public void modificar(int pesoActual, String dniTeclado) {

		File personajes = new File("C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\Marvel.dat");
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

				int pesoTotal;

				// Realizamos la comprobacion del peso actual introducido con el alojado en el
				// fichero.
				if (dniPersonaje.equals(dniTeclado)) {
					if (peso > pesoActual) {
						pesoTotal = peso - pesoActual;
						System.out.println(nomPersonaje + " ha adelgazado " + pesoTotal + " kilos.");
					} else if (peso < pesoActual) {
						pesoTotal = pesoActual - peso;
						System.out.println(nomPersonaje + " ha engordado " + pesoTotal + " kilos.");
					} else if (peso == pesoActual) {
						System.out.println(nomPersonaje + " se mantiene en su peso anterior.");
					}
					System.out.println("");
				}
			}

			leerPersonajes.close();

		} catch (Exception e) {
			System.out.println("Error al comprobar el peso.");
		}

	}

}
