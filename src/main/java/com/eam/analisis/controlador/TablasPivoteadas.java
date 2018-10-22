/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daryl Ospina
 */
public class TablasPivoteadas {

    public static DefaultTableModel listarEstructuras(Object filtro) {
        String[] columnas = {"Operacion", "Lista Simple", "Lista Doble", "ArbolAVL"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, columnas);
        
        String query;
        if (!filtro.getClass().getSimpleName().equalsIgnoreCase("String")) {
            query = "SELECT TIPO_OPERACION, NVL(\"'ListaSimple'\",0), NVL(\"'ListaDoble'\",0), NVL(\"'ArbolAVL'\",0) FROM "
                + "( "
                + "    SELECT EE.TIPO_OPERACION, EE.TIPO_ESTRUCTURA, TIEMPO FROM ESTADISTICA_ESTRUCTURA EE "
                + "    WHERE EE.NUMERO_CANCIONES="+filtro+" "
                + ") "
                + "PIVOT "
                + "( "
                + "    AVG(TIEMPO) "
                + "    FOR TIPO_ESTRUCTURA IN ('ListaSimple','ListaDoble','ArbolAVL') "
                + ")";
        }else{
            query = "SELECT TIPO_OPERACION, NVL(\"'ListaSimple'\",0), NVL(\"'ListaDoble'\",0), NVL(\"'ArbolAVL'\",0) FROM "
                + "( "
                + "    SELECT EE.TIPO_OPERACION, EE.TIPO_ESTRUCTURA, TIEMPO FROM ESTADISTICA_ESTRUCTURA EE "
                + "    WHERE REGEXP_LIKE(EE.TIPO_OPERACION,'b','i')"
                + ") "
                + "PIVOT "
                + "( "
                + "    AVG(TIEMPO) "
                + "    FOR TIPO_ESTRUCTURA IN ('ListaSimple','ListaDoble','ArbolAVL') "
                + ")";
        }

        ArrayList<Object[]> resulSet = new ArrayList<>(Main.dao.cargarConsulta(query, null));

        resulSet.forEach((arreglo) -> {
            modelo.addRow(new Object[]{
                arreglo[0],
                new BigDecimal(arreglo[1]+"").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[2]+"").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[3]+"").setScale(2, BigDecimal.ROUND_HALF_UP)
            });
        });
        if (resulSet.isEmpty()) {
            return new DefaultTableModel();
        }else{
            return modelo;
        }
    }
}
