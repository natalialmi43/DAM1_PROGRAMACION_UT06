package casa.e02Peonadas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Peonadas {
    public static void main(String[] args) {

        Map<String, Map<String, int[]>> datos = new HashMap<>();
        String[] mesesNombres = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};


        try (Scanner sc = new Scanner(new File("peonadas.txt"))){

            while(sc.hasNextLine()){

                String line = sc.nextLine();

                String [] lineaATrocitos = line.split(";");

                String fechaCompleta = lineaATrocitos[0];
                String [] fechaTrozos = fechaCompleta.split("/");
                int mes = Integer.parseInt(fechaTrozos[1]) -1;
                String anio = fechaTrozos[2];

                if(!datos.containsKey(anio)){
                    datos.put(anio, new HashMap<>());
                }

                Map<String, int[]> personasMes = datos.get(anio);


                //Se recorre desde e1 1, porque el 0 es la fecha
                for (int i = 1; i < lineaATrocitos.length; i++) {
                    String nombreTrabajador = lineaATrocitos[i].trim();
                    if (nombreTrabajador.isEmpty()) continue;

                    if(!personasMes.containsKey(nombreTrabajador)){
                        personasMes.put(nombreTrabajador, new int[12]);
                    }
                    //Obtiene un array y en ese mismo instante le dice okey en la posicio x suma uno
                    personasMes.get(nombreTrabajador)[mes]++;
                }
            }
        } catch (IOException e){
            System.out.println("Error al leer");
            e.printStackTrace();
        }



        for (String anio : datos.keySet()){
            File carpetaAnio = new File(anio);
            if (!carpetaAnio.exists()){
                carpetaAnio.mkdir();
            }

            Map<String, int[]> personas = datos.get(anio);

            for (String nombre : personas.keySet()){
                String nombreArchivo = nombre.replace(" ", "_") + "_" + anio + "_peonadas.txt";
                File archivoPersona = new File(carpetaAnio, nombreArchivo);

                try(BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoPersona))){
                    int [] conteoMeses = personas.get(nombre);

                    for (int i = 0; i < 12; i++) {
                        escritor.write(mesesNombres[i] + " " + conteoMeses[i]);
                        escritor.newLine();
                    }

                } catch (IOException e){
                    System.out.println("Error, no se ha creado el archivo");
                }
            }
            System.out.println("Generado correctamente");
        }

    }
}
