package repaso.javaNIO.e01repaso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;

/*
Ejercicio 2: El Diario de Clase (Escritura de Texto Plano)
Objetivo: Practicar la escritura de texto añadiendo contenido al final del archivo (append).

Tarea: Crea un programa que funcione como un diario. Debe pedir al usuario por consola que introduzca frases.

Acción:
1. Cada frase introducida se debe guardar en un archivo llamado diario.txt.
2. El programa debe seguir pidiendo
frases hasta que el usuario escriba la palabra "FIN".
3. Asegúrate de que si ejecutas el programa dos veces, las frases nuevas se añadan debajo de las antiguas sin
borrar las anteriores (modo append).
 */
public class E02Escribir {
    public static void main(String[] args) {

        Path rutaDiario = Paths.get("diario.txt");

        try(Scanner sc = new Scanner(System.in)) {

            System.out.println("Escribe, para salir, escibre 'FIN'");
            String frase = sc.nextLine();

            while(!frase.equalsIgnoreCase("FIN")){
                Files.write(
                        rutaDiario,
                        Collections.singletonList(frase),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );
                frase = sc.nextLine();
            }
            System.out.println("Guardado");


        }catch (IOException e){
            System.out.println("Erro al escibir");
            e.printStackTrace();
        }
    }
}

