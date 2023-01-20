#!/bin/bash

echo Starting connessioni db in docker container

docker run  --name connessioni -p 5433:5432 -e POSTGRES_PASSWORD=postgres -d postgres
