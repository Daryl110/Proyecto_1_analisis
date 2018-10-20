/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import com.eam.analisis.dao.DAO;
import com.eam.analisis.dao.IDAO;
import com.eam.analisis.modelo.Cancion;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Daryl Ospina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x[] = {18, 16, 3, 7, 5, 19, 1, 8, 9, 2, 6, 13, 17, 14, 15, 12, 4, 11, 10, 20};
        String cadena[] = {"h", "d", "s", "p", "i", "l", "g", "a", "e", "k", "j", "f", "o", "n", "m", "b", "q", "r", "c", "t"};
        Date fechas[] = new Date[10];

        MetodosOrdenacion m = new MetodosOrdenacion();

        MetodosOrdenacionCadena n = new MetodosOrdenacionCadena();

        MetodosOrdenacioFecha f = new MetodosOrdenacioFecha();

       // m.Or

        //n.ordenarBurbuja(cadena);

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " - ");
        }
        System.out.println(" ");
        for (int i = 0; i < cadena.length; i++) {
            System.out.print(cadena[i] + " - ");
        }

        System.out.println(" ");

        Date now = new Date();
        long sixMonthsAgo = (now.getTime() - 15552000000l);
        long today = now.getTime();

        for (int i = 0; i < 10; i++) {
            long ms = ThreadLocalRandom.current().nextLong(sixMonthsAgo, today);
            Date date = new Date(ms);
            fechas[i] = date;
        }

        f.OrdenamientoInsercion(fechas);
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");

        for (int i = 0; i < fechas.length; i++) {

            System.out.print(formateador.format(fechas[i]));
            System.out.print(" - ");
        }

    }

}
