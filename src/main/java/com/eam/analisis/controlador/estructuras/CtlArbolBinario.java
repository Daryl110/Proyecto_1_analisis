/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador.estructuras;

import com.eam.analisis.controlador.Main;
import com.eam.analisis.dao.DAO;
import com.eam.analisis.modelo.Cancion;
import com.eam.analisis.modelo.EstadisticaEstructura;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class CtlArbolBinario {

    public static TreeSet<Cancion> arbol = new TreeSet<>();

    public static void llenarArbol(int capacida) {
        arbol = new TreeSet<>();
        ArrayList<Cancion> lstCanciones = new ArrayList<>(Main.dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <=" + capacida + "", Cancion.class));
        long tiempo = System.nanoTime();
        for (Cancion cancion : lstCanciones) {
            arbol.add(cancion);
        }
        tiempo = System.nanoTime() - tiempo;
        Main.dao.guardar(new EstadisticaEstructura("insert", "Arbol", new BigInteger(capacida + ""), new BigInteger(tiempo + "")));
        JOptionPane.showMessageDialog(null, "Se ha ingresado con exito");

    }

    public static void remove(int limit) {
        if (!arbol.isEmpty()) {
            if (limit > arbol.size()) {
                JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a eliminar mas grande que el tamaño del arbol");
                return;
            }
            int numCanciones = limit;
            long time = System.nanoTime();
            while (limit > 0) {
                arbol.remove(new BigDecimal(limit + ""));
                limit--;
            }
            time = System.nanoTime() - time;
            Main.dao.guardar(new EstadisticaEstructura("delete", "Arbol", new BigInteger(numCanciones + ""), new BigInteger(time + "")));
            JOptionPane.showMessageDialog(null, "Se han eliminado " + numCanciones + " elementos en el arbol");
        } else {
            JOptionPane.showMessageDialog(null, "el arbol esta vacia");
        }
    }

    public static void set(int limit) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "el arbol esta vacia");
        }
        if (limit > arbol.size()) {
            JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a eliminar mas grande que el tamaño de el arbol");
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
            set(limit);
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
            }
        } catch (Exception e) {
            fechaLanzamiento = cancion.getFechaLanzamiento();
        }

        if (camposCambiados != 0) {
            cancion = new Cancion(new BigDecimal(id + ""), nombre, new BigInteger(duracion + ""), fechaLanzamiento);
            int cantidad = limit;
            long time = System.nanoTime();
            for (Cancion auxCancion : arbol) {
                if (limit > 0) {
                    auxCancion.setNombre(cancion.getNombre());
                    auxCancion.setDuracion(cancion.getDuracion());
                    auxCancion.setFechaLanzamiento(cancion.getFechaLanzamiento());
                    limit--;
                } else {
                    break;
                }
            }
            time = System.nanoTime() - time;
            Main.dao.guardar(new EstadisticaEstructura("update", "Arbol", new BigInteger(cantidad + ""), new BigInteger(time + "")));
            JOptionPane.showMessageDialog(null, "Se han modificado " + cantidad + " elementos con la estructura de la cancion:\n"
                    + "Nombre: " + nombre + "\n"
                    + "Duracion: " + duracion + "\n"
                    + "Fecha Lanzamiento: " + fechaLanzamiento);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cambiado ningun campo");
        }
    }

    public static void buscar(int limit) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "el arbol esta vacia");
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
            buscar(limit);
            return;
        }
        long time = System.nanoTime();
        for (Cancion cancion : arbol) {
            if (Integer.parseInt(cancion.getId() + "") == idCancion) {
                time = System.nanoTime() - time;
                Main.dao.guardar(new EstadisticaEstructura("Busqueda Binaria", "ArbolAVL", new BigInteger(limit + ""), new BigInteger(time + "")));
                JOptionPane.showMessageDialog(null, "Se ha encontrado la cancion\n"
                        + "Nombre: " + cancion.getNombre() + "\n"
                        + "Duracion: " + cancion.getDuracion() + "\n"
                        + "Fecha Lanzamiento: " + cancion.getFechaLanzamiento());
                return;
            }
        }
        time = System.nanoTime() - time;
        Main.dao.guardar(new EstadisticaEstructura("Busqueda Binaria", "ArbolAVL", new BigInteger(limit + ""), new BigInteger(time + "")));
        JOptionPane.showMessageDialog(null, "No se ha encontrado el valor");

    }

    public void añadirArbol(int capacida, Cancion cancion) {
        llenarArbol(capacida);
        long tiempo = System.nanoTime();
        arbol.add(cancion);
        tiempo = System.nanoTime() - tiempo;
    }

    public void mostrarArbol() {
        for (Cancion cancion : arbol) {
            System.out.println(cancion.toString());
        }
    }

}
