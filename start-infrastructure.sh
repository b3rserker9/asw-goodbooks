#!/bin/bash

# Script per avviare Postgres e Kafka con Docker Compose (v2)

echo Starting infrastructure...

docker compose up -d

echo Creating Kafka topic for the recensioni service...

docker exec -it asw-goodbooks-kafka-1 kafka-topics.sh --bootstrap-server localhost:9092 --create --topic goodbooks.recensioni --replication-factor 1 --partitions 4
docker exec -it asw-goodbooks-kafka-1 kafka-topics.sh --bootstrap-server localhost:9092 --create --topic goodbooks.connessioni --replication-factor 1 --partitions 4


echo Starting connessioni db in docker container

docker run  --name connessioni -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres


echo Starting recensioni db in docker container

docker run  --name recensioni -p 5433:5432 -e POSTGRES_PASSWORD=postgres -d postgres


echo Starting recensioni-seguite db in docker container

docker run  --name recensioni-seguite -p 5434:5432 -e POSTGRES_PASSWORD=postgres -d postgres
