/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador.metodosOrdenacion;

import com.eam.analisis.modelo.Cancion;

/**
 * @author Daryl Ospina
 */
public class MetodosOrdenacion {

    public static void ordenarMonticulo(int[] array) {
        /* Este método realiza un heapsort en el lugar. Comenzando
        desde el principio del arreglo, el arreglo se intercambia
        en un montón máximo binario. Luego se eliminan los elementos.
        desde el montón, y añadido a la parte delantera de la ordenada
        sección del arreglo. 
        
        Inserción en el montón */
        for (int heapsize = 0; heapsize < array.length; heapsize++) {
            /* Paso uno en agregar un elemento al montón en el
                Coloque ese elemento al final del arreglo de pila
                En este caso, el elemento ya está allí. */
            int n = heapsize; // el índice del int insertado
            while (n > 0) { // until we reach the root of the heap
                int p = (n - 1) / 2; // Hasta que lleguemos a la raíz del montón.
                if (array[n] > array[p]) { // el índice del int insertado
                    cambiarPosicion(array, n, p); // el niño es más grande que el padre
                    n = p; // comprobar padre
                } else // el padre es más grande que el niño
                {
                    break; // todo es bueno en el montón
                }
            }
        }

        /* Eliminación de montón */
        for (int heapsize = array.length; heapsize > 0;) {
            cambiarPosicion(array, 0, --heapsize); // intercambiar raíz con el último elemento de montón
            int n = 0; // índice del elemento que se mueve hacia abajo del árbol
            while (true) {
                int left = (n * 2) + 1;
                if (left >= heapsize) // nodo no tiene hijo izquierdo
                {
                    break; // llegó al fondo el montón es heapified
                }
                int right = left + 1;
                if (right >= heapsize) { // El nodo tiene un hijo izquierdo, pero ningún hijo derecho
                    if (array[left] > array[n]) // si el hijo izquierdo es mayor que el nodo
                    {
                        cambiarPosicion(array, left, n); // intercambiar hijo izquierdo con nodo
                    }
                    break; // el montón es heapified
                }
                if (array[left] > array[n]) { // (left > n)
                    if (array[left] > array[right]) { // (left > right) & (left > n)
                        cambiarPosicion(array, left, n);
                        n = left; // continuar la recursión en el niño izquierdo
                    } else { // (right > left > n)
                        cambiarPosicion(array, right, n);
                        n = right; // continuar la recursión en el niño derecho
                    }
                } else { // (n > left)
                    if (array[right] > array[n]) { // (right > n > left)
                        cambiarPosicion(array, right, n);
                        n = right;// continuar la recursión en el niño derecho
                    } else { // (n > left) & (n > right)
                        break; // El nodo es mayor que los dos hijos, por lo que es heapified
                    }
                }
            }
        }
    }

    private static void cambiarPosicion(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void ordenarBurbuja(int[] arreglo) {
        int iteracion = 1;// establece el lugar hasta donde se iterará
        boolean permutacion;
        do {
            permutacion = false;// valida que el ciclo no sea infinito
            for (int i = 0; i < arreglo.length - iteracion; i++) {
                if (Integer.parseInt(arreglo[i].getDuracion() + "") > Integer.parseInt(arreglo[i + 1].getDuracion() + "")) {
                    permutacion = true;
                    cambiarPosicion(arreglo, i, i + 1);
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
                if (arreglo[actual] < arreglo[actual - 1]) {
                    cambiarPosicion(arreglo, actual, actual - 1);
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

    private static void burbuja(int[] arreglo, int p) {
        int j = p;
        while ((j > 0) && (arreglo[j] < arreglo[j - 1])) {
            cambiarPosicion(arreglo, j - 1, j);
            j--;
        }
    }

    public static void ordenarMezcla(int[] arreglo) {
        mergesort(arreglo, 0, arreglo.length - 1);
    }

    private static void mergesort(int A[], int izq, int der) {
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
                        cambiarPosicion(arreglo, j, k);
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
        while (posIzquierda != posDerecha) {
            while (Integer.parseInt(arreglo[posDerecha].getDuracion()+"") >= Integer.parseInt(arreglo[pivote].getDuracion()+"") && posIzquierda < posDerecha) {
                posDerecha--;// cambiara de posicion si todo esta bien
            }            // por el lado derecho
            while (Integer.parseInt(arreglo[posIzquierda].getDuracion()+"") < Integer.parseInt(arreglo[pivote].getDuracion()+"") && posIzquierda < posDerecha) {
                posIzquierda++;// cambiara de posicion si todo esta bien
            }            // por el lado izquierdo
            if (posDerecha != posIzquierda) {//Cambiara la posicion si hay alguna inconsistencia de mayor o menor
                cambiarPosicion(arreglo, posDerecha, posIzquierda);
            }
            if (posIzquierda == posDerecha) {//Partira el arreglo en dos partes con el fin de hacer lo mismo con los subconjuntos
                //Hasta que quede un solo numero (Simulacion)
                quickSort(arreglo, i, pivote - 1);//desde inicial hasta pivote-1
                quickSort(arreglo, pivote + 1, d);//desde pivote+1 hasta final
            }
        }
    }

    public static void ordenarInsercion(int array[]) {
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

    public static void ordenarSeleccion(int array[]) {
        int i, j, menor, poss;
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
                cambiarPosicion(array, i, poss);
            }
        }
    }

    public static void ordenarPeine(int array[]) {
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
                    cambiarPosicion(array, actual, actual + gap);
                }
            }
        }
    }
}
