#Grupo 4
# Creación de la base de datos
CREATE DATABASE IF NOT EXISTS ambulaPokemon;

-- Selección de la base de datos
USE ambulaPokemon;

-- Creación de la tabla persona
CREATE TABLE persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    genero ENUM('h', 'm')
);

-- Creación de la tabla enfermera
CREATE TABLE enfermera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    genero ENUM('h', 'm'),
    inventario JSON
);

-- Creación de la tabla entrenador
CREATE TABLE entrenador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    genero ENUM('h', 'm'),
    numMedallas INT,
    pokedex JSON,
    depot JSON,
    saldo INT,
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
    estado VARCHAR(100)
);

-- Inserts para la tabla persona
INSERT INTO persona (nombre, genero) VALUES
('Ash Ketchum', 'h'),
('Misty', 'm'),
('Brock', 'h'),
('Profesor Oak', 'h'),
('Enfermera Joy', 'm');

-- Inserts para la tabla enfermera
INSERT INTO enfermera (nombre, genero, inventario) VALUES
('Enfermera Joy', 'm', '{"Pociones": 10, "Antídotos": 5, "Revivir": 3}'),
('Enfermera Jenny', 'm', '{"Pociones": 12, "Antídotos": 8, "Revivir": 4}'),
('Enfermera Diana', 'm', '{"Pociones": 15, "Antídotos": 10, "Revivir": 6}'),
('Enfermera Rosa', 'm', '{"Pociones": 8, "Antídotos": 3, "Revivir": 2}'),
('Enfermera Natalia', 'm', '{"Pociones": 20, "Antídotos": 15, "Revivir": 10}');

-- Inserts para la tabla entrenador
INSERT INTO entrenador (genero, numMedallas, pokedex, depot, saldo) 
VALUES 
('h', 8, '[{"nombre": "Bulbasaur", "nivel": 30}, {"nombre": "Charmander", "nivel": 25}]', 
        '[{"nombre": "Squirtle", "nivel": 20}, {"nombre": "Pikachu", "nivel": 15}]', 100),
('h', 3, '[{"nombre": "Squirtle", "nivel": 20}, {"nombre": "Pidgeotto", "nivel": 22}]', 
        '[{"nombre": "Bulbasaur", "nivel": 15}, {"nombre": "Charmander", "nivel": 18}]', 50),
('h', 6, '[{"nombre": "Bulbasaur", "nivel": 25}, {"nombre": "Squirtle", "nivel": 23}]', 
        '[{"nombre": "Pidgey", "nivel": 12}, {"nombre": "Rattata", "nivel": 10}]', 70),
('h', 0, '[]', '[]', 20),
('m', 0, '[]', '[]', 10);

-- Inserts para la tabla centro
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES
('Centro Pokémon Pueblo Paleta', 'Pueblo Paleta', 10000, 1),
('Centro Pokémon Ciudad Celeste', 'Ciudad Celeste', 12000, 2),
('Centro Pokémon Ciudad Plateada', 'Ciudad Plateada', 15000, 3),
('Centro Pokémon Ciudad Verde', 'Ciudad Verde', 8000, 4),
('Centro Pokémon Ciudad Carmín', 'Ciudad Carmín', 9000, 5);

-- Inserts para la tabla pokemon
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES
('Bulbasaur', 6.9, 0.7, 'Planta/Veneno', 45, 'vivo'),
('Charmander', 8.5, 0.6, 'Fuego', 39, 'vivo'),
('Squirtle', 9, 0.5, 'Agua', 44, 'vivo'),
('Pikachu', 6, 0.4, 'Eléctrico', 35, 'vivo'),
('Eevee', 6.5, 0.3, 'Normal', 55, 'vivo');


