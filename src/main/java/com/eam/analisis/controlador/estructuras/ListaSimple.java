/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador.estructuras;

import com.eam.analisis.controlador.Main;
import com.eam.analisis.modelo.Cancion;
import com.eam.analisis.modelo.EstadisticaEstructura;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Daryl Ospina
 */
public class ListaSimple {
    
    public static LinkedList<Cancion> canciones = new LinkedList<>();
    
    public static void add(int limit){
        ArrayList array = new ArrayList(Main.dao.cargarConsulta("SELECT * FROM CANCION WHERE ROWNUM <= "+limit, Cancion.class));
        long time = System.nanoTime();
        canciones.addAll(array);
        time = System.nanoTime()-time;
        Main.dao.guardar(new EstadisticaEstructura("insert", "ListaSimple", new BigInteger(limit+""), new BigInteger(time+"")));
    }
    
    public static void mostrar(int limit){
        if (!canciones.isEmpty()) {
            LinkedList<Cancion> auxCanciones = new LinkedList<>();
            while (!canciones.isEmpty() && limit != 0) {
                Cancion cancion = canciones.pop();
                System.out.println(cancion.getNombre());
                auxCanciones.push(cancion);
                limit--;
            }
            while (!auxCanciones.isEmpty()) {
                canciones.push(auxCanciones.pop());
            }
        }else{
            System.out.println("No hay nada en la listaSimple");
        }
    }
}
