package com.eam.analisis.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Alvaro Corrales
 */
public class Conexion {
    
	private EntityManagerFactory factory;
        
        public Conexion(String unidad){
            factory = Persistence.createEntityManagerFactory(unidad);
        }

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
}
