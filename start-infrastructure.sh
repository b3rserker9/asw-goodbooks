#!/bin/bash

# Script per avviare Postgres e Kafka con Docker Compose (v2)

echo Starting infrastructure...

docker compose up -d 

echo Creating Kafka topic for the recensioni service...

KAFKA_DOCKER=$(docker ps | grep kafka | grep -v zookeeper | awk '{print $1}')

docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic recensioni-service-event-channel --replication-factor 1 --partitions 4


#echo Starting connessioni db in docker container

#docker run  --name connessioni -p 5433:5432 -e POSTGRES_PASSWORD=postgres -d postgres


#echo Starting recensioni db in docker container

#docker run  --name recensioni -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres


#echo Starting Consul in a Docker Container

#docker run -d --hostname localhost --name asw-consul --publish 8500:8500 consul

#echo Running GOODBOOKS

# Consul deve essere avviato separatamente

#java -Xms64m -Xmx128m -jar recensioni/build/libs/recensioni.jar &
#java -Xms64m -Xmx128m -jar connessioni/build/libs/connessioni.jar &
#java -Xms64m -Xmx128m -jar recensioni-seguite/build/libs/recensioni-seguite.jar &

#java -Xms64m -Xmx128m -jar api-gateway/build/libs/api-gateway.jar &
