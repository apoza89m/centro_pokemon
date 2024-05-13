@echo off

set "mysql_path=C:\xampp\mysql\bin"

REM Comprobamos si la ruta ya está en el PATH
echo %PATH% | findstr /i /c:"%mysql_path%" >nul
if %errorlevel% neq 0 (
    REM Agregar la ruta de MySQL al PATH
    setx PATH "%PATH%;%mysql_path%" /m
    echo Ruta de MySQL agregada al entorno PATH.
) else (
    echo La ruta de MySQL ya está en el entorno PATH.
)

pause