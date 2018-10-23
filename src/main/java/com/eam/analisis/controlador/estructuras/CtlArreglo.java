/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador.estructuras;

import com.eam.analisis.controlador.Main;
import com.eam.analisis.modelo.Cancion;
import com.eam.analisis.modelo.EstadisticaEstructura;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class CtlArreglo {

    public static Cancion arreglo[] = new Cancion[0];

    public static void llenarArreglo(int capacidad) {
        arreglo = new Cancion[capacidad];
        ArrayList<Cancion> lstCanciones = new ArrayList<>(Main.dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <=" + capacidad + "", Cancion.class));
        long tiempo = System.nanoTime();
        for (int i = 0; i < lstCanciones.size(); i++) {
            arreglo[i] = lstCanciones.get(i);
        }
        tiempo = System.nanoTime() - tiempo;
        Main.dao.guardar(new EstadisticaEstructura("insert", "Arreglo", new BigInteger(capacidad + ""), new BigInteger(tiempo + "")));
        JOptionPane.showMessageDialog(null, "Se han añadido " + capacidad + " registros en el arrelo");

    }

    public static void removeArreglo(int capacida) {
        if (!(arreglo.length == 0)) {
            if (capacida > arreglo.length) {
                JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a eliminar mas grande que el tamaño del arreglo");
                return;
            }

            long tiempo = System.nanoTime();
            int num = capacida;
            while (num != 0) {
                arreglo[num] = null;
                num--;
            }
            tiempo = System.nanoTime() - tiempo;
            Main.dao.guardar(new EstadisticaEstructura("delete", "Arreglo", new BigInteger(capacida + ""), new BigInteger(tiempo + "")));
            JOptionPane.showMessageDialog(null, "Se han eliminado " + capacida + " elementos del hash map");
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo esta vacio");
        }
    }

    public static void actualizarArreglo(int capacida) {
        if ((arreglo.length == 0)) {
            JOptionPane.showMessageDialog(null, "El arreglo esta vacio");
        }
        if (capacida > arreglo.length) {
            JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a editar mas grande que el tamaño del arreglo");
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
            actualizarArreglo(capacida);
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
            int cantidad = capacida;
            long time = System.nanoTime();
            while (cantidad != 0) {
                arreglo[cantidad] = cancion;
                cantidad--;
            }
            time = System.nanoTime() - time;
            Main.dao.guardar(new EstadisticaEstructura("update", "Arreglo", new BigInteger(capacida + ""), new BigInteger(time + "")));
            JOptionPane.showMessageDialog(null, "Se han modificado " + capacida + " con la estructura de la cancion:\n"
                    + "Nombre: " + nombre + "\n"
                    + "Duracion: " + duracion + "\n"
                    + "Fecha Lanzamiento: " + fechaLanzamiento);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cambiado ningun campo");
        }
    }

    public static void buscar(int limit) {
        if (arreglo.length == 0) {
            JOptionPane.showMessageDialog(null, "el arreglo esta vacio");
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
        long tiempo = System.nanoTime();
        for (int i = 0; i < arreglo.length; i++) {
            Cancion can = arreglo[i];
            if (Integer.parseInt(can.getId() + "") == idCancion) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado la cancion\n"
                        + "Nombre: " + can.getNombre() + "\n"
                        + "Duracion: " + can.getDuracion() + "\n"
                        + "Fecha Lanzamiento: " + can.getFechaLanzamiento());
                tiempo = System.nanoTime() - tiempo;
                Main.dao.guardar(new EstadisticaEstructura("Busqueda Secuencial", "Arreglo", new BigInteger(limit + ""), new BigInteger(tiempo + "")));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado");
        tiempo = System.nanoTime() - tiempo;
        Main.dao.guardar(new EstadisticaEstructura("Busqueda Secuencial", "Arreglo", new BigInteger(limit + ""), new BigInteger(tiempo + "")));

    }

}
