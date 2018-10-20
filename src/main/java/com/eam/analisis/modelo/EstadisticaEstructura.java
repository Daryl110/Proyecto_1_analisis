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
@Table(name = "ESTADISTICA_ESTRUCTURA")
@NamedQueries({
    @NamedQuery(name = "EstadisticaEstructura.findAll", query = "SELECT e FROM EstadisticaEstructura e")
    , @NamedQuery(name = "EstadisticaEstructura.findById", query = "SELECT e FROM EstadisticaEstructura e WHERE e.id = :id")
    , @NamedQuery(name = "EstadisticaEstructura.findByTipoDato", query = "SELECT e FROM EstadisticaEstructura e WHERE e.tipoDato = :tipoDato")
    , @NamedQuery(name = "EstadisticaEstructura.findByTipoEstructura", query = "SELECT e FROM EstadisticaEstructura e WHERE e.tipoEstructura = :tipoEstructura")
    , @NamedQuery(name = "EstadisticaEstructura.findByNumeroCanciones", query = "SELECT e FROM EstadisticaEstructura e WHERE e.numeroCanciones = :numeroCanciones")
    , @NamedQuery(name = "EstadisticaEstructura.findByTiempo", query = "SELECT e FROM EstadisticaEstructura e WHERE e.tiempo = :tiempo")})
public class EstadisticaEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TIPO_DATO")
    private String tipoDato;
    @Column(name = "TIPO_ESTRUCTURA")
    private String tipoEstructura;
    @Column(name = "NUMERO_CANCIONES")
    private BigInteger numeroCanciones;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;

    public EstadisticaEstructura() {
    }

    public EstadisticaEstructura(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaEstructura)) {
            return false;
        }
        EstadisticaEstructura other = (EstadisticaEstructura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.analisis.modelo.EstadisticaEstructura[ id=" + id + " ]";
    }
    
}
