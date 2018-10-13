/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.analisis.util;

import java.util.Base64;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daryl Ospina
 */
public abstract class Herramientas {

    public static Response construirResponse(Object respuesta) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(respuesta)
                .build();
    }
    
    public static String decodoficar(String texto){
        return new String(Base64.getDecoder().decode(texto.getBytes()));
    }
}
