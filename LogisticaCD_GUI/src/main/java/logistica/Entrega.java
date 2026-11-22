package logistica;

public class Entrega {
    private int id;
    private String producto;
    private String camion;
    private String destino;
    private int cantidad;

    // Constructor: inicializa id, producto, camion, destino y cantidad.
    public Entrega(int id, String producto, String camion, String destino, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.camion = camion;
        this.destino = destino;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public String getProducto() { return producto; }
    public String getCamion() { return camion; }
    public String getDestino() { return destino; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return "Entrega#" + id + " | " + producto + " x" + cantidad +
               " | Camion: " + camion + " | Destino: " + destino;
    }
}