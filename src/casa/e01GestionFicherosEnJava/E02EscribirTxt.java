package casa.e01GestionFicherosEnJava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
1. Cada frase introducida se debe guardar en un archivo llamado diario.txt.
2. El programa debe seguir pidiendo frases hasta que el usuario escriba la palabra "FIN".
3. Asegúrate de que si ejecutas el programa dos veces, las frases nuevas se añadan debajo de las antiguas sin borrar las anteriores (modo append).
*/

public class E02EscribirTxt {
    public static void main(String[] args) {


        File archivo = new File("diario.txt");

        try {
            if (archivo.createNewFile()){
                System.out.println("creado");
            } else {
                System.out.println("Existe");
            }
        } catch (IOException e){
            System.out.println("error");
            e.printStackTrace();
        }


        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true));
            Scanner sc = new Scanner(System.in);
            System.out.println("Empieza a escribir, escribe 'FIN' para salir ");

            while (true){
                String line = sc.nextLine();

                if(line.equals("FIN")){
                    break;
                }

                escritor.write(line);
                escritor.newLine();
            }

            escritor.close();
            sc.close();
        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
