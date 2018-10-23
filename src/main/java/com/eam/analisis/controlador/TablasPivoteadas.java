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
        String[] columnas = {"Operacion", "Lista Simple", "Lista Doble", "ArbolAVL","Arbol","Arreglo","ArrayList","Cola","Hash","Pila"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, columnas);

        String query = "SELECT TIPO_OPERACION, NVL(\"'ListaSimple'\",0), NVL(\"'ListaDoble'\",0), NVL(\"'ArbolAVL'\",0),NVL(\"'Arbol'\",0),NVL(\"'Arreglo'\",0),NVL(\"'ArrayList'\",0),NVL(\"'Cola'\",0),NVL(\"'Hash'\",0),NVL(\"'Pila'\",0) FROM "
                + "( "
                + "    SELECT EE.TIPO_OPERACION, EE.TIPO_ESTRUCTURA, TIEMPO FROM ESTADISTICA_ESTRUCTURA EE "
                + "    WHERE EE.NUMERO_CANCIONES=" + filtro + " "
                + ") "
                + "PIVOT "
                + "( "
                + "    AVG(TIEMPO) "
                + "    FOR TIPO_ESTRUCTURA IN ('ListaSimple','ListaDoble','ArbolAVL','Arbol','Arreglo','ArrayList','Cola','Hash','Pila') "
                + ")";

        ArrayList<Object[]> resulSet = new ArrayList<>(Main.dao.cargarConsulta(query, null));

        resulSet.forEach((arreglo) -> {
            modelo.addRow(new Object[]{
                arreglo[0],
                new BigDecimal(arreglo[1] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[2] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[3] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[4] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[5] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[6] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[7] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[8] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[9] + "").setScale(2, BigDecimal.ROUND_HALF_UP)
            });
        });
        if (resulSet.isEmpty()) {
            return new DefaultTableModel();
        } else {
            return modelo;
        }
    }

    public static DefaultTableModel listarMetodosOrdenacion(Object filtro) {
        String[] columnas = {"Tipo Dato", "Inserción", "Burbuja", "Burbuja Bidireccional", "Gnome",
        "Mezcla", "Selección", "Peine", "Shell", "Monticulos", "Rapido"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, columnas);

        String query = "SELECT TIPO_DATO, NVL(\"'inserción'\",0), NVL(\"'burbuja'\",0), NVL(\"'burbuja bidireccional'\",0), NVL(\"'gnome'\",0), "
                + "       NVL(\"'mezcla'\",0), NVL(\"'seleccion'\",0), NVL(\"'peine'\",0), NVL(\"'shell'\",0), NVL(\"'monticulos'\",0), NVL(\"'rapido'\",0) FROM "
                + "( "
                + "    SELECT EO.TIPO_DATO, EO.TIPO_ORDENACION, TIEMPO FROM ESTADISTICA_ORDENACION EO "
                + "    WHERE EO.NUMERO_CANCIONES="+filtro+" "
                + ") "
                + "PIVOT "
                + "( "
                + "    AVG(TIEMPO) "
                + "    FOR TIPO_ORDENACION IN ('inserción','burbuja','burbuja bidireccional','gnome','mezcla','seleccion','peine','shell','monticulos','rapido') "
                + ") ";

        ArrayList<Object[]> resulSet = new ArrayList<>(Main.dao.cargarConsulta(query, null));

        resulSet.forEach((arreglo) -> {
            modelo.addRow(new Object[]{
                arreglo[0],
                new BigDecimal(arreglo[1] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[2] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[3] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[4] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[5] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[6] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[7] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[8] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[9] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(arreglo[10] + "").setScale(2, BigDecimal.ROUND_HALF_UP),
            });
        });
        if (resulSet.isEmpty()) {
            return new DefaultTableModel();
        } else {
            return modelo;
        }
    }
}
