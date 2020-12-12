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

CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT,
    nombre_persona VARCHAR(30),
    apellidos VARCHAR(30),
    direccion CHAR(60),
    codigo_postal INT,
    ciudad VARCHAR(30),
    altura DOUBLE,
    fumador BOOLEAN,
    fecha_nacimiento DATE,
    PRIMARY KEY(id_persona)
);

CREATE TABLE organizacion(
	id_org INT AUTO_INCREMENT,
    nombre_grupo VARCHAR(30),
    descripcion VARCHAR(300),
    id_persona1 INT,
    id_persona2 INT,
    id_persona3 INT,
    PRIMARY KEY(id_org)
);

ALTER TABLE organizacion ADD CONSTRAINT fk_org_idpersona1 FOREIGN KEY (id_persona1) REFERENCES persona(id_persona);
ALTER TABLE organizacion ADD CONSTRAINT fk_org_idpersona2 FOREIGN KEY (id_persona2) REFERENCES persona(id_persona);
ALTER TABLE organizacion ADD CONSTRAINT fk_org_idpersona3 FOREIGN KEY (id_persona3) REFERENCES persona(id_persona);

INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Xavier','Luna Boncompte','C/ Nuria',08224,'Terrassa', 181.3, false, '2000-06-18');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Eloi','Ruiz','C/Major',08232,'Viladecavalls', 179.8, false, '2000-08-21');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Mario','Garcia','C/Sicilia',08224,'Terrassa', 173.1, true, '2001-12-19');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Maria','Fernandez','C/Llevant',08232,'Viladecavalls', 167.8, true, '2000-03-27');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Gerard','Hernandez','C/Sicilia',08224,'Terrassa', 167.8, true, '2001-10-25');

INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Xavier','Luna Boncompte','C/ Nuria',08224,'Terrassa', 181.3, false, '2000-06-18');
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Eloi','Ruiz','C/Major',08232,'Viladecavalls', 179.8, false, '2000-08-21');
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Mario','Garcia','C/Sicilia',08224,'Terrassa', 173.1, true, '2001-12-19');
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Maria','Fernandez','C/Llevant',08232,'Viladecavalls', 167.8, true, '2000-03-27');
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Gerard','Hernandez','C/Sicilia',08224,'Terrassa', 167.8, true, '2001-10-25');

INSERT INTO organizacion (nombre_grupo, descripcion, id_persona1, id_persona2, id_persona3) VALUES('Greenpeace','Define su objetivo como la protección del medio ambiente y la paz mundial.', '1', '2', '3');

SELECT * FROM personas;
SELECT * FROM persona;
SELECT * FROM organizacion;