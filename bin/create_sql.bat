@echo off

set "DBUSERNAME=root"
set "USERPASSWD=''"
set "DBNAME=ambulapokemon"

mysql -u%DBUSERNAME% -p%USERPASSWD% -D%DBNAME% < "..\bbdd\create_db.sql"

pause