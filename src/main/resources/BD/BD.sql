DROP TRIGGER TRIGER_INCREMENT;
-- Drops
DROP TABLE CANCION CASCADE CONSTRAINTS;
DROP TABLE ESTADISTICA_ESTRUCTURA CASCADE CONSTRAINTS;
DROP TABLE ESTADISTICA_ORDENACION CASCADE CONSTRAINTS;
DROP SEQUENCE ID;
DROP SEQUENCE ID_ESTRUCTURAS;
DROP SEQUENCE ID_ORDENACION;

-- Secuencias
CREATE SEQUENCE  
    ID  
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1;

CREATE SEQUENCE  
    ID_ESTRUCTURAS  
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1;

CREATE SEQUENCE  
    ID_ORDENACION  
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1;

-- Tablas
CREATE TABLE CANCION (	
    ID NUMBER(38,0) PRIMARY KEY, 
    NOMBRE VARCHAR2(20 BYTE) NOT NULL ENABLE, 
    DURACION NUMBER(38,0) NOT NULL ENABLE, 
    FECHA_LANZAMIENTO DATE NOT NULL ENABLE
);

CREATE TABLE ESTADISTICA_ESTRUCTURA (
    ID_ESTRUCTURAS NUMBER(38,0) PRIMARY KEY,
    TIPO_OPERACION VARCHAR(20),
    TIPO_ESTRUCTURA VARCHAR(20),
    NUMERO_CANCIONES NUMBER(38,0),
    TIEMPO NUMBER(38,0)
);

CREATE TABLE ESTADISTICA_ORDENACION (
    ID_ORDENACION NUMBER(38,0) PRIMARY KEY,
    TIPO_TRANSACCION VARCHAR(20),
    TIPO_ORDENACION VARCHAR(20),
    NUMERO_CANCIONES NUMBER(38,0),
    TIEMPO NUMBER(38,0)
);

-- Creacion de disparador para el id al momento de insertar
CREATE OR REPLACE TRIGGER TRIGER_INCREMENT 
    BEFORE INSERT ON CANCION
    FOR EACH ROW
    BEGIN
        SELECT ID.NEXTVAL
        INTO   :new.ID
        FROM   dual;
    END;

-- Sentencia PL/SQL para llenar BD Aleatoreamente
declare
    v_nombre CANCION.NOMBRE%TYPE;
    v_duracion CANCION.DURACION%TYPE;
    v_lanzamiento CANCION.FECHA_LANZAMIENTO%TYPE;
begin
    for i in 1..1000000 loop
        v_duracion:=DBMS_RANDOM.value(120,800);
        v_nombre:=DBMS_RANDOM.string('a',20);
        
            select to_date(
                TRUNC(
                    DBMS_RANDOM.value(to_char(date '1950-01-01','J'), to_char(date '2019-01-31','J'))
                ),'J'
            ) into v_lanzamiento from dual;
        insert into CANCION (NOMBRE, DURACION, FECHA_LANZAMIENTO)
        values (v_nombre, v_duracion, v_lanzamiento);
    end loop;
end;

-- Consulta pivot para obtener super tabla
SELECT * FROM
(
    SELECT EE.TIPO_OPERACION, EE.TIPO_ESTRUCTURA, TIEMPO FROM ESTADISTICA_ESTRUCTURA EE
)
PIVOT
(
    AVG(TIEMPO)
    FOR TIPO_ESTRUCTURA IN ('ListaSimple' AS "Lista Simple")
);