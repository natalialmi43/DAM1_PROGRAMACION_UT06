package casa.e01GestionFicherosEnJava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E01GestionFicheros {
    public static void main(String[] args) {

        // 1. Comprueba si la carpeta ya existe. Si no existe, créala.
        File directorio = new File("DirectorioDam");

        if (!directorio.exists()) {
            boolean creado = directorio.mkdir();

            if (creado) {
                System.out.println("Creado");
            } else {
                System.out.println("Error");
                return;
            }
        } else {
            System.out.println("Ya existe");
        }

        // 2. Dentro de esa carpeta, crea dos archivos vacíos: datos.txt y config.ini.
        File aDatos = new File(directorio, "aDatos.txt");
        File aConf = new File(directorio, "aConf.ini");

        try {
            if (aDatos.createNewFile()) {
                System.out.println("Creado");
            }
            if (aConf.createNewFile()) {
                System.out.println("Creado");
            }
        } catch (IOException e) {
            System.out.println("Errooooor");
            e.printStackTrace();
        }

        // 3. Lista por consola el contenido de MiDirectorioDAM, mostrando el nombre de cada archivo y su tamaño en bytes
        File[] conte = directorio.listFiles();
        System.out.println("contenido");

        if (conte != null && conte.length > 0) {
            for (File f : conte) {
                System.out.println(f.getName() + ", tamaño: " + f.length());
            }
        } else {
            System.out.println("Vacio");
        }

    }
}
