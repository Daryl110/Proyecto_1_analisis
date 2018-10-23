/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador.reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daryl Ospina
 */
public class CtlReportes {
    
    public static void graficarOrdenamientos(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Analisis", "1094971007");
            JasperReport jr = JasperCompileManager.compileReport("./src/main/resources/Reportes/Estadisticas_ordenacion.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cone);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (SQLException | ClassNotFoundException | JRException ex) {
            System.out.println("[Error] : Generando reporte Excepcion: " + ex);
        }
    }
    
    public static void graficarEstructuras(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Analisis", "1094971007");
            JasperReport jr = JasperCompileManager.compileReport("./src/main/resources/Reportes/Estadistica_estructuras.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cone);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (SQLException | ClassNotFoundException | JRException ex) {
            System.out.println("[Error] : Generando reporte Excepcion: " + ex);
        }
    }
}
