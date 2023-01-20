#!/bin/bash

echo Starting recensioni db in docker container

docker run  --name recensioni -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
