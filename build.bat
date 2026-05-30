@echo off
set MAVEN_VERSION=3.9.6
set MAVEN_DIR=%~dp0tools\maven

if not exist "%MAVEN_DIR%\bin\mvn.cmd" (
    echo Maven nicht gefunden, wird heruntergeladen...
    if not exist "%~dp0tools" mkdir "%~dp0tools"
    powershell -NoProfile -Command ^
        "$ErrorActionPreference='Stop';" ^
        "Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/%MAVEN_VERSION%/binaries/apache-maven-%MAVEN_VERSION%-bin.zip' -OutFile '%~dp0tools\maven.zip';" ^
        "Expand-Archive -Path '%~dp0tools\maven.zip' -DestinationPath '%~dp0tools' -Force;" ^
        "Rename-Item '%~dp0tools\apache-maven-%MAVEN_VERSION%' 'maven';" ^
        "Remove-Item '%~dp0tools\maven.zip';"
    if errorlevel 1 (
        echo FEHLER: Setup fehlgeschlagen.
        pause
        exit /b 1
    )
    echo Maven bereit!
)

"%MAVEN_DIR%\bin\mvn.cmd" clean package
pause
