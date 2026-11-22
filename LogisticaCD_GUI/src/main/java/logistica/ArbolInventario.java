package logistica;

import java.util.List;

public class ArbolInventario {
    private NodoArbol raiz;

    public void insertar(Producto p) {
        raiz = insertarRec(raiz, p);
    }

    private NodoArbol insertarRec(NodoArbol nodo, Producto p) {
        if (nodo == null) return new NodoArbol(p);
        if (p.getCodigo() < nodo.producto.getCodigo())
            nodo.izquierdo = insertarRec(nodo.izquierdo, p);
        else if (p.getCodigo() > nodo.producto.getCodigo())
            nodo.derecho = insertarRec(nodo.derecho, p);
        return nodo;
    }

    public Producto buscar(int codigo) {
        NodoArbol actual = raiz;
        while (actual != null) {
            if (codigo == actual.producto.getCodigo()) return actual.producto;
            actual = (codigo < actual.producto.getCodigo()) ? actual.izquierdo : actual.derecho;
        }
        return null;
    }

    public void inOrden(List<Producto> lista) { inOrdenRec(raiz, lista); }

    private void inOrdenRec(NodoArbol nodo, List<Producto> lista) {
        if (nodo == null) return;
        inOrdenRec(nodo.izquierdo, lista);
        lista.add(nodo.producto);
        inOrdenRec(nodo.derecho, lista);
    }

    public int altura() { return alturaRec(raiz); }

    private int alturaRec(NodoArbol nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRec(nodo.izquierdo), alturaRec(nodo.derecho));
    }

    public boolean descontarStock(int codigo, int cantidad) {
        Producto p = buscar(codigo);
        if (p == null) return false;
        if (p.getStock() < cantidad) return false;
        p.setStock(p.getStock() - cantidad);
        return true;
    }
}