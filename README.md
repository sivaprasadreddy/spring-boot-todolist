# spring-boot-todolist

A minimal SpringBoot application to try out new features.

![Master Branch CI](https://github.com/sivaprasadreddy/spring-boot-todolist/workflows/Master%20Branch%20CI/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sivaprasadreddy_spring-boot-todolist&metric=alert_status)](https://sonarcloud.io/dashboard?id=sivaprasadreddy_spring-boot-todolist)

## Run using DockerCompose

```shell script
./run.sh start
./run.sh stop
./run.sh restart
```

## Running on Kubernetes

```shell script
cd kind
./create-cluster.sh
cd ..
./run.sh k8s_deploy
./run.sh k8s_undeploy
./kind/destroy-cluster.sh
```

## Development using Skaffold

```shell script
cd kind
./create-cluster.sh
cd ..
skaffold dev --port-forward --skip-tests=true
```
