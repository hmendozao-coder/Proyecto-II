/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.editortextoavanzado;

/**
 *
 * @author Grupo I
 */
public class NodoABB {

    String palabra;
    int posicion;
    NodoABB izquierda, derecha;

    /**
     * Inicializa el nodo con su valor y posición.
     */
    public NodoABB(String palabra, int posicion) {
        this.palabra = palabra;
        this.posicion = posicion;
        izquierda = derecha = null;
    }
}
