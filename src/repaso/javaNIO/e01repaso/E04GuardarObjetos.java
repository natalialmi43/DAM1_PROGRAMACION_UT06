package repaso.javaNIO.e01repaso;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E04GuardarObjetos {
    public static void main(String[] args) {

        //Crear

        Path rutaCsv = Paths.get("productos.csv");

        if(!Files.exists(rutaCsv)){
            try {
                Files.createFile(rutaCsv);
                System.out.println("Creado");
            } catch (IOException e){
                System.out.println("Error al crear");
            }
        } else {
            System.out.println("Existe");
        }

        //Escribir
        try (Scanner scanner = new Scanner(System.in)){

            System.out.println("Escribe");
            String linea = scanner.nextLine();

            while (!linea.equalsIgnoreCase("Fin")){
                Files.write(rutaCsv, Collections.singletonList(linea), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                linea = scanner.nextLine();
            }

        }catch (IOException e){
            System.out.println("Error al escribir");
        }


        //Leer

        List<String> listadoCompleto = null;
        try {
            listadoCompleto = Files.readAllLines(rutaCsv);
            for (String path : listadoCompleto){
                System.out.println(path);
            }
        } catch (IOException e){
            System.out.println("Error al leer");
        }




        //Imprimir

    }
}
