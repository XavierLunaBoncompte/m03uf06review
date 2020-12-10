DROP DATABASE IF EXISTS contactos;
CREATE DATABASE contactos;
DROP USER IF EXISTS administrador;
CREATE USER administrador IDENTIFIED BY 'admin_contactos';
GRANT ALL PRIVILEGES ON contactos.* TO administrador WITH GRANT OPTION;
USE contactos;

CREATE TABLE personas(
    id_persona INT AUTO_INCREMENT,
    nombre VARCHAR(30),
    apellidos VARCHAR(30),
    direccion CHAR(60),
    codigo_postal INT,
    ciudad VARCHAR(30),
    altura DOUBLE,
    fumador BOOLEAN,
    fecha_nacimiento DATE,
    PRIMARY KEY(id_persona)
);

CREATE TABLE grupodetrabajo(
	id_grupo INT AUTO_INCREMENT,
    numero_grupo INT,
    sector VARCHAR(30),
    id_persona INT,
    PRIMARY KEY(id_grupo)
);

ALTER TABLE grupodetrabajo ADD CONSTRAINT fk_grupodetrabjao_idpersona FOREIGN KEY (id_persona) REFERENCES personas(id_persona);

INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Xaver','Luna Boncompte','C/ Nuria',08224,'Terrassa', 181.3, false, '2000-06-18');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Eloi','Ruiz','C/Major',08232,'Viladecavalls', 179.8, false, '2000-08-21');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Mario','Garcia','C/Sicilia',08224,'Terrassa', 173.1, true, '2001-12-19');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Maria','Fernandez','C/Llevant',08232,'Viladecavalls', 167.8, true, '2000-03-27');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Gerard','Hernandez','C/Sicilia',08224,'Terrassa', 167.8, true, '2001-10-25');

INSERT INTO grupodetrabajo (numero_grupo, sector, id_persona) VALUES(1,'Mysql',2);

SELECT * FROM personas;
SELECT * FROM grupodetrabajo;