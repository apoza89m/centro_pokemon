#Grupo 4
# Creación de la base de datos
DROP DATABASE IF EXISTS ambulaPokemon;
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
    inventario JSON,
	FOREIGN KEY (id) REFERENCES persona(id)
);

-- Creación de la tabla entrenador
CREATE TABLE entrenador (
    id INT AUTO_INCREMENT PRIMARY KEY,
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

CREATE TABLE tratamiento (
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    diagnostico VARCHAR(100),
    fecha_alta DATE,
    fecha_baja DATE,
    costo DOUBLE,
    id_poke int,
    id_enfermera int,
    FOREIGN KEY (id_poke) REFERENCES pokemon(id_poke),
    FOREIGN KEY (id_enfermera) REFERENCES enfermera(id)
);

-- Inserción de datos en la tabla persona
INSERT INTO persona (nombre, genero) VALUES ('Ash Ketchum', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Misty', 'm');

-- Inserción de datos en la tabla enfermera
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 10, "Antídotos": 5}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 8, "Antídotos": 3}');

-- Inserción de datos en la tabla entrenador
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (8, '{"Pikachu": "Capturado", "Bulbasaur": "Capturado"}', '{"Pociones": 3, "Antídotos": 2}', 500);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (3, '{"Charmander": "Capturado", "Squirtle": "Capturado"}', '{"Pociones": 2, "Antídotos": 1}', 300);

-- Inserción de datos en la tabla centro
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Verde', 'Ciudad Verde', 10000.50, 1);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Celeste', 'Ciudad Celeste', 8000.75, 2);

-- Inserción de datos en la tabla pokemon
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Pikachu', 6.0, 0.4, 'Eléctrico', 100, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Bulbasaur', 6.9, 0.7, 'Planta/Veneno', 120, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Charmander', 8.5, 0.6, 'Fuego', 110, 'Enfermo');

-- Inserción de datos en la tabla tratamiento
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Fiebre', '2024-04-25', '2024-05-02', 50.00, 3, 1);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Intoxicación', '2024-04-25', '2024-05-01', 30.00, 2, 2);

-- Inserciones para la tabla persona
INSERT INTO persona (nombre, genero) VALUES ('Red', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Blue', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Leaf', 'm');
INSERT INTO persona (nombre, genero) VALUES ('Erika', 'm');
INSERT INTO persona (nombre, genero) VALUES ('Brock', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Lt. Surge', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Sabrina', 'm');
INSERT INTO persona (nombre, genero) VALUES ('Giovanni', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Morty', 'h');
INSERT INTO persona (nombre, genero) VALUES ('Whitney', 'm');

-- Inserciones para la tabla enfermera
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 20, "Antídotos": 10}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 15, "Antídotos": 8}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 25, "Antídotos": 12}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 18, "Antídotos": 9}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 22, "Antídotos": 11}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 30, "Antídotos": 15}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 28, "Antídotos": 14}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 35, "Antídotos": 18}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 40, "Antídotos": 20}');
INSERT INTO enfermera (inventario) VALUES ('{"Pociones": 33, "Antídotos": 16}');

-- Inserciones para la tabla entrenador
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (4, '{"Squirtle": "Capturado", "Charmander": "Capturado"}', '{"Pociones": 5, "Antídotos": 2}', 800);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (6, '{"Bulbasaur": "Capturado", "Pikachu": "Capturado"}', '{"Pociones": 7, "Antídotos": 3}', 1200);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (2, '{"Squirtle": "Capturado", "Pidgey": "Capturado"}', '{"Pociones": 3, "Antídotos": 1}', 500);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (8, '{"Charmander": "Capturado", "Squirtle": "Capturado"}', '{"Pociones": 4, "Antídotos": 2}', 1500);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (3, '{"Pidgeotto": "Capturado", "Geodude": "Capturado"}', '{"Pociones": 2, "Antídotos": 1}', 300);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (5, '{"Spearow": "Capturado", "Ekans": "Capturado"}', '{"Pociones": 6, "Antídotos": 3}', 1000);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (7, '{"Vulpix": "Capturado", "Nidoran": "Capturado"}', '{"Pociones": 8, "Antídotos": 4}', 1800);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (1, '{"Caterpie": "Capturado", "Metapod": "Capturado"}', '{"Pociones": 1, "Antídotos": 1}', 200);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (9, '{"Drowzee": "Capturado", "Hypno": "Capturado"}', '{"Pociones": 10, "Antídotos": 5}', 2200);
INSERT INTO entrenador (numMedallas, pokedex, depot, saldo) VALUES (10, '{"Zubat": "Capturado", "Golbat": "Capturado"}', '{"Pociones": 12, "Antídotos": 6}', 2500);

-- Inserciones para la tabla centro
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Plateada', 'Ciudad Plateada', 15000.75, 3);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Carmín', 'Ciudad Carmín', 18000.50, 4);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Celeste', 'Ciudad Celeste', 20000.25, 5);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Azafrán', 'Ciudad Azafrán', 22000.00, 6);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Fucsia', 'Ciudad Fucsia', 25000.00, 7);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Verde', 'Ciudad Verde', 27000.00, 8);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Plateada', 'Ciudad Plateada', 30000.00, 9);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Plateada', 'Ciudad Plateada', 32000.00, 10);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Plateada', 'Ciudad Plateada', 35000.00, 11);
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES ('Centro Pokémon de Ciudad Plateada', 'Ciudad Plateada', 37000.00, 12);

-- Inserciones para la tabla pokemon
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Squirtle', 9.0, 0.5, 'Agua', 110, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Charmander', 8.5, 0.6, 'Fuego', 100, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Bulbasaur', 6.9, 0.7, 'Planta/Veneno', 120, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Pidgey', 1.8, 0.3, 'Normal/Volador', 90, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Ekans', 6.9, 2.0, 'Veneno', 100, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Pikachu', 6.0, 0.4, 'Eléctrico', 100, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Meowth', 4.2, 0.4, 'Normal', 95, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Psyduck', 19.6, 0.8, 'Agua', 120, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Growlithe', 19.0, 0.7, 'Fuego', 110, 'Saludable');
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado) VALUES ('Geodude', 20.0, 0.4, 'Roca/Tierra', 130, 'Saludable');

-- Inserciones para la tabla tratamiento
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Fiebre', '2024-04-15', '2024-04-25', 50.00, 1, 1);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Envenenamiento', '2024-04-16', '2024-04-28', 70.00, 2, 2);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Parálisis', '2024-04-17', '2024-04-26', 60.00, 3, 3);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Quemadura', '2024-04-18', '2024-04-29', 80.00, 4, 4);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Congestión', '2024-04-19', '2024-04-30', 90.00, 5, 5);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Hipotermia', '2024-04-20', '2024-05-01', 100.00, 6, 6);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Desgarro muscular', '2024-04-21', '2024-05-02', 110.00, 7, 7);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Insomnio', '2024-04-22', '2024-05-03', 120.00, 8, 8);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Gripe', '2024-04-23', '2024-05-04', 130.00, 9, 9);
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES ('Esguince', '2024-04-24', '2024-05-05', 140.00, 10, 10);

