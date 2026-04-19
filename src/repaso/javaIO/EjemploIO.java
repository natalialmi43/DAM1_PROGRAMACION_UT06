package repaso.javaIO;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class EjemploIO {
    public static void main(String[] args) {
        // La clase File representa el archivo físicamente en el sistema[cite: 15, 16].
        // Solo gestiona la información, no puede escribir dentro[cite: 21].
        File archivo = new File("inventario.txt");

        try {
            // Comprobamos si existe y, si no, lo creamos
            if (!archivo.exists()) {
                archivo.createNewFile();
                System.out.println("Archivo creado con éxito.");
            }

            // Para ESCRIBIR caracteres necesitamos FileWriter[cite: 31, 32].
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("Monitor de 24 pulgadas\n");
            escritor.write("Teclado mecánico\n");
            escritor.close(); // Es obligatorio cerrar el flujo (stream) al terminar.

            // Para LEER los datos de forma sencilla usamos Scanner[cite: 41, 42].
            Scanner lector = new Scanner(archivo);
            System.out.println("\nLeyendo el archivo:");

            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
            lector.close(); // Cerramos el flujo de lectura.

        } catch (IOException e) {
            // Este bloque captura cualquier error técnico (ej. falta de permisos en el disco)
            System.out.println("Ha ocurrido un error técnico con el sistema de archivos.");
            e.printStackTrace();
        }
    }
}
