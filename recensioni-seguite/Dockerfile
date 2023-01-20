#######################################################
# Dockerfile per l'applicazione recensioni-seguite
#######################################################

# FROM openjdk:17-jdk
FROM eclipse-temurin:17-jdk
ADD build/libs/recensioni-seguite.jar recensioni-seguite.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "recensioni-seguite.jar"]
HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1