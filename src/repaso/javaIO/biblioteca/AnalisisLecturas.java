package repaso.javaIO.biblioteca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnalisisLecturas {
    public static void main(String[] args) {

        Map<String, Map<String, ResumenAnual>> datos = new HashMap<>();
        String [] generos = {"Ficcion","Ensayo", "Historia", "Ciencia", "Poesia"};


        //Leer y llenar el map

        try (Scanner sc = new Scanner(new File("registro_lecturas.txt"))){

            while (sc.hasNextLine()){
                String linea = sc.nextLine();

                String [] aTrozos = linea.split(";");
                String fecha = aTrozos[0];
                String [] fechaATrozos = fecha.split("-");
                String anio = fechaATrozos[0];
                String nombre = aTrozos[1];
                String genero = aTrozos[2];
                int paginas = Integer.parseInt(aTrozos[3]);

                if(!datos.containsKey(nombre)){
                    datos.put(nombre, new HashMap<>());
                }

                Map<String, ResumenAnual> anioGeneroPaginas = datos.get(nombre);

                if(!anioGeneroPaginas.containsKey(anio)){
                    anioGeneroPaginas.put(anio, new ResumenAnual());
                }

                ResumenAnual resumenAnual = anioGeneroPaginas.get(anio);

                resumenAnual.sumarPaginas(genero, paginas);
            }

        } catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
        }

        //Rellenar
        for (String nombre : datos.keySet()){
            File directorio = new File(nombre);
            if (!directorio.exists()){
                directorio.mkdir();
            }

            Map<String, ResumenAnual> anioGeneroPaginas = datos.get(nombre);

            for (String anio : anioGeneroPaginas.keySet()) {
                String anioFormateado = anio + "_resumen.txt";

                File archivo = new File(directorio, anioFormateado);

                try (BufferedWriter escritor = new BufferedWriter(new FileWriter (archivo))) {

                    ResumenAnual resumenAnual = anioGeneroPaginas.get(anio);

                    // ********

                    for (int i = 0; i < generos.length ; i++) {

                    }

                } catch (IOException e){
                    System.out.println("Error al escribir");
                    e.printStackTrace();
                }
            }
        }

    }
}
