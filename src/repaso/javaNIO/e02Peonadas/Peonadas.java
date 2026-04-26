package repaso.javaNIO.e02Peonadas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Peonadas {

    public static void main(String[] args) {

        Map <String, Map<String, int []>> datos = new HashMap<>();

        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        Path rutaPeonadas = Paths.get("peonadas.txt");

        //Leer el documento y rellenar el mapa
        try {

            List<String> lineas = Files.readAllLines(rutaPeonadas);

            for (String linea : lineas){
                String [] trozos = linea.split(";");
                String [] fecha = trozos[0].split("/");
                String anio = fecha[2];
                int mes = Integer.parseInt(fecha[1])-1;

                datos.putIfAbsent(anio, new HashMap<>());

                Map<String, int []> nombres = datos.get(anio);

                for (int i = 1; i <trozos.length ; i++) {
                    String nombre = trozos[1];
                    nombres.putIfAbsent(nombre, new int[12]);
                    nombres.get(nombre)[mes]++;

                }
            }

        } catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
            return;
        }

        //Crear directorios y archivos y escribirlos.

        for (String anio : datos.keySet()){

            Path rutaDirectorio = Paths.get(anio);

            try{
                if (!Files.exists(rutaDirectorio)){
                    Files.createDirectory(rutaDirectorio);
                }

                Map<String, int []> nombres = datos.get(anio);

                for (String nombre : nombres.keySet()){

                    String nombreFormateado = nombre.replace(" ", "_") + "_" + anio + "_peonadas.txt";

                    Path rutaArchivo = rutaDirectorio.resolve(nombre);

                    if (!Files.exists(rutaArchivo)){
                        Files.createDirectory(rutaArchivo);
                    }

                    List <String> peonadas = new ArrayList<>();

                    int [] conteoAsistencias = nombres.get(nombre);

                    for (int i = 0; i < 12; i++) {
                        String linea = meses[i] + ": " + conteoAsistencias[i];
                        peonadas.add(linea);
                    }

                    Files.write(rutaArchivo, peonadas);

                }

            } catch (IOException e){
                System.out.println("Error al crear y escribir");
                e.printStackTrace();
            }
        }

    }
}
