package casa.e01GestionFicherosEnJava;

/*
Tarea: Crea un programa que intente copiar el contenido de archivo_origen.txt a archivo_destino.txt.

Acción:
1. Si archivo_origen.txt no existe, el programa no debe "romperse", sino capturar la excepción FileNotFoundException
(o NoSuchFileException) y mostrar un mensaje amigable al usuario: "Error: El archivo de origen no se ha encontrado".
2. Asegúrate de utilizar try-with-resources para que los flujos de lectura y escritura se cierren automáticamente,
ocurra o no un error.
 */

import java.io.*;
import java.util.Scanner;

public class E05CopiaSeguridad {
    public static void main(String[] args) {

        String origen = "archivo_origen.txt";
        String destino = "archivo_destino.txt";

        // 1. Usamos try-with-resources para declarar AMBOS flujos.
        // Se separan con un punto y coma (;). Java cerrará los dos al terminar.
        try ( Scanner sc = new Scanner(new FileReader(origen));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(destino))
        ) {
            String linea = sc.nextLine();

            // 2. Bucle de lectura/escritura: mientras haya texto en el origen...
            while (sc.hasNextLine()){
                escritor.write(linea);
                escritor.newLine();
                linea = sc.nextLine();
            }

            System.out.println("Copia finalizada con éxito.");

        } catch (FileNotFoundException e) {
            // 3. Captura específica según el enunciado
            System.out.println("Error: El archivo de origen no se ha encontrado (" + origen + ")");

        } catch (IOException e) {
            // 4. Captura general para otros problemas (disco lleno, sin permisos, etc.)
            System.out.println("Ocurrió un error inesperado durante la copia.");
            e.printStackTrace();
        }

    }
}
