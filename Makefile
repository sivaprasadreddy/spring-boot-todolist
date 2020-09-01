.DEFAULT_GOAL := help

help:
	@echo "Usage: make build | test | run | clean"

build:
	@echo "Running gradle build"
	./gradlew clean build

test:
	@echo "Running tests"
	./gradlew test

run:
	@echo "Running spring boot application"
	SPRING_PROFILES_ACTIVE=local ./gradlew bootRun

clean:
	@echo "Cleaning build artifacts"
	./gradlew clean

dockerbuild:
	@echo "Building docker image"
	./gradlew bootBuildImage

dockerrun:
	@echo "Running application using docker-compose"
	docker-compose -f docker-compose.yml -f docker-compose-app.yml up --build -d spring-boot-todolist

dockerstop:
	@echo "Stop application using docker-compose"
	docker-compose -f docker-compose.yml -f docker-compose-app.yml down --volumes --remove-orphans
