/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador;

import com.eam.analisis.dao.DAO;
import com.eam.analisis.modelo.Cancion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nick_
 */
public class CtlCola {

    protected DAO dao;
    public long tiempo = 0;
    Queue<Cancion> cola;

    public CtlCola() {

        dao = new DAO("ConexionBD");
        cola = new LinkedList();
    }

    public void llenarCola(int capacida) {
        cola = new LinkedList();
        ArrayList<Cancion> lstCanciones = new ArrayList<>(dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <=" + capacida + "", Cancion.class));
        long tiempoInicio = System.nanoTime();
        for (Cancion cancion : lstCanciones) {
            cola.offer(cancion);
        }
        tiempo = System.nanoTime() - tiempoInicio;

    }

    public void añadirCola(int capacida, Cancion cancion) {
        llenarCola(capacida);
        long tiempoInicio = System.nanoTime();
        cola.offer(cancion);
        tiempo = System.nanoTime() - tiempoInicio;
    }

    public Cancion removerCola(int capacida, int valor) {
        llenarCola(capacida);
        Queue<Cancion> colaAux = new LinkedList();
        long tiempoInicio = System.nanoTime();
        while (!cola.isEmpty()) {
            if ((cola.peek().getId() + "").equals(valor + "")) {
                Cancion c = cola.poll();
                organizarCola(cola, colaAux);
                return c;
            }
            colaAux.offer(cola.poll());
        }
        tiempo = System.nanoTime() - tiempoInicio;
        return null;
    }

    public Cancion actualizarCola(int capacida, int valor, Cancion cancion) {
        llenarCola(capacida);
        Queue<Cancion> colaAux = new LinkedList();
        long tiempoInicio = System.nanoTime();
        while (!cola.isEmpty()) {
            if ((cola.peek().getId() + "").equals(valor + "")) {
                cola.peek().setDuracion(cancion.getDuracion());
                cola.peek().setFechaLanzamiento(cancion.getFechaLanzamiento());
                cola.peek().setNombre(cancion.getNombre());
                Cancion c = cola.peek();
                organizarCola(cola, colaAux);
                return c;
            }
            colaAux.offer(cola.poll());
        }
        tiempo = System.nanoTime() - tiempoInicio;
        return null;
    }

    public Cancion buscarCola(int capacida, int valor) {
        llenarCola(capacida);
        Queue<Cancion> colaAux = new LinkedList();
        long tiempoInicio = System.nanoTime();
        while (!cola.isEmpty()) {
            if ((cola.peek().getId() + "").equals(valor + "")) {
                Cancion c = cola.peek();
                organizarCola(cola, colaAux);
                return c;
            }
            colaAux.offer(cola.poll());
        }
        tiempo = System.nanoTime() - tiempoInicio;
        return null;
    }

    public void mostrarCola() {
        Queue colaClon = new LinkedList(cola);
        while (!colaClon.isEmpty()) {
            System.out.println(colaClon.poll().toString());
        }
    }

    private void organizarCola(Queue<Cancion> cola, Queue<Cancion> aux) {
        while (!cola.isEmpty()) {
            aux.offer(cola.poll());
        }
        while (!aux.isEmpty()) {
            cola.offer(aux.poll());
        }

    }

}
