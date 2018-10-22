/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import java.util.HashMap;
import com.eam.analisis.dao.DAO;
import com.eam.analisis.vistas.FrmPrincipal;

/**
 * @author Daryl Ospina
 */
public class Main {

    public static DAO dao = new DAO("ConexionBD");

    public static void main(String[] args) {

        iniciarVentanaPrincipal();
        System.out.println("Daryl la perra");
    }

    public static void iniciarVentanaPrincipal() {
        FrmPrincipal ventanaPrincipal = new FrmPrincipal();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
}
