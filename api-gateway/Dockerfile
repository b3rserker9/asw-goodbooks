#######################################################
# Dockerfile per l'applicazione api-gateway
#######################################################

# FROM openjdk:17-jdk
FROM openjdk:11-jdk
ADD build/libs/api-gateway.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xms64m", "-Xmx128m", "-jar", "api-gateway.jar"]
