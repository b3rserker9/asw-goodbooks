#!/bin/bash

# Script per avviare Postgres e Kafka con Docker Compose (v2)

echo Starting docker compose
docker compose build
docker compose push
docker compose up -d

echo Creating Kafka topics for the Goodbooks...

KAFKA_DOCKER=$(docker ps | grep kafka | grep -v zookeeper | awk '{print $1}')

docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic recensioni-service-event-channel --replication-factor 1 --partitions 4
docker exec -it $KAFKA_DOCKER kafka-topics.sh --bootstrap-server localhost:9092 --create --topic connessione-event-channel --replication-factor 1 --partitions 4






