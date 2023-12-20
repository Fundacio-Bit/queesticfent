@echo off

set "MAVEN_OPTS=-XX:TieredStopAtLevel=1"

echo optional parameters -Dcaib -Psqlgen

cmd /C mvn clean install -DskipTests %* 

if %errorlevel% EQU 0 (

	@echo off
	IF DEFINED QUEESTICFENT_DEPLOY_DIR (
      for /f "tokens=* delims=" %%x in (versio.txt) do set QUEESTICFENT_VERSIO=%%x
	  @echo on
	  echo --------- COPIANT EAR %QUEESTICFENT_VERSIO% ---------

	  xcopy /Y queesticfent-ear\target\queesticfent.ear %QUEESTICFENT_DEPLOY_DIR%

	) ELSE (
	  echo  =================================================================
	  echo    Definex la variable d'entorn QUEESTICFENT_DEPLOY_DIR apuntant al
	  echo    directori de deploy del JBOSS  i automaticament s'hi copiara
	  echo    l'ear generat.
	  echo  =================================================================
	) 

)