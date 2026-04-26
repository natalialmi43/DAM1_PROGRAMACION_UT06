package repaso.javaIO.e02Peonadas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Peonadas {

    public static void main() {

        Map <String, Map<String, int []>> datos = new HashMap<>();

        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        //Leer archivo y rellenar el Map con datos
        try (Scanner sc = new Scanner(new File("peonadas.txt"))){

            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String [] lineaTrozos = linea.split(";");

                String fecha = lineaTrozos[0];
                String [] fechaTrozos = fecha.split("/");
                String anio = fechaTrozos[2];
                int mes = Integer.parseInt(fechaTrozos[1])-1;

                if(!datos.containsKey(anio)) {
                    datos.put(anio, new HashMap<>());
                }

                Map<String, int []> nombres = datos.get(anio);

                    for (int i = 1; i < lineaTrozos.length ; i++) {
                        String nombre = lineaTrozos[i];
                        if(!nombres.containsKey(nombre)){
                            nombres.put(nombre, new int [12]);
                        }
                        nombres.get(nombre)[mes] ++;
                    }
            }

        }catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
        }

        //Crear directorios/ficheros  y escribirlos.

        //Se crean los directorios
        for (String anio : datos.keySet()){
            File directorio = new File(anio);
            if(!directorio.exists()){
                directorio.mkdir();
            }
            //Se crean los archivos
            Map<String, int []> nombres = datos.get(anio);

            for (String nombre : nombres.keySet()){
                String nombreFormateado = nombre.replace(" ", "_") + "_" + anio + "_peonadas.txt";
                File archivo = new File(directorio, nombreFormateado);

                try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))){

                    int [] conteoMeses = nombres.get(nombre);

                    for (int i = 0; i < 12; i++) {
                        escritor.write(meses[i] + " "+ conteoMeses[i]);
                        escritor.newLine();

                    }

                } catch (IOException e){
                    System.out.println("Error al escribir");
                    e.printStackTrace();
                }

            }
        }





    }
}
