/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.controlador.estructuras;

import com.eam.analisis.dao.DAO;
import com.eam.analisis.modelo.Cancion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nick_
 */
public class CtlHash {

    protected DAO dao;
    public long tiempo = 0;
    public HashMap<Integer,Cancion> map;

    public CtlHash() {
        map = new HashMap();
        dao = new DAO("ConexionBD");
    }
    

    public void llenarHash(int capacida) {
        map = new HashMap();
        ArrayList<Cancion> lstCanciones = new ArrayList<>(dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <=" + capacida + "", Cancion.class));
        long tiempoInicio = System.nanoTime();
        for (Cancion cancion : lstCanciones) {
            map.put(Integer.parseInt(cancion.getId() + ""), cancion);
        }
        tiempo = System.nanoTime() - tiempoInicio;

    }

    public void añadirHash(int capacida, Cancion cancion) {
        llenarHash(capacida);
        long tiempoInicio = System.nanoTime();
        map.put(map.size() + 1, cancion);
        tiempo = System.nanoTime() - tiempoInicio;
    }

    public Cancion removerHash(int capacida, int valor) {
        llenarHash(capacida);
        long tiempoInicio = System.nanoTime();
        Cancion c =map.remove(valor);
        tiempo = System.nanoTime() - tiempoInicio;
        return c;
    }

    public Cancion actualizarHash (int capacida, Cancion cancion, int valor) {
        llenarHash(capacida);
        long tiempoInicio = System.nanoTime();
        Cancion c =map.replace(valor, cancion);
        tiempo = System.nanoTime() - tiempoInicio;
        return c;
    }

    public Cancion buscarHash(int capacidad, int valor) {
        llenarHash(capacidad);
        long tiempoInicio = System.nanoTime();
        Cancion c =map.get(valor);
        tiempo = System.nanoTime() - tiempoInicio;
        return c;
    }

    public void mostrarHash() {
        for (int i = 1; i < map.size() + 1; i++) {
            System.out.println(map.get(i).toString());
        }
    }

}
