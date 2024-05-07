#Grupo 4
# Creación de la base de datos
DROP DATABASE IF EXISTS ambulapokemon;
CREATE DATABASE IF NOT EXISTS ambulapokemon;

-- Selección de la base de datos
USE ambulapokemon;

-- Creación de la tabla persona
CREATE TABLE persona (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    genero ENUM('h', 'm')
);

-- Creación de la tabla enfermera
CREATE TABLE enfermera (
    id INT PRIMARY KEY,
    num_pokemon_tratados INT,
	FOREIGN KEY (id) REFERENCES persona(id)
);

-- Creación de la tabla entrenador
CREATE TABLE entrenador (
    id INT PRIMARY KEY,
    num_medallas INT,
    saldo DOUBLE,
    FOREIGN KEY (id) REFERENCES persona(id)
);

-- Creación de la tabla centro
CREATE TABLE centro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    localidad VARCHAR(100),
    presupuesto DOUBLE,
    trabajador INT,
    FOREIGN KEY (trabajador) REFERENCES enfermera(id)
);

-- Creación de la tabla pokemon
CREATE TABLE pokemon (
    id_poke INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    peso DOUBLE,
    altura DOUBLE,
    tipo VARCHAR(100),
    vida INT,
    estado VARCHAR(100),
    id_entrenador INT,
    FOREIGN KEY (id_entrenador) REFERENCES entrenador(id)
    
);

CREATE TABLE tratamiento (
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    diagnostico VARCHAR(100),
    fecha_alta DATE,
    fecha_baja DATE,
    costo DOUBLE,
    id_poke INT,
    id_enfermera INT,
    FOREIGN KEY (id_poke) REFERENCES pokemon(id_poke),
    FOREIGN KEY (id_enfermera) REFERENCES enfermera(id)
);

-- Inserción en la tabla persona
INSERT INTO persona (id, nombre, genero)
VALUES
    (1, 'Nurse Joy 1', 'm'),
    (2, 'Nurse Joy 2', 'm'),
    (3, 'Nurse Joy 3', 'm'),
	(4, 'Roberto', 'h'),
    (5, 'Pepe', 'h'),
    (6, 'Jesús', 'h'),
    (7, 'Mar', 'm');
    

-- Inserción en la tabla enfermera
INSERT INTO enfermera (id, num_pokemon_tratados)
VALUES
    (1, 10),
    (2, 5),
    (3, 0);

-- Inserción en la tabla entrenador
INSERT INTO entrenador (id, num_medallas, saldo)
VALUES
    (4, 8, 1000),
    (5, 1, 500),
    (6, 3, 500),
    (7, 2, 750);

-- Inserción en la tabla centro
INSERT INTO centro (nombre, localidad, presupuesto, trabajador)
VALUES
    ('Centro Pokémon Pueblo Paleta', 'Pueblo Paleta', 5000, 1),
    ('Centro Pokémon Ciudad Celeste', 'Ciudad Celeste', 7500, 1);

-- Inserción en la tabla pokemon
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado, id_entrenador)
VALUES
    ('Pikachu', 6.0, 0.4, 'Eléctrico', 35, 'Saludable', 5),
    ('Bulbasaur', 6.9, 0.7, 'Planta/Veneno', 45, 'Envenenado', 4),
    ('Charmander', 8.5, 0.6, 'Fuego', 39, 'Quemado', 4),
    ('Squirtle', 9.0, 0.5, 'Agua', 44, 'Dormido', 6),
    ('Psyduck', 19.6, 0.8, 'Agua', 50, 'Confundido', 6),
    ('Starmie', 80.0, 1.1, 'Agua/Psíquico', 60, 'Saludable', 7),
    ('Geodude', 20.0, 0.4, 'Roca/Tierra', 40, 'Saludable', 7),
    ('Onix', 210.0, 8.8, 'Roca/Tierra', 35, 'Herido', 4);

-- Inserción en la tabla tratamiento
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera)
VALUES
    ('Parálisis', '2024-05-01', '2024-05-05', 100.0, 1, 1),
    ('Envenenamiento', '2024-05-02', '2024-05-07', 150.0, 2, 1),
    ('Quemadura', '2024-05-03', '2024-05-08', 120.0, 3, 1),
    ('Insomnio', '2024-05-04', '2024-05-09', 80.0, 4, 2),
    ('Confusión', '2024-05-05', '2024-05-10', 90.0, 5, 2),
    ('Saludable', '2024-05-06', '2024-05-11', 50.0, 6, 2),
    ('Parálisis', '2024-05-07', '2024-05-12', 100.0, 7, 2),
    ('Herido', '2024-05-08', '2024-05-13', 200.0, 8, 1);


