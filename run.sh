#!/bin/bash

declare project_dir=$(dirname $0)
declare project_version='0.0.1'
declare dc_app=${project_dir}/docker/docker-compose.yml

function start() {
    build_api
    echo "Starting docker containers...."
    docker-compose -f ${dc_app} up --build --force-recreate -d
    docker-compose -f ${dc_app} logs -f
}

function stop() {
    echo "Stopping docker containers...."
    docker-compose -f ${dc_app} stop
    docker-compose -f ${dc_app} rm -f
}

function restart() {
    stop
    sleep 5
    start
}
function build_api() {
    ./mvnw clean package -DskipTests
}

function jibBuild() {
    ./mvnw clean package -DskipTests jib:build
}

function bpBuild() {
    ./mvnw -DskipTests spring-boot:build-image
}

function pushImages() {
    bpBuild
    docker tag sivaprasadreddy/spring-boot-todolist sivaprasadreddy/spring-boot-todolist:${project_version}
    docker push sivaprasadreddy/spring-boot-todolist --all-tags
}

function k8s_deploy() {
    kubectl apply -f k8s/
}

function k8s_undeploy() {
    kubectl delete -f k8s/
}

action="start"

if [[ "$#" != "0"  ]]
then
    action=$@
fi

eval ${action}
