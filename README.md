# spring-boot-todolist

A sample SpringBoot application to learn various deployment options.

![Master Branch CI](https://github.com/sivaprasadreddy/spring-boot-todolist/workflows/Master%20Branch%20CI/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sivaprasadreddy_spring-boot-todolist&metric=alert_status)](https://sonarcloud.io/dashboard?id=sivaprasadreddy_spring-boot-todolist)

## Build and push docker image
```shell script
cd spring-boot-todolist
chmod a+x run.sh
./run.sh docker_build v1
./run.sh docker_push v1
```
