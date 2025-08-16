@echo off
REM 参数：-Dexec.args="arg1 arg2"
mvn clean compile exec:java -Dexec.mainClass="App"