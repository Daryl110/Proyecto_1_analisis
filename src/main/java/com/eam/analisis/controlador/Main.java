/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import com.eam.analisis.controlador.estructuras.CtlListaDoble;
import com.eam.analisis.dao.DAO;
import com.eam.analisis.vistas.FrmPrincipal;

/**
 * @author Daryl Ospina
 */
public class Main {

    //https://www.journaldev.com/1260/collections-in-java-tutorial
    public static DAO dao = new DAO("ConexionBD");

    public static void main(String[] args) {
//        iniciarVentanaPrincipal();
        CtlListaDoble.add(1000);
        CtlListaDoble.buscarBinario();
    }

    public static void iniciarVentanaPrincipal() {
        FrmPrincipal ventanaPrincipal = new FrmPrincipal();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
}
