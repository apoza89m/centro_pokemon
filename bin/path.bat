@echo off

rem Ruta con la ubicación de tu JDK
set "jdkPath=C:\Program Files\Java\jdk-18.0.1.1"

rem Verifica si la ruta del JDK ya existe
echo %PATH% | findstr /C:"%jdkPath%\bin" > nul
if errorlevel 1 (
    setx PATH "%PATH%;%jdkPath%\bin"
    echo La ruta al JDK se ha agregado correctamente al PATH.
) else (
    echo La ruta al JDK ya está presente en el PATH.
)

pause