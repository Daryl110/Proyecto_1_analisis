/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador;

/**
 *
 * @author nick_
 */
public class MetodosOrdenacionCadena {

    public static void ordenarBurbuja(String[] arreglo) {
        int iteracion = 1;// establece el lugar hasta donde se iterará
        boolean permutacion;
        do {
            permutacion = false;// valida que el ciclo no sea infinito
            for (int i = 0; i < arreglo.length - iteracion; i++) {
                if (arreglo[i].compareTo(arreglo[i + 1]) > 0) {
                    permutacion = true;
                    String aux = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = aux;
                }
            }
            iteracion++;// elimina la iteracion de una posicion,
            // ya que el mayor ya estaria de ultimo
        } while (permutacion);
    }

    public static void OrdenamientoInsercion(String array[]) {
        int x, y;
        String aux;
        for (x = 1; x < array.length; x++) { // desde el segundo elemento hasta el final
            aux = array[x]; // guardamos el elemento 
            y = x - 1; // empezamos a comprobar con el anterior
            while ((y >= 0) && (aux.compareTo(array[y])) < 0) { // mientras queden posiciones y el valor de aux sea menor que los de la izquierda
                array[y + 1] = array[y];
                y--;                   // se desplaza a la derecha
            }
            array[y + 1] = aux; // colocamos aux en su sitio
        }
    }

    public static void OrdenamientoSeleccion(String array[]) {
        int i, j, poss;
        String aux, menor;
        for (i = 0; i < array.length - 1; i++) { // tomamos como menor el primero
            menor = array[i]; //  los elementos que quedan por ordenar
            poss = i; // guardamos su posición
            for (j = i + 1; j < array.length; j++) { // buscamos en el array algun elemento menor al actual
                if (array[j].compareTo(menor) < 0) {
                    menor = array[j];
                    poss = j;
                }
            }
            if (poss != i) { // si hay alguno menor se intercambia
                aux = array[i];
                array[i] = array[poss];
                array[poss] = aux;
            }
        }
    }

    public static void OrdenamientoPeine(String array[]) {
        int gap = array.length;
        boolean permutación = true;
        int actual;

        while ((permutación) || (gap > 1)) {
            permutación = false;
            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }
            for (actual = 0; actual < array.length - 1 - gap; actual++) {
                if (array[actual].compareTo(array[actual + gap]) > 0) {
                    permutación = true;
                    // Intercambiamos los dos elementos
                    String temp = array[actual];
                    array[actual] = array[actual + gap];
                    array[actual + gap] = temp;
                }
            }
        }
    }
}
