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

    public static void removerArbol(int capacida, int valor) {
        long tiempo = System.nanoTime();
        for (Cancion cancion : arbol) {
            if (Integer.parseInt(cancion.getId() + "") == valor) {
                arbol.remove(cancion);
            }
        }
        tiempo = System.nanoTime() - tiempo;
    }

    public Cancion buscarArbol(int capacida, int valor) {
        llenarArbol(capacida);
        long tiempo = System.nanoTime();
        for (Cancion cancion : arbol) {
            if (Integer.parseInt(cancion.getId() + "") == valor) {
                return cancion;
            }
        }
        tiempo = System.nanoTime() - tiempo;
        return null;
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
