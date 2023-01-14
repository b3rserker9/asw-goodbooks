#######################################################
# Dockerfile per l'applicazione connessioni
#######################################################

# FROM openjdk:17-jdk
FROM openjdk:11-jdk
ADD build/libs/connessioni.jar connessioni.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "connessioni.jar"]
HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://api-gateway:8080/actuator/health || exit 1
