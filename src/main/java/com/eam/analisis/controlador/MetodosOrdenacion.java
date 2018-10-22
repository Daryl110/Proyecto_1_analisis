/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import com.eam.analisis.modelo.Cancion;

/**
 * @author Daryl Ospina
 */
public class MetodosOrdenacion {

    public static void ordenarBurbuja(Cancion[] arreglo) {
        int iteracion = 1;// establece el lugar hasta donde se iterará
        boolean permutacion;
        do {
            permutacion = false;// valida que el ciclo no sea infinito
            for (int i = 0; i < arreglo.length - iteracion; i++) {
                if (Integer.parseInt(arreglo[i].getDuracion() + "") > Integer.parseInt(arreglo[i + 1].getDuracion() + "")) {
                    permutacion = true;
                    Cancion aux = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = aux;
                }
            }
            iteracion++;// elimina la iteracion de una posicion,
            // ya que el mayor ya estaria de ultimo
        } while (permutacion);
    }

    public static void ordenarBurbujaBidireccional(Cancion[] arreglo) {
        boolean permutacion;
        int actual = 0, direccion = 1;
        int comienzo = 1, fin = arreglo.length - 1;
        do {
            permutacion = false;
            while (((direccion == 1) && (actual < fin)) || ((direccion == -1) && (actual > comienzo))) {
                actual += direccion;
                if (Integer.parseInt(arreglo[actual]+"") < Integer.parseInt(arreglo[actual - 1]+"")) {
                    Cancion temp = arreglo[actual];
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

    public static void ordenarGnome(Cancion[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            burbuja(arreglo, i);
        }
    }

    private static void burbuja(Cancion[] arreglo, int p) {
        int j = p;
        while ((j > 0) && (Integer.parseInt(arreglo[j]+"") < Integer.parseInt(arreglo[j - 1]+""))) {
            Cancion t = arreglo[j - 1];
            arreglo[j - 1] = arreglo[j];
            arreglo[j] = t;
            j--;
        }
    }

    public static void ordenarMezcla(Cancion[] arreglo) {
        mergesort(arreglo, 0, arreglo.length - 1);
    }

    private static void mergesort(Cancion A[], int izq, int der) {
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
    private static void merge(Cancion A[], int izq, int m, int der) {
        int i, j, k;
        Cancion[] B = new Cancion[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (Integer.parseInt(B[i].getDuracion()+"") <= Integer.parseInt(B[j].getDuracion()+"")) {
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

    public static void ordenarShell(Cancion[] arreglo) {
        int salto = arreglo.length / 2;//Salto a ralizar para tomar valor a comparar
        while (salto > 0) {//Mientras el salto sea diferente de 0 se seguira ordenando
            for (int i = salto; i < arreglo.length; i++) {//Recorrer el arrglo desde la pocision del salto
                //Hasta la terminacion del arreglo
                int j = i - salto;//segundo valor i-salto adquiriendo la division del tamaño por 2 e ir restando el valor de i
                while (j >= 0) {//Mientras el salto no sea 0, esto significa que tomara los valores desde atras a adelante,
                    //Llegando hasta el valor 0
                    int k = j + salto;//este valor tomara valores desde 0 hasta el fin del arreglo
                    if (Integer.parseInt(arreglo[j].getDuracion()+"") <= Integer.parseInt(arreglo[k].getDuracion()+"")) {
                        // si las posiciones son menores o iguales, se rompera el ciclo
                        break;
                    } else {//De lo contrario se cambiaran las posiciones
                        Cancion aux = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = aux;
                        j -= salto;
                    }
                }
            }
            salto /= 2;//Salto tomara la mitad del salto anterior
        }
    }

    public static void ordenarRapido(Cancion[] arreglo) {
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private static void quickSort(Cancion[] arreglo, int posIzquierda, int posDerecha) {
        if (posIzquierda >= posDerecha) {
            return;//Caso base con el fin de acabar recurcividad
        }        //Si la posicion izquierda es igual a la posicion derecha, significa que solo hay un numero en la posicion (simulada)
        //Nota: simulada por que no se recorta en si el arreglo, si no que se reduce el rango de obtencion de datos sobre este
        int i = posIzquierda, d = posDerecha;//Guardar variables iniciales, ya que cambiaran
        int pivote = posIzquierda;//Pivote siempre sera el numero en la pocision izquierda
        Cancion aux;
        while (posIzquierda != posDerecha) {
            while (Integer.parseInt(arreglo[posDerecha].getDuracion()+"") >= Integer.parseInt(arreglo[pivote].getDuracion()+"") && posIzquierda < posDerecha) {
                posDerecha--;// cambiara de posicion si todo esta bien
            }            // por el lado derecho
            while (Integer.parseInt(arreglo[posIzquierda].getDuracion()+"") < Integer.parseInt(arreglo[pivote].getDuracion()+"") && posIzquierda < posDerecha) {
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

    public static void OrdenamientoInsercion(Cancion array[]) {
        int x, y;
        Cancion aux = null;
        for (x = 1; x < array.length; x++) { // desde el segundo elemento hasta el final
            aux = array[x]; // guardamos el elemento 
            y = x - 1; // empezamos a comprobar con el anterior
            while ((y >= 0) && (Integer.parseInt(aux.getDuracion()+"") < Integer.parseInt(array[y].getDuracion()+""))) { // mientras queden posiciones y el valor de aux sea menor que los de la izquierda
                array[y + 1] = array[y];
                y--;                   // se desplaza a la derecha
            }
            array[y + 1] = aux; // colocamos aux en su sitio
        }
    }

    public static void OrdenamientoSeleccion(Cancion array[]) {
        int i, j, poss;
        Cancion menor,aux;
        for (i = 0; i < array.length - 1; i++) { // tomamos como menor el primero
            menor = array[i]; //  los elementos que quedan por ordenar
            poss = i; // guardamos su posición
            for (j = i + 1; j < array.length; j++) { // buscamos en el array algun elemento menor al actual
                if (Integer.parseInt(array[j].getDuracion()+"") < Integer.parseInt(menor.getDuracion()+"")) {
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

    public static void OrdenamientoPeine(Cancion array[]) {
        int gap = array.length;
        boolean permutación = true;
        int actual;

        while ((permutación) || (gap > 1)) {
            permutación = false;
            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }
            for (actual = 0; actual < array.length - gap; actual++) {
                if (Integer.parseInt(array[actual].getDuracion()+"") > Integer.parseInt(array[actual + gap].getDuracion()+"")) {
                    permutación = true;
                    // Intercambiamos los dos elementos
                    Cancion temp = array[actual];
                    array[actual] = array[actual + gap];
                    array[actual + gap] = temp;
                }
            }
        }
    }
}
