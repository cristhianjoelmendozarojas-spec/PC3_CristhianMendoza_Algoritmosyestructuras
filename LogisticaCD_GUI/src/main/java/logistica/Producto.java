package logistica;

public class Producto {
    private int codigo;
    private String nombre;
    private int stock;

    public Producto(int codigo, String nombre, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "[ " + codigo + " ] " + nombre + " | stock=" + stock;
    }
}