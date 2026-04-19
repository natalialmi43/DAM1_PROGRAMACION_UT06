package casa.e01GestionFicherosEnJava;

/*
Contexto: Crea un archivo productos.csv con el siguiente formato: ID;Nombre;Precio (ej: 1;Teclado Mecánico;45.50).
Tarea: Crea una clase Producto con esos tres atributos.
Acción:
1. Lee el archivo productos.csv línea a línea.
2. Utiliza el método .split(";") para separar los datos.
3. Crea un objeto Producto por cada línea y guárdalo en un ArrayList<Producto>.
4. Muestra la lista de productos por pantalla aplicando un formato de tabla limpio.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class E04GestionProductos {

    public static void main(String[] args) {

        File archivo = new File("productos.csv");

        // Crear archivo
        try{
            if(archivo.createNewFile()){
                System.out.println("Creado");
            }else {
                System.out.println("Existe");
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        //Escribir
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
            Scanner sc = new Scanner(System.in);

            System.out.println("Escribe, si quieres salir pulsa FIN");

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
            System.out.println("Error escribiendo");
            e.printStackTrace();
        }

        // Creamos la lista donde guardaremos los objetos
        ArrayList<E04Producto> lista = new ArrayList<>();

        //Leer el archivo linea a linea
        try (Scanner sc = new Scanner(archivo)){

            System.out.println("Leyendo archivo");

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);

                //Se trocea la linea
                String [] trozo = line.split(";");

                //Se crean los datos
                int id = Integer.parseInt(trozo[0]);
                String nombre = trozo[1];
                double precio = Double.parseDouble(trozo[2]);

                //Se crea el objeto
                E04Producto p = new E04Producto(id,nombre,precio);

                //Se mete a la lista
                lista.add(p);

                //Se saca por pantalla
                System.out.println("Productos:");

                for(E04Producto pr : lista){
                    System.out.println(pr);
                }
            }

        } catch (FileNotFoundException fileNotFoundException){
            System.out.println("No se encuentra el archivo");
        } catch (IOException e){
            System.out.println("Error al leer y crear producto");
            e.printStackTrace();
        }

    }
}
