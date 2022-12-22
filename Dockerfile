FROM docker.io/maven
COPY src /home/app/src
COPY pom.xml /home/app
CMD ls
RUN mvn -f /home/app/pom.xml clean package
ARG JAR_FILE=/home/app/target/QuadraticExampleApplication-1.0-SNAPSHOT.jar
ENV JAVA_OPTS="$JAVA_OPTS -Xms500m -Xmx1024m"
##gdf
EXPOSE 8080
EXPOSE 5005
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /home/app/target/QuadraticExampleApplication-1.0-SNAPSHOT.jar","--spring.config.location=file:////home/app/src/resources/application.yml" ]