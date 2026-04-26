package repaso.javaIO.e01;

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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E03Leer {
    public static void main(String[] args) {

        File archivo = new File("poema.txt");

        //Se crea
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
                System.out.println("Creado");

            } catch (IOException e) {
                System.out.println("Error al crear");
            }
        }

        //Se escribe
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("poema.txt", true))){ //Ojo como se escribe

            System.out.println("Escribre");
            String frase = scanner.nextLine();

            while (!frase.equalsIgnoreCase("Fin")){
                bufferedWriter.write(frase);
                bufferedWriter.newLine();
                frase = scanner.nextLine();
            }
            System.out.println("Guardado");
        } catch (IOException e){
            System.out.println("Error al escribir");
        }

        //Se lee
        int contadorLineas = 0;
        int contadorA = 0;

        try (Scanner sc = new Scanner(archivo)){

            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                System.out.println(linea);
                contadorLineas ++;

                for (int i = 0; i < linea.length(); i++) {
                    char letraA = linea.charAt(i);
                    if (letraA == 'a' || letraA == 'A'){
                        contadorA ++;
                    }
                }
            }

        } catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
        }

        System.out.println("Total lineas: " + contadorLineas + " total a: " + contadorA);





    }
}
