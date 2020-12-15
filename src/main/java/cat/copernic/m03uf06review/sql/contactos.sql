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
    id_org INT,
    PRIMARY KEY(id_persona)
);

CREATE TABLE organizacion(
	id_org INT AUTO_INCREMENT,
    nombre_grupo VARCHAR(30),
    descripcion VARCHAR(300),
    PRIMARY KEY(id_org)
);

ALTER TABLE persona ADD CONSTRAINT fkpersona_idorg FOREIGN KEY (id_org) REFERENCES organizacion(id_org);

INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Xavier','Luna Boncompte','C/ Nuria',08224,'Terrassa', 181.3, false, '2000-06-18');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Eloi','Ruiz','C/Major',08232,'Viladecavalls', 179.8, false, '2000-08-21');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Mario','Garcia','C/Sicilia',08224,'Terrassa', 173.1, true, '2001-12-19');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Maria','Fernandez','C/Llevant',08232,'Viladecavalls', 167.8, true, '2000-03-27');
INSERT INTO personas (nombre, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento) VALUES('Gerard','Hernandez','C/Sicilia',08224,'Terrassa', 167.8, true, '2001-10-25');

INSERT INTO organizacion (nombre_grupo, descripcion) VALUES('Greenpeace','Define su objetivo como la protección del medio ambiente y la paz mundial.');

INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento, id_org) VALUES('Xavier','Luna Boncompte','C/ Nuria',08224,'Terrassa', 181.3, false, '2000-06-18', 1);
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento, id_org) VALUES('Eloi','Ruiz','C/Major',08232,'Viladecavalls', 179.8, false, '2000-08-21', 1);
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento, id_org) VALUES('Mario','Garcia','C/Sicilia',08224,'Terrassa', 173.1, true, '2001-12-19', 1);
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento, id_org) VALUES('Maria','Fernandez','C/Llevant',08232,'Viladecavalls', 167.8, true, '2000-03-27', 1);
INSERT INTO persona (nombre_persona, apellidos, direccion, codigo_postal, ciudad, altura, fumador, fecha_nacimiento, id_org) VALUES('Gerard','Hernandez','C/Sicilia',08224,'Terrassa', 167.8, true, '2001-10-25', 1);

SELECT * FROM personas;
SELECT * FROM persona;
SELECT * FROM organizacion;