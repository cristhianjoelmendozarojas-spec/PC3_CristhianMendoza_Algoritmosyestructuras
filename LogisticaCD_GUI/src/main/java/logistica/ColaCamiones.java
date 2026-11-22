package logistica;

// Cola FIFO con nodos enlazados manuales.
public class ColaCamiones {
    private NodoCola frente;
    private NodoCola fin;
    
// Agrega un camion al final de la cola.
    public void encolar(Camion c) {
        NodoCola nuevo = new NodoCola(c);
        if (fin == null) {
            frente = fin = nuevo;
            return;
        }
        fin.siguiente = nuevo;
        fin = nuevo;
    }

    // Extrae el camion del frente de la cola.
    public Camion desencolar() {
        if (frente == null) return null;
        Camion c = frente.camion;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return c;
    }
// Indica si la cola esta vacia.
    public boolean estaVacia() { return frente == null; }

   // Retorna los camiones en orden de llegada como texto. 
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