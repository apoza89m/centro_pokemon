#Algunas pruebas para comprobar que la bbdd funciona correctamente 

USE ambulaPokemon;
-- Mostrar todos los entrenadores con su pokedex y depot
SELECT entrenador.id, entrenador.genero, entrenador.numMedallas, entrenador.saldo, 
       entrenador.pokedex AS 'Pokedex', entrenador.depot AS 'Depot'
FROM entrenador ;

-- Mostrar todos los Pokémon en el depot de un entrenador específico (por ejemplo, el entrenador con id = 1)
SELECT entrenador.id, entrenador.genero, entrenador.numMedallas, entrenador.saldo, 
       pokemon.id_poke, pokemon.nombre, pokemon.tipo, pokemon.vida, pokemon.estado
FROM entrenador 
JOIN pokemon  ON JSON_CONTAINS(entrenador.depot, CAST(CONCAT('{"nombre": "', pokemon.nombre, '"}') AS JSON))
WHERE entrenador.id = 2;

-- Mostrar los Pokémon en la pokedex de un entrenador específico (por ejemplo, el entrenador con id = 1)
SELECT entrenador.id, entrenador.genero, entrenador.numMedallas, entrenador.saldo, 
       pokemon.id_poke, pokemon.nombre, pokemon.tipo, pokemon.vida, pokemon.estado
FROM entrenador 
JOIN pokemon  ON JSON_CONTAINS(entrenador.pokedex, CAST(CONCAT('{"nombre": "', pokemon.nombre, '"}') AS JSON))
WHERE entrenador.id = 1;

-- Mostrar el inventario de todas las enfermeras
SELECT inventario
FROM enfermera;


