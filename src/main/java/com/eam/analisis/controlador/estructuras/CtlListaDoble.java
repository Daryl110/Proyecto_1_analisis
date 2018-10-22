/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.controlador.estructuras;

import eam.librerias.estructuras.listaDoble.Nodo;
import com.eam.analisis.controlador.Main;
import com.eam.analisis.modelo.Cancion;
import com.eam.analisis.modelo.EstadisticaEstructura;
import eam.librerias.estructuras.listaDoble.ListaDoble;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Daryl Ospina
 */
public class CtlListaDoble {
    
    public static ListaDoble<Cancion> canciones = new ListaDoble<>();
    
    public static void add(int limit) {
        ArrayList<Cancion> array = new ArrayList(Main.dao.cargarConsulta("SELECT * FROM CANCION WHERE ROWNUM <= " + limit, Cancion.class));
        long time = System.nanoTime();
        array.forEach((cancion) -> {
            canciones.add(new Nodo<>(cancion));
        });
        time = System.nanoTime() - time;
        Main.dao.guardar(new EstadisticaEstructura("insert", "ListaDoble", new BigInteger(limit + ""), new BigInteger(time + "")));
    }
    
    public static void mostrar(){
        Nodo<Cancion> nodoAux = canciones.getInicio();
        while (nodoAux != null) {
            System.out.println(nodoAux.getValor().getId());
            nodoAux = nodoAux.getSiguiente();
        }
    }
    
    public static void remove(int limit) {
        if (!canciones.isEmpty()) {
            if (limit > canciones.size()) {
                JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a eliminar mas grande que el tamaño de la lista");
                return;
            }
            int numCanciones = limit;
            long time = System.nanoTime();
            while (limit > 0) {
                canciones.remove(limit-1);
                limit--;
            }
            time = System.nanoTime() - time;
            Main.dao.guardar(new EstadisticaEstructura("delete", "ListaDoble", new BigInteger(numCanciones + ""), new BigInteger(time + "")));
        } else {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia");
        }
    }
    
    public static void set(int limit) {
        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia");
        }
        if (limit > canciones.size()) {
            JOptionPane.showMessageDialog(null, "Se ha especificado un valor de elementos a eliminar mas grande que el tamaño de la lista");
            return;
        }
        int id,
                duracion,
                dia,
                mes,
                anio,
                camposCambiados = 0;
        String nombre;
        Date fechaLanzamiento = null;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id de una cancion \n"
                    + "con la que desea basarse en caso de no querer modificar mas campos"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor de id valido");
            return;
        }
        Cancion cancion = (Cancion) Main.dao.buscar(new BigDecimal(id + ""), Cancion.class);
        if (cancion == null) {
            JOptionPane.showMessageDialog(null, "El id ingresado no es valido");
            set(limit);
            return;
        }
        try {
            nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre de la cancion \n"
                    + "o deje vacio si no desea cambiarlo, el nombre actual es: " + cancion.getNombre());
            camposCambiados++;
        } catch (Exception e) {
            nombre = cancion.getNombre();
        }
        try {
            duracion = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la duracion de la cancion nueva de la cancion \n"
                    + "o deje en blanco si no desea cambiarlo, la actual duracion de la cancion es: " + cancion.getDuracion()));
            camposCambiados++;
        } catch (Exception e) {
            duracion = cancion.getDuracion().intValue();
        }
        try {
            if (JOptionPane.showConfirmDialog(null, "Desea cambiar la fecha de lanzamiento de la cancion") == 0) {
                dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de lanzamiento"));
                mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de lanzamiento"));
                anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de lanzamiento"));
                fechaLanzamiento = new Date(dia + "/" + mes + "/" + anio);
                camposCambiados++;
            }
        } catch (Exception e) {
            fechaLanzamiento = cancion.getFechaLanzamiento();
        }

        if (camposCambiados != 0) {
            cancion = new Cancion(new BigDecimal(id + ""), nombre, new BigInteger(duracion + ""), fechaLanzamiento);
            int cantidad = limit;
            long time = System.nanoTime();
            Nodo<Cancion> auxCancion = canciones.getInicio();
            while (auxCancion != null && limit > 0) {
                auxCancion.getValor().setNombre(cancion.getNombre());
                auxCancion.getValor().setDuracion(cancion.getDuracion());
                auxCancion.getValor().setFechaLanzamiento(cancion.getFechaLanzamiento());
                limit--;
                auxCancion = auxCancion.getSiguiente();
            }
            time = System.nanoTime() - time;
            Main.dao.guardar(new EstadisticaEstructura("update", "ListaDoble", new BigInteger(cantidad + ""), new BigInteger(time + "")));
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cambiado ningun campo");
        }
    }
    
    public static void buscarSecuencial() {
        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia");
            return;
        }
        int idCancion;
        try {
            idCancion = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id de la cancion que desea buscar"));
            if (idCancion == 0) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado un id valido");
            buscarSecuencial();
            return;
        }
        long time = System.nanoTime();
        Nodo<Cancion> aux = canciones.getInicio();
        while (aux != null) {
            if (aux.getValor().getId().compareTo(new BigDecimal(idCancion+"")) == 0) {
                System.out.println("id: "+aux.getValor().getId());
                break;
            }
            aux = aux.getSiguiente();
        }
        time = System.nanoTime() - time;
        Main.dao.guardar(new EstadisticaEstructura("Busqueda Secuencial", "ListaDoble", new BigInteger(1 + ""), new BigInteger(time + "")));
    }
    
    //Implementando...
    public static void buscarBinario() {
        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia");
            return;
        }
        int idCancion;
        try {
            idCancion = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id de la cancion que desea buscar"));
            if (idCancion == 0) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado un id valido");
            buscarSecuencial();
            return;
        }
        long time = System.nanoTime();
        Nodo<Cancion> aux = canciones.getInicio();
        while (aux != null) {
            if (aux.getValor().getId().compareTo(new BigDecimal(idCancion+"")) == 0) {
                System.out.println("id: "+aux.getValor().getId());
                break;
            }
            aux = aux.getSiguiente();
        }
        time = System.nanoTime() - time;
        Main.dao.guardar(new EstadisticaEstructura("Busqueda Secuencial", "ListaDoble", new BigInteger(1 + ""), new BigInteger(time + "")));
    }
}
