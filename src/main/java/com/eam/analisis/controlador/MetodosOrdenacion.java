/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

/**
 * @author Daryl Ospina
 */
public class MetodosOrdenacion {


    public static void ordenarBurbuja(int[] arreglo) {
        int iteracion = 1;// establece el lugar hasta donde se iterará
        boolean permutacion;
        do {
            permutacion = false;// valida que el ciclo no sea infinito
            for (int i = 0; i < arreglo.length - iteracion; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    permutacion = true;
                    int aux = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = aux;
                }
            }
            iteracion++;// elimina la iteracion de una posicion,
            // ya que el mayor ya estaria de ultimo
        } while (permutacion);
    }

    public static void ordenarBurbujaBi(int[] arreglo) {
        boolean permutacion;
        int actual = 0, direccion = 1;
        int comienzo = 1, fin = arreglo.length - 1;
        do {
            permutacion = false;
            while (((direccion == 1) && (actual < fin)) || ((direccion == -1) && (actual > comienzo))) {
                actual += direccion;
                if (arreglo[actual] < arreglo[actual - 1]) {
                    int temp = arreglo[actual];
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

    private static  void burbuja(int[] arreglo, int p) {
        int j = p;
        while ((j > 0) && (arreglo[j] < arreglo[j - 1])) {
            int t = arreglo[j - 1];
            arreglo[j - 1] = arreglo[j];
            arreglo[j] = t;
            j--;
        }
    }

    public static void Gnome_sort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            burbuja(arreglo, i);
        }
    }
    
    /*
        izq =0
        der = arreglo.length-1
    
    */
    public static void mergesort(int A[], int izq, int der) {
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
    private static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
    
    public static void ordenarMonticulo(int[] arreglo){
        
    }

    public static void ordenarShell(int[] arreglo) {
        int salto = arreglo.length / 2;//Salto a ralizar para tomar valor a comparar
        while (salto > 0) {//Mientras el salto sea diferente de 0 se seguira ordenando
            for (int i = salto; i < arreglo.length; i++) {//Recorrer el arrglo desde la pocision del salto
                //Hasta la terminacion del arreglo
                int j = i - salto;//segundo valor i-salto adquiriendo la division del tamaño por 2 e ir restando el valor de i
                while (j >= 0) {//Mientras el salto no sea 0, esto significa que tomara los valores desde atras a adelante,
                    //Llegando hasta el valor 0
                    int k = j + salto;//este valor tomara valores desde 0 hasta el fin del arreglo
                    if (arreglo[j] <= arreglo[k]) {
                        // si las posiciones son menores o iguales, se rompera el ciclo
                        break;
                    } else {//De lo contrario se cambiaran las posiciones
                        int aux = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = aux;
                        j -= salto;
                    }
                }
            }
            salto /= 2;//Salto tomara la mitad del salto anterior
        }
    }

    public static void ordenarRapido(int[] arreglo) {
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private static void quickSort(int[] arreglo, int posIzquierda, int posDerecha) {
        if (posIzquierda >= posDerecha) {
            return;//Caso base con el fin de acabar recurcividad
        }        //Si la posicion izquierda es igual a la posicion derecha, significa que solo hay un numero en la posicion (simulada)
        //Nota: simulada por que no se recorta en si el arreglo, si no que se reduce el rango de obtencion de datos sobre este
        int i = posIzquierda, d = posDerecha;//Guardar variables iniciales, ya que cambiaran
        int pivote = posIzquierda;//Pivote siempre sera el numero en la pocision izquierda
        int aux;
        while (posIzquierda != posDerecha) {
            while (arreglo[posDerecha] >= arreglo[pivote] && posIzquierda < posDerecha) {
                posDerecha--;// cambiara de posicion si todo esta bien
            }            // por el lado derecho
            while (arreglo[posIzquierda] < arreglo[pivote] && posIzquierda < posDerecha) {
                posIzquierda++;// cambiara de posicion si todo esta bien
            }            // por el lado izquierdo
            if (posDerecha != posIzquierda) {//Cambiara la posicion si hay alguna inconsistencia de mayor o menor
                aux = arreglo[posDerecha];
                arreglo[posDerecha] = arreglo[posIzquierda];
                arreglo[posIzquierda] = aux;
            }
            if (posIzquierda == posDerecha) {//Partira el arreglo en dos partes con el fin de hacer lo mismo con los subconjuntos
                //Hasta que quede un solo numero (Simulacion)
                quickSort(arreglo, i, pivote - 1);//desde inicial hasta pivote-1
                quickSort(arreglo, pivote + 1, d);//desde pivote+1 hasta final
            }
        }
    }
}
