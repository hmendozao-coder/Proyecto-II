/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.editortextoavanzado;

import java.util.Scanner;

/**
 *
 * @author Grupo I
 */
public class EditorTextoAvanzado {

    public static void main(String[] args) {
        /**
         * Scanner para lectura de datos desde consola.
         * 
         * Nota técnica:
         * Se debe controlar el buffer al mezclar nextInt() y nextLine().
         */
        Scanner sc = new Scanner(System.in);

        /**
         * Instancia única del editor.
         * 
         * Importante:
         * Mantiene el estado del texto durante toda la ejecución.
         */
        EditorTexto editor = new EditorTexto();

        int opcion;

        /**
         * Ciclo principal del programa.
         * 
         * Justificación:
         * Permite interacción continua hasta que el usuario decida salir.
         */
        do {
            System.out.println("\n===== EDITOR DE TEXTO =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Mostrar texto");
            System.out.println("3. Deshacer (Undo)");
            System.out.println("4. Rehacer (Redo)");
            System.out.println("5. Buscar palabra");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            /**
             * Captura de opción del usuario.
             * 
             * Punto crítico:
             * Se limpia el buffer para evitar errores en lectura posterior.
             */
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    /**
                     * Entrada de texto.
                     * 
                     * Se agrega espacio al final para facilitar separación
                     * de palabras al momento de construir el árbol.
                     */
                    System.out.print("Ingrese texto: ");
                    String entrada = sc.nextLine();
                    editor.escribir(entrada + " ");
                    break;

                case 2:
                    /**
                     * Muestra el contenido actual del editor.
                     */
                    editor.mostrar();
                    break;

                case 3:
                    /**
                     * Ejecuta operación Undo.
                     */
                    editor.deshacer();
                    break;

                case 4:
                    /**
                     * Ejecuta operación Redo.
                     */
                    editor.rehacer();
                    break;

                case 5:
                    /**
                     * Búsqueda de palabra dentro del texto.
                     */
                    System.out.print("Ingrese palabra a buscar: ");
                    String palabra = sc.nextLine();
                    editor.buscar(palabra);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    /**
                     * Manejo de entradas inválidas.
                     */
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        /**
         * Liberación de recurso Scanner.
         */
        sc.close();
    }
}
