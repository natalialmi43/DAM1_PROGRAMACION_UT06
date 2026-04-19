# Gestión de Ficheros en Java

## Ejercicio 1: El Explorador de Archivos (clase File o Files)
Objetivo: Comprender la navegación por el sistema de ficheros, la creación de directorios y la comprobación de existencia.

Tarea: Crea un programa que al iniciarse genere una carpeta llamada MiDirectorioDAM en la raíz del proyecto.

Acción: 1. Comprueba si la carpeta ya existe. Si no existe, créala. 2. Dentro de esa carpeta, crea dos archivos vacíos: datos.txt y config.ini. 3. Lista por consola el contenido de MiDirectorioDAM, mostrando el nombre de cada archivo y su tamaño en bytes.


## Ejercicio 2: El Diario de Clase (Escritura de Texto Plano)
Objetivo: Practicar la escritura de texto añadiendo contenido al final del archivo (append).

Tarea: Crea un programa que funcione como un diario. Debe pedir al usuario por consola que introduzca frases.

Acción: 1. Cada frase introducida se debe guardar en un archivo llamado diario.txt. 2. El programa debe seguir pidiendo frases hasta que el usuario escriba la palabra "FIN". 3. Asegúrate de que si ejecutas el programa dos veces, las frases nuevas se añadan debajo de las antiguas sin borrar las anteriores (modo append).

## Ejercicio 3: El Lector de Poemas (Lectura y Procesamiento)
Objetivo: Leer archivos línea a línea y realizar operaciones con cadenas de texto.

Contexto: Tienes un archivo poema.txt con varias líneas de texto (puedes crearlo a mano previamente).

Tarea: Lee el archivo completo utilizando un BufferedReader o la clase Scanner.

Acción:

Muestra el contenido exacto por consola.

Cuenta y muestra al final cuántas líneas en total tiene el archivo.

Cuenta y muestra cuántas veces aparece la vocal "a" (mayúscula o minúscula) en todo el texto.

## Ejercicio 4: Importando el Catálogo (Lectura de CSV)
Objetivo: Leer archivos de datos estructurados y convertirlos en objetos (integración con el tema de clases).

Contexto: Crea un archivo productos.csv con el siguiente formato: ID;Nombre;Precio (ej: 1;Teclado Mecánico;45.50).

Tarea: Crea una clase Producto con esos tres atributos.

Acción: 1. Lee el archivo productos.csv línea a línea. 2. Utiliza el método .split(";") para separar los datos. 3. Crea un objeto Producto por cada línea y guárdalo en un ArrayList<Producto>. 4. Muestra la lista de productos por pantalla aplicando un formato de tabla limpio.

## Ejercicio 5: Copia de Seguridad Seguro (Control de Excepciones)
Objetivo: Reforzar el uso del bloque try-catch y try-with-resources.

Tarea: Crea un programa que intente copiar el contenido de archivo_origen.txt a archivo_destino.txt.

Acción: 1. Si archivo_origen.txt no existe, el programa no debe "romperse", sino capturar la excepción FileNotFoundException (o NoSuchFileException) y mostrar un mensaje amigable al usuario: "Error: El archivo de origen no se ha encontrado". 2. Asegúrate de utilizar try-with-resources para que los flujos de lectura y escritura se cierren automáticamente, ocurra o no un error.