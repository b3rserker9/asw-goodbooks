#!/bin/bash

# Script per arrestare Postgres e Kafka con Docker Compose (v2)

echo Halting infrastructure
docker compose down -v

#echo Halting all running java processes

#pkill -f 'java'


echo Halting Consul

docker stop asw-consul
docker rm asw-consul

echo Stop connessioni db

docker stop connessioni
docker rm connessioni


echo Stop recensioni db

docker stop recensioni
docker rm recensioni





