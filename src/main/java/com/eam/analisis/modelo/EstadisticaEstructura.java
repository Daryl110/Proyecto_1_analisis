/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nick_
 */
@Entity
@Table(name = "ESTADISTICA_ESTRUCTURA")
@NamedQueries({
    @NamedQuery(name = "EstadisticaEstructura.findAll", query = "SELECT e FROM EstadisticaEstructura e")
    , @NamedQuery(name = "EstadisticaEstructura.findByIdEstructuras", query = "SELECT e FROM EstadisticaEstructura e WHERE e.idEstructuras = :idEstructuras")
    , @NamedQuery(name = "EstadisticaEstructura.findByTipoOperacion", query = "SELECT e FROM EstadisticaEstructura e WHERE e.tipoOperacion = :tipoOperacion")
    , @NamedQuery(name = "EstadisticaEstructura.findByTipoEstructura", query = "SELECT e FROM EstadisticaEstructura e WHERE e.tipoEstructura = :tipoEstructura")
    , @NamedQuery(name = "EstadisticaEstructura.findByNumeroCanciones", query = "SELECT e FROM EstadisticaEstructura e WHERE e.numeroCanciones = :numeroCanciones")
    , @NamedQuery(name = "EstadisticaEstructura.findByTiempo", query = "SELECT e FROM EstadisticaEstructura e WHERE e.tiempo = :tiempo")})
public class EstadisticaEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "ID_ESTRUCTURAS", strategy = GenerationType.AUTO)
    @Column(name = "ID_ESTRUCTURAS")
    private BigDecimal idEstructuras;
    @Column(name = "TIPO_OPERACION")
    private String tipoOperacion;
    @Column(name = "TIPO_ESTRUCTURA")
    private String tipoEstructura;
    @Column(name = "NUMERO_CANCIONES")
    private BigInteger numeroCanciones;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;

    public EstadisticaEstructura() {
    }

    public EstadisticaEstructura(BigDecimal idEstructuras) {
        this.idEstructuras = idEstructuras;
    }

    public EstadisticaEstructura(String tipoOperacion, String tipoEstructura, BigInteger numeroCanciones, BigInteger tiempo) {
        this.tipoOperacion = tipoOperacion;
        this.tipoEstructura = tipoEstructura;
        this.numeroCanciones = numeroCanciones;
        this.tiempo = tiempo;
    }
    

    public BigDecimal getIdEstructuras() {
        return idEstructuras;
    }

    public void setIdEstructuras(BigDecimal idEstructuras) {
        this.idEstructuras = idEstructuras;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoEstructura() {
        return tipoEstructura;
    }

    public void setTipoEstructura(String tipoEstructura) {
        this.tipoEstructura = tipoEstructura;
    }

    public BigInteger getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(BigInteger numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public BigInteger getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigInteger tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstructuras != null ? idEstructuras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaEstructura)) {
            return false;
        }
        EstadisticaEstructura other = (EstadisticaEstructura) object;
        if ((this.idEstructuras == null && other.idEstructuras != null) || (this.idEstructuras != null && !this.idEstructuras.equals(other.idEstructuras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.analisis.modelo.EstadisticaEstructura[ idEstructuras=" + idEstructuras + " ]";
    }
    
}
