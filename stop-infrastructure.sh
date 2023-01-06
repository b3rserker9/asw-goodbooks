#!/bin/bash

# Script per arrestare Postgres e Kafka con Docker Compose (v2)

echo Halting infrastructure
docker compose down -v

#echo Halting all running java processes

#pkill -f 'java'


echo Stop connessioni db

docker stop connessioni
docker rm connessioni


echo Stop recensioni db

docker stop recensioni
docker rm recensioni

echo Stop recensioni-seguite db

docker stop recensioni-seguite
docker rm recensioni-seguite