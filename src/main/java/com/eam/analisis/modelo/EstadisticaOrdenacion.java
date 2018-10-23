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
@Table(name = "ESTADISTICA_ORDENACION")
@NamedQueries({
    @NamedQuery(name = "EstadisticaOrdenacion.findAll", query = "SELECT e FROM EstadisticaOrdenacion e")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByIdOrdenacion", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.idOrdenacion = :idOrdenacion")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByTipoDato", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.tipoDato = :tipoDato")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByTipoOrdenacion", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.tipoOrdenacion = :tipoOrdenacion")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByNumeroCanciones", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.numeroCanciones = :numeroCanciones")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByTiempo", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.tiempo = :tiempo")})
public class EstadisticaOrdenacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "ID_ORDENACION", strategy = GenerationType.AUTO)
    @Column(name = "ID_ORDENACION")
    private BigDecimal idOrdenacion;
    @Column(name = "TIPO_DATO")
    private String tipoDato;
    @Column(name = "TIPO_ORDENACION")
    private String tipoOrdenacion;
    @Column(name = "NUMERO_CANCIONES")
    private BigInteger numeroCanciones;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;

    public EstadisticaOrdenacion() {
    }

    public EstadisticaOrdenacion(BigDecimal idOrdenacion) {
        this.idOrdenacion = idOrdenacion;
    }

    public BigDecimal getIdOrdenacion() {
        return idOrdenacion;
    }

    public EstadisticaOrdenacion(String tipoDato, String tipoOrdenacion, BigInteger numeroCanciones, BigInteger tiempo) {
        this.tipoDato = tipoDato;
        this.tipoOrdenacion = tipoOrdenacion;
        this.numeroCanciones = numeroCanciones;
        this.tiempo = tiempo;
    }

    public void setIdOrdenacion(BigDecimal idOrdenacion) {
        this.idOrdenacion = idOrdenacion;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getTipoOrdenacion() {
        return tipoOrdenacion;
    }

    public void setTipoOrdenacion(String tipoOrdenacion) {
        this.tipoOrdenacion = tipoOrdenacion;
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
        hash += (idOrdenacion != null ? idOrdenacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaOrdenacion)) {
            return false;
        }
        EstadisticaOrdenacion other = (EstadisticaOrdenacion) object;
        if ((this.idOrdenacion == null && other.idOrdenacion != null) || (this.idOrdenacion != null && !this.idOrdenacion.equals(other.idOrdenacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.analisis.modelo.EstadisticaOrdenacion[ idOrdenacion=" + idOrdenacion + " ]";
    }
    
}
