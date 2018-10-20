/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "ESTADISTICA_ORDENACION")
@NamedQueries({
    @NamedQuery(name = "EstadisticaOrdenacion.findAll", query = "SELECT e FROM EstadisticaOrdenacion e")
    , @NamedQuery(name = "EstadisticaOrdenacion.findById", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.id = :id")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByTipoTransaccion", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.tipoTransaccion = :tipoTransaccion")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByTipoOrdenacion", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.tipoOrdenacion = :tipoOrdenacion")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByNumeroCanciones", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.numeroCanciones = :numeroCanciones")
    , @NamedQuery(name = "EstadisticaOrdenacion.findByTiempo", query = "SELECT e FROM EstadisticaOrdenacion e WHERE e.tiempo = :tiempo")})
public class EstadisticaOrdenacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TIPO_TRANSACCION")
    private String tipoTransaccion;
    @Column(name = "TIPO_ORDENACION")
    private String tipoOrdenacion;
    @Column(name = "NUMERO_CANCIONES")
    private BigInteger numeroCanciones;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;

    public EstadisticaOrdenacion() {
    }

    public EstadisticaOrdenacion(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaOrdenacion)) {
            return false;
        }
        EstadisticaOrdenacion other = (EstadisticaOrdenacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.analisis.modelo.EstadisticaOrdenacion[ id=" + id + " ]";
    }
    
}
