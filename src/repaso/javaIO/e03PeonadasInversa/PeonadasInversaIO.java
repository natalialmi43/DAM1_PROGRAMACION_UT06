package repaso.javaIO.e03PeonadasInversa;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeonadasInversaIO {
    public static void main(String[] args) {

        // Directorio raíz donde ejecutamos el programa
        File directorioRaiz = new File(".");

        List<String> lineasResumen = new ArrayList<>();
        lineasResumen.add("Año;Trabajador;Total_Peonadas");

        // 1. EXTRAER EL CONTENIDO DE LA CARPETA RAÍZ
        // listFiles() devuelve un array con todas las carpetas y archivos sueltos
        File[] elementosRaiz = directorioRaiz.listFiles();

        // En IO puro es obligatorio comprobar que el array no sea nulo antes de iterar
        if (elementosRaiz != null) {

            for (File carpeta : elementosRaiz) {
                // Filtramos: Tiene que ser directorio y su nombre tener 4 números
                if (carpeta.isDirectory() && carpeta.getName().matches("\\d{4}")) {
                    String anio = carpeta.getName();

                    // 2. ENTRAR A LA CARPETA DEL AÑO Y SACAR SUS ARCHIVOS
                    File[] archivos = carpeta.listFiles();

                    if (archivos != null) {
                        for (File archivo : archivos) {

                            // Filtramos: Tiene que ser archivo y terminar en peonadas.txt
                            if (archivo.isFile() && archivo.getName().endsWith("_peonadas.txt")) {

                                // 3. LIMPIAR EL NOMBRE
                                String nombreArchivo = archivo.getName();
                                String sufijo = "_" + anio + "_peonadas.txt";
                                String nombreLimpio = nombreArchivo.replace(sufijo, "").replace("_", " ");

                                int sumaTotal = 0;

                                // 4. LEER EL ARCHIVO CON SCANNER
                                try (Scanner sc = new Scanner(archivo)) {
                                    while (sc.hasNextLine()) {
                                        String lineaMes = sc.nextLine();

                                        // lineaMes es "Enero 6"
                                        String[] partes = lineaMes.split(" ");

                                        if (partes.length == 2) {
                                            sumaTotal += Integer.parseInt(partes[1]);
                                        }
                                    }
                                } catch (FileNotFoundException e) {
                                    System.out.println("No se pudo abrir el archivo: " + archivo.getName());
                                }

                                // 5. GUARDAR DATOS EN MEMORIA
                                lineasResumen.add(anio + ";" + nombreLimpio + ";" + sumaTotal);
                            }
                        }
                    }
                }
            }
        }

        // 6. ESCRITURA FÍSICA DEL RESUMEN
        // Usamos PrintWriter porque nos permite usar println directamente
        try (PrintWriter pw = new PrintWriter(new FileWriter("resumen_total.csv"))) {

            for (String linea : lineasResumen) {
                pw.println(linea);
            }
            System.out.println("Consolidación completada. Fichero resumen_total.csv generado mediante IO.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo maestro: " + e.getMessage());
        }
    }
}
