package logistica;

import java.util.*;

public class GrafoRutas {
    private Map<String, LinkedList<Ruta>> adyacencia = new HashMap<>();

       // Registra una ciudad sin duplicar.
    public void agregarCiudad(String ciudad) {
        adyacencia.putIfAbsent(ciudad, new LinkedList<>());
    }
 // Agrega una ruta dirigida desde origen.
    public void agregarRuta(String origen, String destino, int km) {
        adyacencia.get(origen).add(new Ruta(destino, km));
    }

     // Retorna la red de rutas completa como texto.
    public String mostrarRutas() {
        if (adyacencia.isEmpty()) return "No hay rutas.";
        StringBuilder sb = new StringBuilder("--- Red de rutas ---\n");
        for (String origen : adyacencia.keySet()) {
            sb.append(origen).append(" -> ");
            for (Ruta r : adyacencia.get(origen)) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

      // Recorrido BFS desde una ciudad. Retorna ciudades visitadas.
    public List<String> bfs(String inicio) {
        List<String> visitados = new ArrayList<>();
        if (!adyacencia.containsKey(inicio)) return visitados;
        Queue<String> cola = new LinkedList<>();
        Set<String> vistos = new HashSet<>();
        cola.add(inicio);
        vistos.add(inicio);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            visitados.add(actual);
            for (Ruta r : adyacencia.get(actual)) {
                if (!vistos.contains(r.getDestino())) {
                    vistos.add(r.getDestino());
                    cola.add(r.getDestino());
                }
            }
        }
        return visitados;
    }
   // Calcula la distancia total de un camino de ciudades.
    public int distanciaRuta(List<String> camino) {
        int total = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String origen = camino.get(i);
            String destino = camino.get(i + 1);
            for (Ruta r : adyacencia.getOrDefault(origen, new LinkedList<>())) {
                if (r.getDestino().equals(destino)) {
                    total += r.getDistanciaKm();
                    break;
                }
            }
        }
        return total;
    }
 // Verifica si una ciudad existe en el grafo.
    public boolean existeCiudad(String ciudad) {
        return adyacencia.containsKey(ciudad);
    }
}