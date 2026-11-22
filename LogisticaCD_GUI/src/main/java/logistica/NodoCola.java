package logistica;

public class NodoCola {
    Camion camion;
    NodoCola siguiente;
  // Constructor: crea un nodo con el camion dado.
    public NodoCola(Camion camion) {
        this.camion = camion;
        this.siguiente = null;
    }
}