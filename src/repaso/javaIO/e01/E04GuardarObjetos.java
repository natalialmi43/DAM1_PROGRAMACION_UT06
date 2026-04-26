package repaso.javaIO.e01;

import repaso.javaNIO.e01repaso.E04Objeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class E04GuardarObjetos {
    public static void main(String[] args) {

        File archivoCVS = new File("productos.csv");

        //Se crea
        if(!archivoCVS.exists()){
            try {
                archivoCVS.createNewFile();
                System.out.println("Creado");
            } catch (IOException e) {
                System.out.println("Error al crear");
            }
        }

        //Se escibre
        try(Scanner sc = new Scanner(System.in);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoCVS,true))){
            System.out.println("Escribe");

            String frase = sc.nextLine();

            while (!frase.equalsIgnoreCase("Fin")){

                bufferedWriter.write(frase);
                bufferedWriter.newLine();
                frase = sc.nextLine();
            }
            System.out.println("Guardado");

        }catch (IOException e) {
            System.out.println("Error al escribir");
        }

        //Se lee
        ArrayList<E04Objeto> listado = new ArrayList<>();

        System.out.println("Contenido:");
        try (Scanner sc = new Scanner(archivoCVS)){
            while (sc.hasNextLine()){
                String liena = sc.nextLine();
                System.out.println(liena);
                String [] lineas = liena.split(";");
                E04Objeto e04Objeto = new E04Objeto();
                e04Objeto.setID(lineas[0]);
                e04Objeto.setNombre(lineas[1]);
                e04Objeto.setPrecio(Double.parseDouble(lineas[2]));
                listado.add(e04Objeto);
            }

        }catch (IOException e) {
            System.out.println("Error al escribir");
        }

        for (E04Objeto e04Objeto : listado){
            String id = e04Objeto.getID();
            String nombre = e04Objeto.getNombre();
            Double precio = e04Objeto.getPrecio();
            System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio);
        }

    }
}
