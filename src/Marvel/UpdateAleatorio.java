package Tareas;

import java.io.*;

public class UpdateAleatorio {
    public static void main(String[] args) {
        final int TAM_REGISTRO = 132;
        final int OFFSET_PESO = 124;

        File datos = new File("." + File.separator + "src" + File.separator + "Tareas" + File.separator + "marvel.dat");

        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            RandomAccessFile file = new RandomAccessFile(datos, "rw");
        ) {
            System.out.print("Introduzca el DNI del personaje para controlar el peso: ");
            String dniBuscado = in.readLine().trim();

            long numRegistros = file.length() / TAM_REGISTRO;
            boolean encontrado = false;

            for (int i = 0; i < numRegistros; i++) {
                file.seek(i * TAM_REGISTRO + 4); // Saltamos el id (4 bytes)

                // Leemos el DNI (10 chars → 20 bytes)
                StringBuilder dniLeido = new StringBuilder();
                for (int j = 0; j < 10; j++) {
                    dniLeido.append(file.readChar());
                }

                if (dniLeido.toString().trim().equals(dniBuscado)) {
                    encontrado = true;

                    // Leer el peso actual
                    file.seek(i * TAM_REGISTRO + OFFSET_PESO);
                    int pesoActual = file.readInt();

                    // Pedir nuevo peso
                    System.out.print("DNI encontrado. Introduzca el nuevo peso: ");
                    int nuevoPeso = Integer.parseInt(in.readLine());

                    // Volver a la misma posición para escribir el nuevo peso
                    file.seek(i * TAM_REGISTRO + OFFSET_PESO);
                    file.writeInt(nuevoPeso);

                    // Comparar pesos
                    if (nuevoPeso > pesoActual) {
                        System.out.println("El personaje ha engordado.");
                    } else if (nuevoPeso < pesoActual) {
                        System.out.println("El personaje ha adelgazado.");
                    } else {
                        System.out.println("El personaje mantiene el mismo peso.");
                    }

                    System.out.println("Peso actualizado correctamente.");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("DNI no encontrado en el archivo.");
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
