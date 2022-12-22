FROM docker.io/openjdk:17-alpine
ARG JAR_FILE=target/QuadraticExampleApplication-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources/application.yml  /deployments/application.yml
COPY app.jar /deployments/app.jar

ENV JAVA_OPTS="$JAVA_OPTS -Xms500m -Xmx1024m"

EXPOSE 8080
EXPOSE 5005

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /deployments/app.jar","--spring.config.location=file:///application.yml" ]