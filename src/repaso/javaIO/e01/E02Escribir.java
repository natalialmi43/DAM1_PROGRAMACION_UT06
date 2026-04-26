package repaso.javaIO.e01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        File archivo = new File("diario.txt");
        try{
            if (!archivo.exists()){
                archivo.createNewFile();
                System.out.println("Creado");
            } else {
                System.out.println("Existe");
            }

            try (Scanner sc = new Scanner(System.in); BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))){

                System.out.println("Escribe, para salir, escibre 'FIN'");
                String frase = sc.nextLine();

                while (!frase.equalsIgnoreCase("FIN")){
                    escritor.write(frase);
                    escritor.newLine();
                    frase = sc.next();
                }
                System.out.println("Guardado");
            } catch (IOException e){
                System.out.println("Error al escribir");
                e.printStackTrace();
            }

        } catch (IOException e){
            System.out.println("Error al escribir");
            e.printStackTrace();
        }
    }

}
