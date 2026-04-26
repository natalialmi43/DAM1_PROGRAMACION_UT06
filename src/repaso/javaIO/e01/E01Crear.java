package repaso.javaIO.e01;


import java.io.File;
import java.io.IOException;

/*
Ejercicio 1: El Explorador de Archivos (clase File o Files)
Objetivo: Comprender la navegación por el sistema de ficheros, la creación de directorios y la comprobación de
existencia.

Tarea: Crea un programa que al iniciarse genere una carpeta llamada MiDirectorioDAM en la raíz del proyecto.

Acción:
1. Comprueba si la carpeta ya existe. Si no existe, créala.
2. Dentro de esa carpeta, crea dos archivos vacíos: datos.txt y config.ini.
3. Lista por consola el contenido de MiDirectorioDAM, mostrando el nombre de cada archivo y su tamaño en bytes.
 */

public class E01Crear {
    public static void main(String[] args) {
        // 1. Comprueba si la carpeta ya existe. Si no existe, créala.
        File directorio = new File("MiCarpetaPruebaIO");
        if(!directorio.exists()){
            boolean creado = directorio.mkdir();

            if(creado){
                System.out.println("D creado");
            } else {
                System.out.println("Error al crear D");
            }
        } else {
            System.out.println("Ya existe");
        }

        // 2. Dentro de esa carpeta, crea dos archivos vacíos: datos.txt y config.ini.

        File aDatos = new File(directorio, "datos.txt");
        File aConf = new File(directorio, "config.init");

        try{
            if(aDatos.createNewFile()){
                System.out.println("Creada aDatos");
            }

            if (aConf.createNewFile()){
                System.out.println("Creada aConfig");
            }
        } catch (IOException e){
            System.out.println("Error al crear archivos");
            e.printStackTrace();
        }

        // 3. Lista por consola el contenido de MiDirectorioDAM, mostrando el nombre de cada archivo y su tamaño en bytes.

        File [] list = directorio.listFiles();
        System.out.println("Contenido: ");

        if (list != null && list.length > 0){

            for (File f : list){
                System.out.println(f.getName() + " Tamaño: " + f.length() + " Path: " + f.getPath());
            }
        }


    }
}
