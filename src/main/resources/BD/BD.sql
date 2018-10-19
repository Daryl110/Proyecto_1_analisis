DROP TABLE CANCION CASCADE CONSTRAINTS;
DROP TABLE ESTADISTICA_ESTRUCTURA CASCADE CONSTRAINTS;
DROP TABLE ESTADISTICA_ORDENACION CASCADE CONSTRAINTS;
DROP SEQUENCE ID;

CREATE TABLE CANCION (	
    ID NUMBER(38,0) PRIMARY KEY, 
    NOMBRE VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	DURACION NUMBER(38,0) NOT NULL ENABLE, 
	FECHA_LANZAMIENTO DATE NOT NULL ENABLE
);

CREATE SEQUENCE  
    ID  
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1;

CREATE TABLE ESTADISTICA_ESTRUCTURA (
    ID NUMBER(38,0) PRIMARY KEY,
    TIPO_DATO VARCHAR(20),
    TIPO_ESTRUCTURA VARCHAR(20),
    NUMERO_CANCIONES NUMBER(38,0),
    TIEMPO NUMBER(38,0)
);

CREATE TABLE ESTADISTICA_ORDENACION (
    ID NUMBER(38,0) PRIMARY KEY,
    TIPO_TRANSACCION VARCHAR(20),
    TIPO_ORDENACION VARCHAR(20),
    NUMERO_CANCIONES NUMBER(38,0),
    TIEMPO NUMBER(38,0)
);