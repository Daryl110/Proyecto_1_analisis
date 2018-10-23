package com.eam.analisis.vistas;

import com.eam.analisis.controlador.TablasPivoteadas;
import com.eam.analisis.controlador.Main;
import com.eam.analisis.controlador.estructuras.CtlArbolAvl;
import com.eam.analisis.controlador.estructuras.CtlArbolBinario;
import com.eam.analisis.controlador.estructuras.CtlArray;
import com.eam.analisis.controlador.estructuras.CtlArreglo;
import com.eam.analisis.controlador.estructuras.CtlCola;
import com.eam.analisis.controlador.estructuras.CtlHash;
import com.eam.analisis.controlador.estructuras.CtlListaDoble;
import com.eam.analisis.controlador.estructuras.CtlListaSimple;
import com.eam.analisis.controlador.estructuras.CtlPila;
import com.eam.analisis.modelo.Cancion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yo
 */
public class FrmEstructuras extends javax.swing.JFrame {

    public FrmEstructuras() {
        initComponents();
        this.listarEstructuras();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCalcular = new javax.swing.JButton();
        cbTipoEstructura = new javax.swing.JComboBox<>();
        cbCantidaD = new javax.swing.JComboBox<>();
        cbCrud = new javax.swing.JComboBox<>();
        pnlTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstructuras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        cbFiltroCantidad = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        cbTipoEstructura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione una estructura", "Lista Simple", "Lista Doble", "Arbol AVL", "Cola", "ArrayList", "Hash", "Pila", "Arreglo", "Arbol" }));

        cbCantidaD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione una cantidad", "100", "1000", "10000", "100000", "500000", "1000000" }));

        cbCrud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione una operación", "Insert", "Update", "Delete", "busquedad binaria", "busquedad secuencial" }));

        pnlTabla.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        tblEstructuras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEstructuras);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("NOTA:");

        jLabel2.setText("En la tabla solo se tienen en cuenta el promedio de cada operacion ralizada, dentro de una estructura");

        jLabel3.setText("de datos.");

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlTablaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        cbFiltroCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el filtro de cantidad", "100", "1000", "10000", "100000", "500000", "1000000" }));
        cbFiltroCantidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroCantidadItemStateChanged(evt);
            }
        });

        jButton1.setText("Graficar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTipoEstructura, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addComponent(cbCantidaD, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addComponent(cbCrud, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbFiltroCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoEstructura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCantidaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCrud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltroCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtras)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        Main.iniciarVentanaPrincipal();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        int estructura = cbTipoEstructura.getSelectedIndex();
        if (estructura != 0) {
            int operacion = cbCrud.getSelectedIndex();
            if (operacion != 0) {
                String strOperacion = cbCrud.getSelectedItem().toString();
                String strEstructura = cbTipoEstructura.getSelectedItem().toString();
                int cantidadCanciones = cbCantidaD.getSelectedIndex();
                if (cantidadCanciones != 0) {
                    cantidadCanciones = Integer.parseInt(cbCantidaD.getSelectedItem().toString());
                    switch (strEstructura) {
                        case "Lista Simple":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlListaSimple.add(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlListaSimple.set(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlListaSimple.remove(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda binaria\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlListaSimple.buscar(cantidadCanciones);
                                    break;
                            }
                            break;
                        case "Lista Doble":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlListaDoble.add(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlListaDoble.set(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlListaDoble.remove(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    CtlListaDoble.buscarBinario(cantidadCanciones);
                                    break;
                                case "busquedad secuencial":
                                    CtlListaDoble.buscarSecuencial(cantidadCanciones);
                                    break;
                            }
                            break;
                        case "Arbol AVL":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlArbolAvl.add(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlArbolAvl.set(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlArbolAvl.remove(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    CtlArbolAvl.buscar(cantidadCanciones);
                                    break;
                                case "busquedad secuencial":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                            }
                            break;
                        case "Cola":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlCola.llenarCola(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlCola.actualizarCola(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlCola.removerCola(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlCola.buscarCola(operacion);
                                    break;
                            }
                            break;
                        case "ArrayList":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlArray.llenarArray(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlArray.actualizarArray(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlArray.removerArray(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlArray.buscar(cantidadCanciones);
                                    break;
                            }
                            break;
                        case "Hash":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlHash.llenarHash(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlHash.actualizarHash(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlHash.removerHash(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlHash.buscar(cantidadCanciones);
                                    break;
                            }
                            break;
                        case "Pila":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlPila.llenarPila(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlPila.actualizarPila(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlPila.removerPila(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlPila.buscar(cantidadCanciones);
                                    break;
                            }
                            break;
                        case "Arreglo":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlArreglo.llenarArreglo(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlArreglo.actualizarArreglo(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlArray.removerArray(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlArreglo.buscar(cantidadCanciones);
                                    break;
                            }
                            break;
                        case "Arbol":
                            switch (strOperacion) {
                                case "Insert":
                                    CtlArbolBinario.llenarArbol(cantidadCanciones);
                                    break;
                                case "Update":
                                    CtlArbolBinario.set(cantidadCanciones);
                                    break;
                                case "Delete":
                                    CtlArbolBinario.remove(cantidadCanciones);
                                    break;
                                case "busquedad binaria":
                                    JOptionPane.showMessageDialog(this, "No esta permitda la busqueda secuencial\n"
                                            + "en este tipo de estructura de datos");
                                    break;
                                case "busquedad secuencial":
                                    CtlArbolBinario.buscar(cantidadCanciones);
                                    break;
                            }
                            break;
                    }
                    this.listarEstructuras();
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad valida de datos");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado una operacion valida");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado una estructura de datos");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void cbFiltroCantidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroCantidadItemStateChanged
        this.listarEstructuras();
    }//GEN-LAST:event_cbFiltroCantidadItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cbCantidaD;
    private javax.swing.JComboBox<String> cbCrud;
    private javax.swing.JComboBox<String> cbFiltroCantidad;
    private javax.swing.JComboBox<String> cbTipoEstructura;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JTable tblEstructuras;
    // End of variables declaration//GEN-END:variables

    private void listarEstructuras() {
        if (cbFiltroCantidad.getSelectedIndex() != 0 && cbFiltroCantidad.getSelectedIndex() <= 6) {
            tblEstructuras.setModel(TablasPivoteadas.listarEstructuras(Integer.parseInt(cbFiltroCantidad.getSelectedItem().toString())));
        } else {
            tblEstructuras.setModel(new DefaultTableModel());
        }
    }
}
