package logistica;

public class ColaCamiones {
    private NodoCola frente;
    private NodoCola fin;

    public void encolar(Camion c) {
        NodoCola nuevo = new NodoCola(c);
        if (fin == null) {
            frente = fin = nuevo;
            return;
        }
        fin.siguiente = nuevo;
        fin = nuevo;
    }

    public Camion desencolar() {
        if (frente == null) return null;
        Camion c = frente.camion;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return c;
    }

    public boolean estaVacia() { return frente == null; }

    public String mostrar() {
        if (frente == null) return "Cola vacia.";
        StringBuilder sb = new StringBuilder("--- Cola de camiones ---\n");
        NodoCola aux = frente;
        int i = 1;
        while (aux != null) {
            sb.append(i++).append(". ").append(aux.camion).append("\n");
            aux = aux.siguiente;
        }
        return sb.toString();
    }
}