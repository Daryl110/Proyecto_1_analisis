/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador.estructuras;

import com.eam.analisis.controlador.Main;
import static com.eam.analisis.controlador.estructuras.CtlListaSimple.set;
import com.eam.analisis.dao.DAO;
import com.eam.analisis.modelo.Cancion;
import com.eam.analisis.modelo.EstadisticaEstructura;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class CtlCola {

    public static Queue<Cancion> cola = new LinkedList<>();

    public static void llenarCola(int capacida) {
        cola = new LinkedList();
        ArrayList<Cancion> lstCanciones = new ArrayList<>(Main.dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <=" + capacida + "", Cancion.class));
        long tiempo = System.nanoTime();
        for (Cancion cancion : lstCanciones) {
            cola.offer(cancion);
        }
        tiempo = System.nanoTime() - tiempo;
        Main.dao.guardar(new EstadisticaEstructura("insert", "Cola", new BigInteger(capacida + ""), new BigInteger(tiempo + "")));
        JOptionPane.showMessageDialog(null, "Se ha cargado con " + capacida + " la cola");

    }

//    public void añadirCola(int capacida, Cancion cancion) {
//        llenarCola(capacida);
//        long tiempo = System.nanoTime();
//        cola.offer(cancion);
//        tiempo = System.nanoTime() - tiempo;
//    }
    public static void removerCola(int capacida) {
        int valor = capacida;
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            if (capacida > cola.size()) {
                JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a eliminar mas grande que el tamaño de la lista");
                return;
            }
            long tiempo = System.nanoTime();
            while (capacida != 0) {
                cola.poll();
                capacida--;
            }
            tiempo = System.nanoTime() - tiempo;
            Main.dao.guardar(new EstadisticaEstructura("delete", "Cola", new BigInteger(valor + ""), new BigInteger(tiempo + "")));
            JOptionPane.showMessageDialog(null, "Se ha removido " + valor + " de la cola");
        }
    }

    public static void actualizarCola(int capacida) {
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        }
        if (capacida > cola.size()) {
            JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a actualizar mas grande que el tamaño de la cola");
            return;
        }
        int id,
                duracion,
                dia,
                mes,
                anio,
                camposCambiados = 0;
        String nombre;
        Date fechaLanzamiento = null;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id de una cancion \n"
                    + "con la que desea basarse en caso de no querer modificar mas campos"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor de id valido");
            return;
        }
        Cancion cancion = (Cancion) Main.dao.buscar(new BigDecimal(id + ""), Cancion.class);
        if (cancion == null) {
            JOptionPane.showMessageDialog(null, "El id ingresado no es valido");
            actualizarCola(capacida);
            return;
        }
        try {
            nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre de la cancion \n"
                    + "o deje vacio si no desea cambiarlo, el nombre actual es: " + cancion.getNombre());
            camposCambiados++;
        } catch (Exception e) {
            nombre = cancion.getNombre();
        }
        try {
            duracion = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la duracion de la cancion nueva de la cancion \n"
                    + "o deje en blanco si no desea cambiarlo, la actual duracion de la cancion es: " + cancion.getDuracion()));
            camposCambiados++;
        } catch (Exception e) {
            duracion = cancion.getDuracion().intValue();
        }
        try {
            if (JOptionPane.showConfirmDialog(null, "Desea cambiar la fecha de lanzamiento de la cancion") == 0) {
                dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de lanzamiento"));
                mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de lanzamiento"));
                anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de lanzamiento"));
                fechaLanzamiento = new Date(dia + "/" + mes + "/" + anio);
                camposCambiados++;
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            fechaLanzamiento = cancion.getFechaLanzamiento();
        }
        if (camposCambiados != 0) {
            cancion = new Cancion(new BigDecimal(id + ""), nombre, new BigInteger(duracion + ""), fechaLanzamiento);
            Queue colaAux = new LinkedList();
            int cantidad = capacida;
            long time = System.nanoTime();
            while (cantidad != 0) {
                cola.peek().setDuracion(cancion.getDuracion());
                cola.peek().setFechaLanzamiento(cancion.getFechaLanzamiento());
                cola.peek().setNombre(cancion.getNombre());
                colaAux.offer(cola.poll());
                cantidad--;
            }
            organizarCola(cola, colaAux);
            time = System.nanoTime() - time;
            Main.dao.guardar(new EstadisticaEstructura("update", "Pila", new BigInteger(capacida + ""), new BigInteger(time + "")));
            JOptionPane.showMessageDialog(null, "Se han modificado " + capacida + " con la estructura de la cancion:\n"
                    + "Nombre: " + nombre + "\n"
                    + "Duracion: " + duracion + "\n"
                    + "Fecha Lanzamiento: " + fechaLanzamiento);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cambiado ningun campo");
        }
    }

    public static void buscarCola(int capacidad) {
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
            return;
        }
        int idCancion;
        try {
            idCancion = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id de la cancion que desea buscar"));
            if (idCancion == 0) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado un id valido");
            buscarCola(capacidad);
            return;
        }
        Queue<Cancion> colaAux = new LinkedList();
        long tiempo = System.nanoTime();
        while (!cola.isEmpty()) {
            if ((cola.peek().getId() + "").equals(idCancion + "")) {
                Cancion c = cola.peek();
                organizarCola(cola, colaAux);
                JOptionPane.showMessageDialog(null, "EL valor encontrado es" + c.toString());

                tiempo = System.nanoTime() - tiempo;
                Main.dao.guardar(new EstadisticaEstructura("Busqueda Secuencial", "Cola", new BigInteger(capacidad + ""), new BigInteger(tiempo + "")));
                return;
            }
            colaAux.offer(cola.poll());
        }

        tiempo = System.nanoTime() - tiempo;
        Main.dao.guardar(new EstadisticaEstructura("Busqueda Secuencial", "Cola", new BigInteger(capacidad + ""), new BigInteger(tiempo + "")));

        JOptionPane.showMessageDialog(null, "El valor no existe");
    }

    public void mostrarCola() {
        Queue colaClon = new LinkedList(cola);
        while (!colaClon.isEmpty()) {
            System.out.println(colaClon.poll().toString());
        }
    }

    private static void organizarCola(Queue<Cancion> cola, Queue<Cancion> aux) {
        while (!cola.isEmpty()) {
            aux.offer(cola.poll());
        }
        while (!aux.isEmpty()) {
            cola.offer(aux.poll());
        }

    }

}
