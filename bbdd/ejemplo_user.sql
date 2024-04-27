use ambulapokemon;
DROP USER IF EXISTS 'robe'@'localhost';
CREATE USER 'robe'@'localhost' IDENTIFIED BY 'robe';
GRANT ALL PRIVILEGES ON ambulapokemon.* TO 'robe'@'localhost';
flush privileges;