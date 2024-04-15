-- BIBLIOTECA
DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca CHARACTER SET utf8mb4;
USE biblioteca;

-- Tabla de Autores
CREATE TABLE Autores (
    AutorID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100)
);

-- Tabla de Editoriales
CREATE TABLE Editoriales (
    EditorialID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Direccion VARCHAR(255),
    Ciudad VARCHAR(100),
    Pais VARCHAR(100)
);

-- Tabla de Categoria (NEW)
CREATE TABLE Categoria (
    CategoriaID INT PRIMARY KEY,
    Genero VARCHAR(255),
	Descripcion VARCHAR(255)
);

-- Tabla de Libros
CREATE TABLE Libros (
    LibroID INT PRIMARY KEY,
    Titulo VARCHAR(255),
    AutorID INT,
    EditorialID INT,
    CategoriaID INT,
    ISBN VARCHAR(20),
    AnioPublicacion INT,
    CantidadDisponible INT,
	FOREIGN KEY (AutorID) REFERENCES Autores(AutorID),
    FOREIGN KEY (EditorialID) REFERENCES Editoriales(EditorialID),
    FOREIGN KEY (CategoriaID) REFERENCES Categoria(CategoriaID)
);

-- Tabla de Usuarios
CREATE TABLE Usuarios (
    UsuarioID INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(255),
    Ciudad VARCHAR(100),
    Pais VARCHAR(100),
    Email VARCHAR(100)
);

-- Tabla de Préstamos
CREATE TABLE Prestamos (
    PrestamoID INT PRIMARY KEY,
    LibroID INT,
    UsuarioID INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    FOREIGN KEY (LibroID) REFERENCES Libros(LibroID),
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID)
);

-- Inserciones para la tabla de Autores
INSERT INTO Autores (AutorID, Nombre, Apellido)
VALUES
    (1, 'Gabriel', 'García Márquez'),
    (2, 'Mario', 'Vargas Llosa'),
    (3, 'Julio', 'Cortázar');

-- Inserciones para la tabla de Editoriales
INSERT INTO Editoriales (EditorialID, Nombre, Direccion, Ciudad, Pais)
VALUES
    (1, 'Editorial Alfaguara', 'Calle Principal 123', 'Madrid', 'España'),
    (2, 'Editorial Planeta', 'Avenida Central 456', 'Buenos Aires', 'Argentina'),
    (3, 'Editorial Anagrama', 'Rua Principal 789', 'Barcelona', 'España');

-- Inserciones para la tabla de Categoria (NEW)
INSERT INTO Categoria (CategoriaID, Genero, Descripcion)
VALUES
    (1, 'Literatura', 'Cuentos, poemarios y novelas'),
    (2, 'Artistico', 'Catálogos de museo y libros de fotografía'),
	(3, 'Práctico', 'Recetarios, instructivos y manuales'),
	(4, 'Religioso', 'Libros de oración o de catequesis'),
    (5, 'Infantil', 'Para aprender a leer o para bebes');

-- Inserciones para la tabla de Libros
INSERT INTO Libros (LibroID, Titulo, AutorID, EditorialID, CategoriaID, ISBN, AnioPublicacion, CantidadDisponible)
VALUES
    (1, 'Cien años de soledad', 1, 1, 1, '978-84-204-8775-7', 1967, 50),
    (2, 'La ciudad y los perros', 2, 2, 2, '978-84-322-0138-8', 1962, 40),
    (3, 'Rayuela', 3, 3, 3, '978-84-339-2248-4', 1963, 30);

-- Inserciones para la tabla de Usuarios
INSERT INTO Usuarios (UsuarioID, Nombre, Apellido, Direccion, Ciudad, Pais, Email)
VALUES
    (1, 'Juan', 'Pérez', 'Calle Principal 123', 'Ciudad de México', 'México', 'juan@example.com'),
    (2, 'María', 'García', 'Avenida Central 456', 'Madrid', 'España', 'maria@example.com'),
    (3, 'Pedro', 'López', 'Rua Principal 789', 'Lisboa', 'Portugal', 'pedro@example.com');

-- Inserciones para la tabla de Préstamos
INSERT INTO Prestamos (PrestamoID, LibroID, UsuarioID, FechaPrestamo, FechaDevolucion)
VALUES
    (1, 1, 1, '2023-01-10', '2023-01-20'),
    (2, 2, 2, '2023-02-15', '2023-02-25'),
    (3, 3, 3, '2023-03-20', '2023-03-30');

-- Inserciones adicionales para la tabla de Autores
INSERT INTO Autores (AutorID, Nombre, Apellido)
VALUES
    (4, 'Isabel', 'Allende'),
    (5, 'Jorge', 'Borges'),
    (6, 'Paulo', 'Coelho');

-- Inserciones adicionales para la tabla de Editoriales
INSERT INTO Editoriales (EditorialID, Nombre, Direccion, Ciudad, Pais)
VALUES
    (4, 'Editorial Tusquets', 'Calle Mayor 789', 'Barcelona', 'España'),
    (5, 'Editorial Random House', 'Broadway 123', 'New York', 'Estados Unidos'),
    (6, 'Editorial HarperCollins', 'Fleet Street 456', 'Londres', 'Reino Unido');

-- Inserciones adicionales para la tabla de Libros
INSERT INTO Libros (LibroID, Titulo, AutorID, EditorialID, CategoriaID, ISBN, AnioPublicacion, CantidadDisponible)
VALUES
    (4, 'La casa de los espíritus', 4, 4, 4, '978-84-306-0109-6', 1982, 60),
    (5, 'Ficciones', 5, 5, 5, '978-84-8376-900-5', 1944, 70),
    (6, 'El Alquimista', 6, 6, 5, '978-84-08-13548-5', 1988, 80);

-- Inserciones adicionales para la tabla de Usuarios
INSERT INTO Usuarios (UsuarioID, Nombre, Apellido, Direccion, Ciudad, Pais, Email)
VALUES
    (4, 'Laura', 'Rodríguez', '123 Elm Street', 'Los Angeles', 'Estados Unidos', 'laura@example.com'),
    (5, 'Diego', 'Martín', '456 Maple Avenue', 'Toronto', 'Canadá', 'diego@example.com'),
    (6, 'Andrea', 'López', '789 Oak Drive', 'Sídney', 'Australia', 'andrea@example.com');

-- Inserciones adicionales para la tabla de Préstamos
INSERT INTO Prestamos (PrestamoID, LibroID, UsuarioID, FechaPrestamo, FechaDevolucion)
VALUES
    (4, 4, 4, '2023-04-05', '2023-04-15'),
    (5, 5, 5, '2023-05-10', '2023-05-20'),
    (6, 6, 6, '2023-06-15', '2023-06-25');
