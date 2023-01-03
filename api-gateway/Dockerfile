######################################################
# Dockerfile per l'applicazione sentence / api-gateway 
######################################################

# FROM openjdk:17-jdk 
FROM eclipse-temurin:17-jdk 

ADD build/libs/api-gateway.jar api-gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "api-gateway.jar"]