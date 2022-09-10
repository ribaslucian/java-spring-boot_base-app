ECHO OFF

docker run -it --rm ^
    --name my-maven-project ^
    --mount type=bind,source=C:\projects\spring-boots\Spring-Base-Application,target=/usr/src/mymaven ^
    -w /usr/src/mymaven ^
    -p 80:80 ^
    maven:3.8.6-openjdk-11-slim ^
    mvn spring-boot:run