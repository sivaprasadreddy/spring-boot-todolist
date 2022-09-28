#!/bin/bash

declare project_dir=$(dirname $0)
declare dc_app=${project_dir}/docker/docker-compose.yml

function build_api() {
    ./gradlew build -x test
}

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

function jibBuild() {
    ./gradlew jibDockerBuild
}

function bpBuild() {
    ./gradlew bootBuildImage
}

function pushImages() {
    bpBuild
    docker push sivaprasadreddy/spring-boot-todolist-gradle --all-tags
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
