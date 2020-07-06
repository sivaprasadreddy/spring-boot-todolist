.DEFAULT_GOAL := help

help:
	@echo "Usage: make build | run | dbuild | drun | clean"

build:
	@echo "Running maven build"
	./mvnw clean package

run:
	@echo "Running spring boot application"
	./mvnw spring-boot:run

dbuild:
	@echo "Building docker image"
	./mvnw spring-boot:build-image

drun:
	@echo "Running application using docker-compose"
	docker-compose up --build -d spring-boot-todolist

clean:
	@echo "Cleaning maven target, docker containers"
	./mvnw clean
	docker-compose down --remove-orphans --volumes
