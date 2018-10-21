/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class ListasPivoteadas {

    public static DefaultTableModel listarEstructuras() {
        String[] columnas = {"Operacion", "Lista Simple"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, columnas);

        ArrayList<Object[]> resulSet = new ArrayList<>(Main.dao.cargarConsulta("SELECT * FROM "
                + "( "
                + "    SELECT EE.TIPO_OPERACION, EE.TIPO_ESTRUCTURA, TIEMPO FROM ESTADISTICA_ESTRUCTURA EE "
                + ") "
                + "PIVOT "
                + "( "
                + "    AVG(TIEMPO) "
                + "    FOR TIPO_ESTRUCTURA IN ('ListaSimple' AS \"Lista Simple\") "
                + ")", null));

        resulSet.forEach((arreglo) -> {
            modelo.addRow(new Object[]{
                arreglo[0],
                new BigDecimal(arreglo[1]+"").setScale(2, BigDecimal.ROUND_HALF_UP)
            });
        });
        return modelo;
    }
}
