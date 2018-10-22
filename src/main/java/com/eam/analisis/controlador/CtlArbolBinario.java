/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador;

import com.eam.analisis.dao.DAO;
import com.eam.analisis.modelo.Cancion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeSet;

public class CtlArbolBinario {

    protected DAO dao;
    public long tiempo = 0;
    TreeSet<Cancion> arbol;

    public CtlArbolBinario() {
        dao = new DAO("ConexionBD");
        arbol = new TreeSet<>();
    }

    public void llenarArbol(int capacida) {
        arbol = new TreeSet<>();
        ArrayList<Cancion> lstCanciones = new ArrayList<>(dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <=" + capacida + "", Cancion.class));
        long tiempoInicio = System.nanoTime();
        for (Cancion cancion : lstCanciones) {
            arbol.add(cancion);
        }
        tiempo = System.nanoTime() - tiempoInicio;

    }

    public Cancion removerArbol(int capacida, int valor) {
        llenarArbol(capacida);
        long tiempoInicio = System.nanoTime();
        for (Cancion cancion : arbol) {
            if (Integer.parseInt(cancion.getId() + "") == valor) {
                arbol.remove(cancion);
            }
        }
        tiempo = System.nanoTime() - tiempoInicio;
        return null;
    }

    public Cancion buscarArbol(int capacida, int valor) {
        llenarArbol(capacida);
        long tiempoInicio = System.nanoTime();
        for (Cancion cancion : arbol) {
            if (Integer.parseInt(cancion.getId() + "") == valor) {
                return cancion;
            }
        }
        tiempo = System.nanoTime() - tiempoInicio;
        return null;
    }

    public void añadirArbol(int capacida, Cancion cancion) {
        llenarArbol(capacida);
        long tiempoInicio = System.nanoTime();
        arbol.add(cancion);
        tiempo = System.nanoTime() - tiempoInicio;
    }

    public void mostrarArbol() {
        for (Cancion cancion : arbol) {
            System.out.println(cancion.toString());
        }
    }

}
