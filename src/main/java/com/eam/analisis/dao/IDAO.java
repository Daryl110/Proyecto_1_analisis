/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daryl Ospina
 */
public interface IDAO<T> {
    
    public abstract Object cargar(String nombreClase,String campos);
    public abstract List cargar(String nombreClase);
    public abstract Response guardar(Object objeto);
    public abstract Response modificar(Object objeto);
    public abstract Object buscar(Object valorId,Class<T> clase);
    public abstract Response eliminar(Object valorId,Class<T> clase);
    public abstract EntityManagerFactory getEntityManagerFactory();
    public abstract void setEntityManager(EntityManagerFactory entityManager);
    public abstract List cargarConsulta(String query,Class<T> clase);
}
