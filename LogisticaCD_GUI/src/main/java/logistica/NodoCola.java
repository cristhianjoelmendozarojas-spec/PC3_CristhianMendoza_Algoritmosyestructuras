package logistica;

public class NodoCola {
    Camion camion;
    NodoCola siguiente;

    public NodoCola(Camion camion) {
        this.camion = camion;
        this.siguiente = null;
    }
}