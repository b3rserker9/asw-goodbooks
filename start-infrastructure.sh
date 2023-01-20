#!/bin/bash

# Script per avviare Postgres e Kafka con Docker Compose (v2)

echo Starting infrastructure...

docker compose up -d 

echo Creating Kafka topic for the recensioni service...

KAFKA_DOCKER=$(docker ps | grep kafka | grep -v zookeeper | awk '{print $1}')

docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic recensioni-service-event-channel --replication-factor 1 --partitions 4
docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connessione-event-channel --replication-factor 1 --partitions 4






