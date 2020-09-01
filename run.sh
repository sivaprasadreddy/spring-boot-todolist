#!/bin/bash
declare docker_username="sivaprasadreddy"
declare docker_image_name="spring-boot-todolist"
declare IMAGE=${docker_username}/${docker_image_name}

function docker_build() {
  ./mvnw spring-boot:build-image -DskipTests
  #docker build -t ${IMAGE} .
  if [[ $# -gt 0 ]]
  then
    docker tag ${IMAGE}:latest ${IMAGE}:"$1"
    echo "Tagged with latest & $1"
  fi
}

function docker_push() {
  docker_build $@
  docker push ${IMAGE}
}

action="docker_build"

if [[ "$#" != "0"  ]]
then
    action=$@
fi

eval ${action}
