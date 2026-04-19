package repaso.javaIO;

import java.io.File;
import java.io.IOException;

/*

Acción: 1. Comprueba si la carpeta ya existe.Si no existe, créala.
2. Dentro de esa carpeta, crea dos archivos vacíos: datos.txt y config.ini.
3. Lista por consola el contenido de MiDirectorioDAM, mostrando el nombre de cada archivo y su tamaño en bytes.

 */
public class GestionFicheros {
    public static void main(String[] args) {

        File directorio = new File("DirectDAM");

        if(!directorio.exists()){
            boolean existe = directorio.mkdir();
            if(existe){
                System.out.println("Existe");
            } else {
                System.out.println("No existe");
                return;
            }
        } else {
            System.out.println("Direct ya existe");
        }

        File aDatos = new File(directorio, "aDatos.txt");
        File aConfig = new File(directorio, "aConfig.ini");

        try {
            if(aDatos.createNewFile()){
                System.out.println("Creado");
            }
            if(aConfig.createNewFile()){
                System.out.println("Creado");
            }
        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }

        File [] contenido = directorio.listFiles();
        System.out.println("contenido:");

        if(contenido != null && contenido.length > 0){
            for (File f : contenido){
                System.out.println(f.getName());
            }
        } else {
            System.out.println("esta vacio");
        }




    }
}
