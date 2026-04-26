package repaso.javaNIO.e01repaso;

/*
Ejercicio 1: El Explorador de Archivos (clase File o Files)
Objetivo: Comprender la navegación por el sistema de ficheros, la creación de directorios y la comprobación de existencia.

Tarea: Crea un programa que al iniciarse genere una carpeta llamada MiDirectorioDAM en la raíz del proyecto
 1. Comprueba si la carpeta ya existe. Si no existe, créala.
 2. Dentro de esa carpeta, crea dos archivos vacíos: datos.txt y config.ini.
 3. Lista por consola el contenido de MiDirectorioDAM, mostrando el nombre de cada archivo y su tamaño en bytes.
 */

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class E01Crear {
    public static void main(String[] args) {

        Path directorio = Paths.get("pruebaNio");

        try {

            if(!Files.exists(directorio)){
                Files.createDirectory(directorio);
            }

            Path aDatos = directorio.resolve("datos.txt");
            Path aConfig = directorio.resolve("conf.init");

            if(!Files.exists(aDatos)){
                Files.createFile(aDatos);
            }

            if (!Files.exists(aConfig)){
                Files.createFile(aConfig);
            }

            try (DirectoryStream <Path> contenido = Files.newDirectoryStream(directorio)){

                for (Path f : contenido){
                    long size = Files.size(f);
                    String name = f.getFileName().toString();
                    System.out.println("Nombre: " + name + " tamaño: " + size);
                }

            }

        } catch (IOException e){
            System.out.println("Eror en el sistema");
            e.printStackTrace();
        }

    }
}
