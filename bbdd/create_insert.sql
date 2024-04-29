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
    inventario JSON,
	FOREIGN KEY (id) REFERENCES persona(id)
);

-- Creación de la tabla entrenador
CREATE TABLE entrenador (
    id INT PRIMARY KEY,
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

-- Inserts para la tabla persona
-- Inserts para la tabla persona
INSERT INTO persona (id, nombre, genero) VALUES
(1,'Joy1', 'm'),
(2,'Joy2', 'm'),
(3,'Joy3', 'm'),
(4,'Roberto','h'),
(5,'Jesus','h'),
(6,'Mar','m'),
(7,'Pepe','h');

-- Inserts para la tabla enfermera
INSERT INTO enfermera (id,inventario) VALUES
(1,'{"pociones": 10, "antídotos": 5, "vendas": 20}'),
(2,'{"pociones": 15, "antídotos": 8, "vendas": 25}'),
(3,'{"pociones": 12, "antídotos": 6, "vendas": 22}');

-- Inserts para la tabla entrenador
INSERT INTO entrenador (id, numMedallas, pokedex, depot, saldo) VALUES
(4, 8, '{"pokemonesCapturados": []}', '[{"nombre": "Pikachu", "peso": 6, "altura": 0.4, "tipo": "Eléctrico", "vida": 35, "estado": "Saludable"}, {"nombre": "Bulbasaur", "peso": 6.9, "altura": 0.7, "tipo": "Planta/Veneno", "vida": 45, "estado": "Saludable"}]', 1000),
(5, 3, '{"pokemonesCapturados": []}', '[{"nombre": "Squirtle", "peso": 9, "altura": 0.5, "tipo": "Agua", "vida": 44, "estado": "Saludable"}, {"nombre": "Vulpix", "peso": 9.9, "altura": 0.6, "tipo": "Fuego", "vida": 38, "estado": "Saludable"}]', 800),
(6, 6, '{"pokemonesCapturados": []}', '[{"nombre": "Geodude", "peso": 20, "altura": 0.4, "tipo": "Roca/Tierra", "vida": 40, "estado": "Saludable"}, {"nombre": "Onix", "peso": 210, "altura": 8.8, "tipo": "Roca/Tierra", "vida": 35, "estado": "Saludable"}]', 1200),
(7, 6, '{"pokemonesCapturados": []}', '[{"nombre": "Rattata", "peso": 20, "altura": 0.4, "tipo": "Roca/Tierra", "vida": 40, "estado": "Saludable"}, {"nombre": "Onix", "peso": 210, "altura": 8.8, "tipo": "Roca/Tierra", "vida": 35, "estado": "Saludable"}]', 1200);


-- Inserts para la tabla pokemon
INSERT INTO pokemon (nombre, peso, altura, tipo, vida, estado, id_entrenador) VALUES
('Pikachu', 6, 0.4, 'Eléctrico', 35, 'Saludable', 4),
('Bulbasaur', 6.9, 0.7, 'Planta/Veneno', 45, 'Saludable', 4),
('Charmander', 8.5, 0.6, 'Fuego', 39, 'Saludable', 4),
('Squirtle', 9, 0.5, 'Agua', 44, 'Saludable', 5),
('Vulpix', 9.9, 0.6, 'Fuego', 38, 'Saludable', 5),
('Psyduck', 19.6, 0.8, 'Agua', 50, 'Saludable', 5),
('Geodude', 20, 0.4, 'Roca/Tierra', 40, 'Saludable', 6),
('Onix', 210, 8.8, 'Roca/Tierra', 35, 'Saludable', 6),
('Staryu', 34.5, 0.8, 'Agua', 30, 'Saludable', 6),
('Jigglypuff', 5.5, 0.5, 'Normal/Hada', 115, 'Saludable', 7),
('Meowth', 4.2, 0.4, 'Normal', 40, 'Saludable', 7),
('Machop', 19.5, 0.8, 'Lucha', 70, 'Saludable', 7),
('Abra', 19.5, 0.9, 'Psíquico', 25, 'Saludable', 7),
('Pidgey', 1.8, 0.3, 'Normal/Volador', 40, 'Saludable', 7),
('Nidoran', 9, 0.4, 'Veneno', 55, 'Saludable', 4),
('Clefairy', 7.5, 0.6, 'Normal', 70, 'Saludable', 4),
('Sandshrew', 12, 0.6, 'Tierra', 50, 'Saludable', 4),
('Sandslash', 29.5, 1, 'Tierra', 75, 'Saludable', 4),
('Clefable', 40, 1.3, 'Normal', 95, 'Saludable', 4),
('Nidorina', 20, 0.8, 'Veneno', 70, 'Saludable', 5),
('Nidorino', 19.5, 0.9, 'Veneno', 61, 'Saludable', 5),
('Clefable', 40, 1.3, 'Normal', 95, 'Saludable', 5),
('Wigglytuff', 12, 1, 'Normal/Hada', 140, 'Saludable', 5),
('Zubat', 7.5, 0.8, 'Veneno/Volador', 40, 'Saludable', 6),
('Vulpix', 9.9, 0.6, 'Fuego', 38, 'Saludable', 6),
('Oddish', 5.4, 0.5, 'Planta/Veneno', 45, 'Saludable', 6),
('Gloom', 8.6, 0.8, 'Planta/Veneno', 60, 'Saludable', 7),
('Vileplume', 18.6, 1.2, 'Planta/Veneno', 75, 'Saludable', 7);


-- Inserts para la tabla centro
INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES
('Centro Pokémon Pueblo Paleta', 'Pueblo Paleta', 10000, 1),
('Centro Pokémon Ciudad Plateada', 'Ciudad Plateada', 12000, 2),
('Centro Pokémon Ciudad Celeste', 'Ciudad Celeste', 15000, 3);


-- Inserts para la tabla tratamiento
INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES
('Parálisis temporal', '2024-04-15', '2024-04-20', 50, 1, 1),
('Intoxicación por veneno', '2024-04-16', '2024-04-21', 40, 2, 2),
('Quemaduras leves', '2024-04-17', '2024-04-22', 30, 3, 3),
('Golpe severo', '2024-04-18', '2024-04-23', 60, 4, 1),
('Confusión', '2024-04-19', '2024-04-24', 70, 5, 2),
('Parálisis temporal', '2024-04-20', '2024-04-25', 50, 6, 3),
('Intoxicación por veneno', '2024-04-21', '2024-04-26', 40, 7, 1),
('Quemaduras leves', '2024-04-22', '2024-04-27', 30, 8, 2),
('Golpe severo', '2024-04-23', '2024-04-28', 60, 9, 3),
('Confusión', '2024-04-24', '2024-04-29', 70, 10, 1),
('Parálisis temporal', '2024-04-25', '2024-04-30', 50, 11, 2),
('Intoxicación por veneno', '2024-04-26', '2024-05-01', 40, 12, 3),
('Quemaduras leves', '2024-04-27', '2024-05-02', 30, 13, 1),
('Golpe severo', '2024-04-28', '2024-05-03', 60, 14, 2),
('Confusión', '2024-04-29', '2024-05-04', 70, 15, 3),
('Parálisis temporal', '2024-04-30', '2024-05-05', 50, 16, 1),
('Intoxicación por veneno', '2024-05-01', '2024-05-06', 40, 17, 2),
('Quemaduras leves', '2024-05-02', '2024-05-07', 30, 18, 3),
('Golpe severo', '2024-05-03', '2024-05-08', 60, 19, 1);


