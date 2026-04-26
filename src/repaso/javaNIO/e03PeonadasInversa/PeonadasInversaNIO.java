package repaso.javaNIO.e03PeonadasInversa;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PeonadasInversaNIO {
    public static void main(String[] args) {

        // Directorio donde están las carpetas de los años (asumimos la carpeta actual del proyecto)
        Path directorioRaiz = Paths.get(".");
        Path archivoResumen = Paths.get("resumen_total.csv");

        List<String> lineasResumen = new ArrayList<>();
        lineasResumen.add("Año;Trabajador;Total_Peonadas"); // Cabecera del archivo final

        // 1. ABRIR EL DIRECTORIO RAÍZ
        // Usamos DirectoryStream en un try para que libere la carpeta al terminar
        try (DirectoryStream<Path> carpetas = Files.newDirectoryStream(directorioRaiz)) {

            for (Path carpeta : carpetas) {
                // Filtramos: solo nos interesan directorios cuyo nombre sean 4 números (ej. "2024", "2025")
                String nombreCarpeta = carpeta.getFileName().toString();

                if (Files.isDirectory(carpeta) && nombreCarpeta.matches("\\d{4}")) {
                    String anio = nombreCarpeta;

                    // 2. ABRIR EL DIRECTORIO DEL AÑO (ej: entramos en "2025")
                    // Le pasamos un filtro "*_peonadas.txt" para que solo lea esos archivos concretos
                    try (DirectoryStream<Path> archivos = Files.newDirectoryStream(carpeta, "*_peonadas.txt")) {

                        for (Path archivo : archivos) {

                            // 3. RECONSTRUIR EL NOMBRE DEL TRABAJADOR
                            // El archivo es "Ana_Garcia_2025_peonadas.txt". Quitamos la cola y los guiones bajos.
                            String nombreArchivo = archivo.getFileName().toString();
                            String sufijo = "_" + anio + "_peonadas.txt";
                            String nombreLimpio = nombreArchivo.replace(sufijo, "").replace("_", " ");

                            // 4. LEER EL CONTENIDO DEL ARCHIVO (Los 12 meses)
                            List<String> lineasMeses = Files.readAllLines(archivo);
                            int sumaTotal = 0;

                            for (String lineaMes : lineasMeses) {
                                // La línea es "Enero 6". Cortamos por el espacio.
                                String[] partes = lineaMes.split(" ");

                                // El número está en la posición 1. Lo pasamos a entero y lo sumamos.
                                sumaTotal += Integer.parseInt(partes[1]);
                            }

                            // 5. GUARDAR EL RESULTADO EN LA MEMORIA RAM
                            lineasResumen.add(anio + ";" + nombreLimpio + ";" + sumaTotal);
                        }
                    }
                }
            }

            // 6. VOLCADO FÍSICO AL DISCO DURO
            // Una vez que hemos recorrido todas las carpetas y archivos, escribimos el resumen de golpe.
            Files.write(archivoResumen, lineasResumen);
            System.out.println("Consolidación finalizada. Archivo 'resumen_total.csv' generado.");

        } catch (IOException e) {
            System.err.println("Error grave de lectura/escritura en el sistema de archivos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato: Un archivo contiene datos que no son numéricos.");
        }
    }
}
