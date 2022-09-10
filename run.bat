ECHO OFF

set appName="java-spring-boot/base-app"

:: Remover container antigo.
docker rm -f %appName%

@REM @REM :: (Re)Construir a imagem %appName%
docker build -t %appName% .

:: Criar e executar um container com a imagem.
@REM docker run -d -it ^
@REM     --rm --name %appName% ^
@REM     -p 80:8080 ^
@REM     -w /usr/src ^
@REM     %appName%

@REM @REM watch mvn spring-boot:run

@REM :: Acessar o container.
@REM docker exec -it %appName% bash

docker run -d -it
    --name jsb-base-app
    -p 8080:8080
    -w /usr/src
    java-spring-boot/base-app
    mvn spring-boot:run

@REM docker exec -it jsb-base-app bash