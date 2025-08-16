@echo off
setlocal
set VERSION=%~1
:check
if "%VERSION%" == "" (
    set /p "VERSION=Please input the version: "
    goto check
)
mvn versions:set -DnewVersion=%VERSION%
:: mvn versions:revert
mvn versions:commit
endlocal