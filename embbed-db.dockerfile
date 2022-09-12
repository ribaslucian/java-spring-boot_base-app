FROM postgres

# Environment vars.
    ENV MAVEN_HOME /usr/share/maven
    ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
    ENV POSTGRES_PASSWORD "postgres"
    ENV POSTGRES_DB "spring_base_app"
    ENV DB_URL "jdbc:postgresql://localhost:5432/spring_base_app"
    # ENV DB_URL "jdbc:postgresql://host.docker.internal:5432/spring_base_app"

# Local configs.
    ENV HOSTNAME="jsb_base_app"
    # EXPOSE 5432
    # RUN service postgresql start

# Install JDK e Curl
    RUN apt-get update
    RUN apt-get -y install curl openjdk-11-jdk
    RUN java -version

# Install and configuration the Maven.
    ARG MAVEN_VERSION=3.8.6
    ARG USER_HOME_DIR="/root"
    ARG SHA=f790857f3b1f90ae8d16281f902c689e4f136ebe584aba45e4b1fa66c80cba826d3e0e52fdd04ed44b4c66f6d3fe3584a057c26dfcac544a60b301e6d0f91c26
    ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

    RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
    && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && echo "${SHA} /tmp/apache-maven.tar.gz" | sha512sum -c - \
    && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
    && rm -f /tmp/apache-maven.tar.gz \
    && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Copy and run application.
    COPY . /usr/src/
    WORKDIR /usr/src/
    # CMD ["mvn", "clean", "install", "spring-boot:run"]
    # CMD mvn spring-boot:run
    # CMD mvn clean install
    # RUN printf "mvn spring-boot:run" > "entryfile.sh"
    # ENTRYPOINT ["/usr/src/entrypoint.sh"]