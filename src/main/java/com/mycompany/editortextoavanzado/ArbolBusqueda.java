/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.editortextoavanzado;

/**
 *
 * @author Grupo I
 */
public class ArbolBusqueda {

    NodoABB raiz;

    public ArbolBusqueda() {
        raiz = null;
    }

    /**
     * Inserta una palabra en el árbol.
     * 
     * Se basa en orden lexicográfico.
     */
    public NodoABB insertar(NodoABB nodo, String palabra, int posicion) {
        if (nodo == null) {
            return new NodoABB(palabra, posicion);
        }

        if (palabra.compareTo(nodo.palabra) < 0) {
            nodo.izquierda = insertar(nodo.izquierda, palabra, posicion);
        } else {
            nodo.derecha = insertar(nodo.derecha, palabra, posicion);
        }

        return nodo;
    }

    /**
     * Busca una palabra en el árbol.
     */
    public NodoABB buscar(NodoABB nodo, String palabra) {
        if (nodo == null || nodo.palabra.equals(palabra)) {
            return nodo;
        }

        if (palabra.compareTo(nodo.palabra) < 0) {
            return buscar(nodo.izquierda, palabra);
        }

        return buscar(nodo.derecha, palabra);
    }
}