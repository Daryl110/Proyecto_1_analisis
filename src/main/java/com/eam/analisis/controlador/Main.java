/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import com.eam.analisis.dao.DAO;
import com.eam.analisis.modelo.Cancion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Daryl Ospina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO dao = new DAO("ConexionBD");
        ArrayList<Cancion> lstCanciones = new ArrayList<>(dao.cargarConsulta("Select * from ANALISIS.CANCION WHERE ROWNUM <= 10", Cancion.class));
        for (Cancion cancion : lstCanciones) {
            System.out.println("Nombre: "+cancion.getNombre());
            System.out.println("FechaLanzamiento: "+new SimpleDateFormat("yyyy/MM/dd").format(cancion.getFechaLanzamiento()));
            System.out.println("Duracion: "+cancion.getDuracion());
        }
    }

}
