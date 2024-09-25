package Marvel;

import java.io.File;
import java.io.RandomAccessFile;

public class visualizarTipo {

	public void VerTipo(String tipoTeclado) {

		File personajes = new File("C:\\Users\\jmpalomino\\Documents\\Nueva carpeta\\ACCESO A BBDD\\Marvel.dat");

		try {
			RandomAccessFile leerPersonajes = new RandomAccessFile(personajes, "r");

			int id = 0;
			int peso, altura;
			char[] dni = new char[9];
			int cont = 0;
			String resultado = "";

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

				// Vamos contando cuantos personajes son de ese tipo y vamos añadiendo al
				// personaje en los datos que se van a mostrar.
				if (tipoPersonaje.equals(tipoTeclado)) {
					cont++;
					resultado += "Personaje [dni=" + dniPersonaje + ", nombre=" + nomPersonaje + ", identidad="
							+ identidadPersonajes + ", tipo=" + tipoPersonaje + ", peso=" + peso + ", altura=" + altura
							+ "]\n";
				}

			}

			// Devolvemos el resultado dependiendo de si tiene valor o no. En el caso de que
			// no tenga el valor introducido no existe en el fichero.
			if (resultado != "") {
				System.out.println("Se han encontrado " + cont + " " + tipoTeclado + "s.");
				System.out.print(resultado);
			} else {
				System.out.println("No existe " + tipoTeclado + " en el fichero.");
			}

			leerPersonajes.close();

		} catch (Exception e) {
			System.out.println("Error al comprobar el tipo.");
		}

	}

}
