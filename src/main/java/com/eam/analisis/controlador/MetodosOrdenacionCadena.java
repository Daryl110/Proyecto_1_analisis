/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador;

import java.util.Date;

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

    public static void ordenarBurbujaBi(String[] arreglo) {
        boolean permutacion;
        int actual = 0, direccion = 1;
        int comienzo = 1, fin = arreglo.length - 1;
        do {
            permutacion = false;
            while (((direccion == 1) && (actual < fin)) || ((direccion == -1) && (actual > comienzo))) {
                actual += direccion;
                if (arreglo[actual].compareTo(arreglo[actual - 1]) < 0) {
                    String temp = arreglo[actual];
                    arreglo[actual] = arreglo[actual - 1];
                    arreglo[actual - 1] = temp;
                    permutacion = true;
                }

            }
            if (direccion == 1) {
                fin--;
            } else {
                comienzo++;
            }
            direccion = -direccion;
        } while (permutacion);

    }

    public static void Gnome_sort(String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            burbuja(arreglo, i);
        }
    }

    private static void burbuja(String[] arreglo, int p) {
        int j = p;
        while ((j > 0) && (arreglo[j].compareTo(arreglo[j - 1]) < 0)) {
            String t = arreglo[j - 1];
            arreglo[j - 1] = arreglo[j];
            arreglo[j] = t;
            j--;
        }
    }

    /*
        izq =0
        der = arreglo.length-1
    
     */
    public static void mergesort(String A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    /*
    http://puntocomnoesunlenguaje.blogspot.com/2014/10/java-mergesort.html
     */
    private static void merge(String A[], int izq, int m, int der) {
        int i, j, k;
        String[] B = new String[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }
        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i].compareTo(B[j]) <= 0) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }

    }
}
