package repaso.javaNIO.e01repaso;

/*
Ejercicio 3: El Lector de Poemas (Lectura y Procesamiento)
Objetivo: Leer archivos línea a línea y realizar operaciones con cadenas de texto.

Contexto: Tienes un archivo poema.txt con varias líneas de texto (puedes crearlo a mano previamente).

Tarea: Lee el archivo completo utilizando un BufferedReader o la clase Scanner.

Acción:

Muestra el contenido exacto por consola.

Cuenta y muestra al final cuántas líneas en total tiene el archivo.

Cuenta y muestra cuántas veces aparece la vocal "a" (mayúscula o minúscula) en todo el texto.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E03Leer {
    public static void main(String[] args) {

        //Se crea
        Path rutaPoema = Paths.get("poema.txt");

        if (!Files.exists(rutaPoema)){
            try {
                Files.createFile(rutaPoema);
                System.out.println("Creado");
            } catch (IOException e) {
                System.out.println("Error al crear");
            }
        } else {
            System.out.println("Existe");
        }

        //Escribir
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Escibre");
            String linea = scanner.nextLine();

            while(!linea.equalsIgnoreCase("FIN")){
                Files.write(
                        rutaPoema,
                        Collections.singletonList(linea),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
                linea = scanner.nextLine();
            }
            System.out.println("Guardado");

        } catch (IOException e) {
            System.out.println("Error al escribir");
        }

        //Leer
        try {
            List <String> todasLasLineas = Files.readAllLines(rutaPoema);

            int totalFilas = todasLasLineas.size();
            int totalA = 0;

            for (String frase : todasLasLineas){
                System.out.println(frase);
                for (int i = 0; i < frase.length(); i++) {
                    char letra = frase.charAt(i);
                    if (letra == 'A' || letra == 'a'){
                        totalA++;
                    }
                }
            }
            System.out.println("total lineas " +totalFilas+ " total a: " + totalA);
        } catch (IOException e) {
            System.out.println("Error al leer");
        }

    }
}
