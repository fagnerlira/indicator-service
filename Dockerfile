FROM azul/zulu-openjdk-alpine:17.0.2-jre

ARG PROJECT_JAR_PATH

COPY target/indicator-service.jar indicator-service.jar
EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar /indicator-service.jar"]