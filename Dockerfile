FROM docker.io/openjdk:17-alpine
ENV JAVA_OPTS="$JAVA_OPTS -Xms500m -Xmx1024m"
EXPOSE 8080
EXPOSE 5005
CMD mvn install
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /deployments/app.jar","--spring.config.location=file:///application.yml" ]