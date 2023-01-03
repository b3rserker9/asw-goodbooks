#!/bin/bash
echo Stop connessioni db

docker stop connessioni
docker rm connessioni
