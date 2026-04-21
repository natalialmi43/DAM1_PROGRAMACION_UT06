package repaso.javaIO.Biblioteca;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnalisisLecturas {
    public static void main(String[] args) {

        Map<String, Map<String, ResumenAnual>> datos = new HashMap<>();
        String [] generos = {"Ficcion","Ensayo", "Historia", "Ciencia", "Poesia"};


        //Leer y llenar el map

        try (Scanner sc = new Scanner(new File("registro_lecturas"))){

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






            }

        } catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
        }



    }
}
