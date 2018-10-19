/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador;

import com.eam.analisis.dao.DAO;
import com.eam.analisis.dao.IDAO;
import com.eam.analisis.modelo.Cancion;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Daryl Ospina
 */
public class Main {
    
    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {
        int[] arreglo = {5,2,6,8,4,1,9,10,7,3};
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]+" ");
        }
        
        long tiempo = System.nanoTime();
        MetodosOrdenacion.ordenarMonticulo(arreglo);
        tiempo = System.nanoTime()-tiempo;
        
        System.out.println("");
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]+" ");
        }
        System.out.println("");
        
        System.out.println("Tiempo: "+(tiempo*Math.pow(10, -9)));

//        Cancion cancion = new Cancion("Cancion1", new BigInteger("135"), new Date("11/10/2018"));
//        
//        DAO dao = new DAO("ConexionBD");
//        
//        System.out.println(dao.guardar(cancion));
    }
    
}
