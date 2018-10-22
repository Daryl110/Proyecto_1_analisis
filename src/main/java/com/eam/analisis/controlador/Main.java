/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import java.util.HashMap;

/**
 * @author Daryl Ospina
 */
public class Main {

    public static void main(String[] args) {
        CtlArbolBinario arbol = new CtlArbolBinario();
        arbol.llenarArbol(10);
        arbol.mostrarArbol();
    }

}
