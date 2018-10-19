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
    
    public static void ordenarRapidamente(int[] arreglo){
        quickSort(arreglo, 0, arreglo.length-1);
    }
    
    private static void quickSort(int[] arreglo, int posIzquierda, int posDerecha){
        if(posIzquierda >= posDerecha)return;//Caso base con el fin de acabar recurcividad
        //Si la posicion izquierda es igual a la posicion derecha, significa que solo hay un numero en la posicion (simulada)
        //Nota: simulada por que no se recorta en si el arreglo, si no que se reduce el rango de obtencion de datos sobre este
        int i = posIzquierda, d = posDerecha;//Guardar variables iniciales, ya que cambiaran
        int pivote = posIzquierda;//Pivote siempre sera el numero en la pocision izquierda
        int aux;
        while (posIzquierda != posDerecha) {
            while(arreglo[posDerecha] >= arreglo[pivote] && posIzquierda<posDerecha)posDerecha--;// cambiara de posicion si todo esta bien
            // por el lado derecho
            while(arreglo[posIzquierda] < arreglo[pivote] && posIzquierda<posDerecha)posIzquierda++;// cambiara de posicion si todo esta bien
            // por el lado izquierdo
            if (posDerecha != posIzquierda) {//Cambiara la posicion si hay alguna inconsistencia de mayor o menor
                aux = arreglo[posDerecha];
                arreglo[posDerecha] = arreglo[posIzquierda];
                arreglo[posIzquierda] = aux;
            }
            if (posIzquierda == posDerecha) {//Partira el arreglo en dos partes con el fin de hacer lo mismo con los subconjuntos
                //Hasta que quede un solo numero (Simulacion)
                quickSort(arreglo, i, pivote-1);//desde inicial hasta pivote-1
                quickSort(arreglo, pivote+1, d);//desde pivote+1 hasta final
            }
        }
    }
}
