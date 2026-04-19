package casa.e01GestionFicherosEnJava;

public class E04Producto {

    private int id;
    private String nombre;
    private double precio;

    // Constructor para meter los datos al crear el objeto
    public E04Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Usamos toString para que al imprimir el objeto se vea bonito
    @Override
    public String toString() {
        return String.format("%-5d | %-20s | %8.2f€", id, nombre, precio);
    }
}