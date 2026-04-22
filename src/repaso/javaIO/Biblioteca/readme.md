# Análisis de Lecturas de una Biblioteca

Una biblioteca municipal guarda un registro de los libros que sacan sus usuarios. Cada vez que alguien devuelve un libro, el sistema anota la fecha, el nombre del usuario, el género literario del libro y el número de páginas leídas.

El archivo se llama registro_lecturas.txt y tiene el siguiente formato:
YYYY-MM-DD;Usuario;Genero;Paginas

Tu objetivo es procesar el fichero y:

Crear una carpeta para cada Usuario (no por año, como en el ejercicio original).

Dentro de la carpeta de cada usuario, crear un fichero para cada Año en el que haya leído algo. El fichero debe llamarse Año_resumen.txt (por ejemplo: 2023_resumen.txt).

Dentro de ese fichero, debes calcular la suma total de páginas que ha leído de cada género durante ese año, no solo contar cuántos libros ha leído.

El sistema contempla exactamente 5 géneros: Ficcion, Ensayo, Historia, Ciencia, Poesia. Todos deben aparecer en el archivo de salida, mostrando un 0 si el usuario no ha leído páginas de ese género ese año.

Así, la estructura de carpetas quedaría, por ejemplo:

Plaintext
/Marta/
2023_resumen.txt
2024_resumen.txt
/Juan/
2024_resumen.txt

Y el interior del fichero 2024_resumen.txt de Marta se vería así:

Plaintext
Ficcion: 450 paginas
Ensayo: 0 paginas
Historia: 0 paginas
Ciencia: 180 paginas
Poesia: 0 paginas