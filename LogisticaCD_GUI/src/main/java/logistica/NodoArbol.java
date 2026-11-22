package logistica;

// Nodo manual del ABB. Contiene un Producto y sus hijos.
public class NodoArbol {
    Producto producto;
    NodoArbol izquierdo, derecho;

    // Constructor: crea un nodo hoja con el producto dado.
    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izquierdo = this.derecho = null;
    }
}