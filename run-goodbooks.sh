#!/bin/bash

# Script per avviare l'applicazione GoodBooks 

echo Running GOODBOOKS 

# Consul deve essere avviato separatamente 

echo Starting infrastructure...

docker compose up -d

echo Creating Kafka topics for the restaurant service...

KAFKA_DOCKER=$(docker ps | grep kafka | grep -v zookeeper | awk '{print $1}')

winpty docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connessione-event-channel --replication-factor 1 --partitions 4
winpty docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic recensioni-service-event-channel --replication-factor 1 --partitions 4
