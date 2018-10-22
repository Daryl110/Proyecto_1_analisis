/*
 *  2018 Daryl Ospina
 */
package com.eam.analisis.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "CANCION")
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c")})
public class Cancion implements Serializable, Comparable<Cancion> {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "ID", strategy = GenerationType.AUTO)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DURACION")
    private BigInteger duracion;
    @Basic(optional = false)
    @Column(name = "FECHA_LANZAMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLanzamiento;

    public Cancion() {
    }

    public Cancion(BigDecimal id) {
        this.id = id;
    }

    public Cancion(BigDecimal id, String nombre, BigInteger duracion, Date fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Cancion(String nombre, BigInteger duracion, Date fechaLanzamiento) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getDuracion() {
        return duracion;
    }

    public void setDuracion(BigInteger duracion) {
        this.duracion = duracion;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
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
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre: " + nombre + " Duracion: " + duracion + " Fecha lanzamiento: " + fechaLanzamiento + "";
    }

    @Override
    public int compareTo(Cancion cancion) {
        int a = Integer.parseInt((this.id + ""));
        int b = Integer.parseInt((cancion.getId() + ""));
        if (a==b) {
            return 0;
        }
        if (a>b) {
            return 1;
        }else{
            return -1;
        }
    }

}
