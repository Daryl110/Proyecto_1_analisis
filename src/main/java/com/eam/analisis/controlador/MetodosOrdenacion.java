/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

/**
 * @author Daryl Ospina
 */
public class MetodosOrdenacion {
   
    public static void ordenarBurbuja(int[] arreglo){
       int iteracion = 1;// establece el lugar hasta donde se iterará
       boolean permutacion;
       do{
           permutacion = false;// valida que el ciclo no sea infinito
           for (int i = 0; i < arreglo.length-iteracion; i++) {
               if (arreglo[i] > arreglo[i+1]) {
                   permutacion = true;
                   int aux = arreglo[i];
                   arreglo[i] = arreglo[i+1];
                   arreglo[i+1] = aux;
               }
           }
           iteracion++;// elimina la iteracion de una posicion,
           // ya que el mayor ya estaria de ultimo
       }while(permutacion);
    }
}
