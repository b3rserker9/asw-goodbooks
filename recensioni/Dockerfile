#######################################################
# Dockerfile per l'applicazione recensioni
#######################################################

# FROM openjdk:17-jdk
FROM openjdk:11-jdk
ADD build/libs/recensioni.jar recensioni.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xms64m", "-Xmx128m", "-jar", "recensioni.jar"]
HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://api-gateway:8080/actuator/health || exit 1
