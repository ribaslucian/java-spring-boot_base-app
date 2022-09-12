FROM rl-maven

# Copy and config application.
COPY . /usr/src/
WORKDIR /usr/src/
# RUN mvn clean install

# CMD mvn clean install
# Sets a command or process that will run each time a container is run from the new image.
# CMD [ "nohup mvn spring-boot:run &" ]