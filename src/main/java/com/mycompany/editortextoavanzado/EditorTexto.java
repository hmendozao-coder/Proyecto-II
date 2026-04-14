/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.editortextoavanzado;

import java.util.Stack;

/**
 *
 * @author Grupo I
 */
public class EditorTexto {

    private String texto;
    private final Stack<String> pilaUndo;
    private final Stack<String> pilaRedo;
    private ArbolBusqueda arbol;

    public EditorTexto() {
        texto = "";
        pilaUndo = new Stack<>();
        pilaRedo = new Stack<>();
        arbol = new ArbolBusqueda();
    }

    /**
     * Agrega texto al contenido actual.
     */
    public void escribir(String nuevoTexto) {
        pilaUndo.push(texto);   // guardar estado anterior
        texto += nuevoTexto;    // agregar texto nuevo
        pilaRedo.clear();       // limpiar redo
        actualizarArbol();      // actualizar árbol
    }

    /**
     * Revierte el último cambio.
     */
    public void deshacer() {
        if (!pilaUndo.isEmpty()) {
            pilaRedo.push(texto);
            texto = pilaUndo.pop();
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
        actualizarArbol();
    }

    /**
     * Restaura una acción previamente deshecha.
     */
    public void rehacer() {
        if (!pilaRedo.isEmpty()) {
            pilaUndo.push(texto);
            texto = pilaRedo.pop();
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
        actualizarArbol();
    }

    /**
     * Muestra el texto actual.
     */
    public void mostrar() {
        System.out.println("Texto actual: " + texto);
    }

    /**
     * Reconstruye el árbol a partir del texto.
     */
    private void actualizarArbol() {
        arbol = new ArbolBusqueda();
        String[] palabras = texto.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            if (!palabras[i].isEmpty()) {
                arbol.raiz = arbol.insertar(arbol.raiz, palabras[i], i);
            }
        }
    }

    /**
     * Busca una palabra en el árbol.
     */
    public void buscar(String palabra) {
        NodoABB resultado = arbol.buscar(arbol.raiz, palabra);

        if (resultado != null) {
            System.out.println("Encontrada en posición: " + resultado.posicion);
        } else {
            System.out.println("Palabra no encontrada.");
        }
    }

    /**
     * Reemplaza una palabra por otra dentro del texto.
     */
    public void reemplazar(String palabraBuscada, String nuevaPalabra) {

        if (texto.isEmpty()) {
            System.out.println("El texto está vacío.");
            return;
        }

        if (!texto.contains(palabraBuscada)) {
            System.out.println("La palabra no existe en el texto.");
            return;
        }

        pilaUndo.push(texto); // guardar estado anterior

        texto = texto.replace(palabraBuscada, nuevaPalabra);

        pilaRedo.clear(); // limpiar redo
        actualizarArbol();

        System.out.println("Reemplazo realizado correctamente.");
    }
}
