package casa.e01GestionFicherosEnJava;

/*
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

        //Se crea el archivo
        File arch = new File("poema.txt");

        try{
            if(arch.createNewFile()){
                System.out.println("Creado");
            } else {
                System.out.println("Existe");
            }

        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }

        //Se escribe
        try {
            //Se pone fuera del parentesis porque son varios recursos que usamos, IMPORTANTE CERRARLO
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arch, true));
            Scanner sc = new Scanner(System.in);
            System.out.println("Escribe FIN para dejar de escribir");

            while (true){
                String line = sc.nextLine();

                if (line.equals("FIN")){
                    break;
                }
                escritor.write(line);
                escritor.newLine();
            }
            escritor.close();
            sc.close();

        } catch (IOException e){
            System.out.println("Error al escribir");
            e.printStackTrace();
        }

        //Creamos contadores
        int totalLineas = 0;
        int totalA = 0;

        //Se escribe entre parentesis porque es un recurso, NO es necesario cerrarlo, se cierra solo.
        try (Scanner lector = new Scanner(arch)){

            System.out.println("Contenido: ");

            while (lector.hasNextLine()){
                String line = lector.nextLine();
                System.out.println(line);

                totalLineas++;

                for (int i = 0; i < line.length(); i++) {
                    char letra = line.charAt(i);
                    if(letra == 'a' || letra == 'A'){
                        totalA ++;
                    }
                }
            }


        } catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println("Lineas totales: " + totalLineas);
        System.out.println("'A' totales: " + totalA);
    }
}


