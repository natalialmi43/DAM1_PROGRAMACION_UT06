package repaso.javaIO.e01;

public class E04Objeto {

    private String ID;
    private String nombre;
    private double precio;

    public E04Objeto(String ID, String nombre, double precio) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
    }

    public E04Objeto() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
