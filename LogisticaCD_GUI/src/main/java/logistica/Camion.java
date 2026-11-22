package logistica;

public class Camion {
    private String placa;
    private String conductor;
    private double capacidadTon;

    public Camion(String placa, String conductor, double capacidadTon) {
        this.placa = placa;
        this.conductor = conductor;
        this.capacidadTon = capacidadTon;
    }

    public String getPlaca() { return placa; }
    public String getConductor() { return conductor; }
    public double getCapacidadTon() { return capacidadTon; }

    @Override
    public String toString() {
        return "Camion(" + placa + " | " + conductor + " | " + capacidadTon + " tn)";
    }
}