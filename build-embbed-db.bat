ECHO OFF

:: Elements name.
set imageName="java-spring-boot/base-app"
set containerName="jsb-base-app"

:: Remove old container and old image.
docker rm -f %containerName%
docker rmi %imageName%

:: Build iamge.
docker build -f "embbed-db.dockerfile" -t %imageName% .

:: Run container.
docker run -d -it ^
    --name %containerName% ^
    -p 80:80 -p 5432:5432 ^
    %imageName%
    @REM mvn spring-boot:run


@REM docker run -d -it --name jsb-base-app -p 80:80 -p 5432:5432 java-spring-boot/base-app


@REM docker build -f "embbed-db.dockerfile" -t "java-spring-boot/base-app" .
@REM  docker run -it -d -p 80:80 java-spring-boot/base-app

:: Remover container antigo.

:: (Re)Construir a imagem %appName%
@REM docker build -f "embbed-db.dockerfile" -t %appName% .
@REM docker build -f "embbed-db.dockerfile" -t "java-spring-boot/base-app" .

:: Criar e executar um container com a imagem.
@REM docker run -d -it ^
@REM     --rm --name %appName% ^
@REM     -p 80:8080 ^
@REM     -w /usr/src ^
@REM     %appName%

@REM @REM watch mvn spring-boot:run

@REM :: Acessar o container.
@REM docker exec -it %appName% bash

@REM docker run -d -it
@REM     --name jsb-base-app
@REM     -p 8080:8080
@REM     -w /usr/src
@REM     java-spring-boot/base-app
@REM     mvn spring-boot:run

@REM docker exec -it jsb-base-app bash