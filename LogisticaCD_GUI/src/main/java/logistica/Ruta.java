package logistica;

public class Ruta {
    private String destino;
    private int distanciaKm;

    public Ruta(String destino, int distanciaKm) {
        this.destino = destino;
        this.distanciaKm = distanciaKm;
    }

    public String getDestino() { return destino; }
    public int getDistanciaKm() { return distanciaKm; }

    @Override
    public String toString() {
        return destino + " (" + distanciaKm + " km)";
    }
}