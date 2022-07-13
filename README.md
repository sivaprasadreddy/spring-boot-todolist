# spring-boot-todolist

A minimal SpringBoot application to try out new features.

![Main Branch CI](https://github.com/sivaprasadreddy/spring-boot-todolist/workflows/Main%20Branch%20CI/badge.svg)
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
### kubectl commands

```shell

kubectl apply -f k8s/config.yaml
kubectl apply -f k8s/postgresdb.yaml
kubectl apply -f k8s/todolist.yaml

kubectl apply -f k8s/

kubectl scale --replicas=2 deployment spring-boot-todolist-deployment
    
kubectl create deployment spring-boot-todolist --image sivaprasadreddy/spring-boot-todolist -o yaml --dry-run=client > k8s/deployment.yaml

kubectl create service clusterip spring-boot-todolist --tcp 80:8080 -o yaml --dry-run=client > k8s/service.yaml

kubectl port-forward svc/spring-boot-todolist 9090:8080

kubectl create configmap spring-boot-todolist --from-file=./k8s/application.properties

kubectl create configmap todolist-k8s-configmap --from-file=./application.properties

kubectl get configmap spring-boot-todolist -o yaml
```

## Development using Skaffold

```shell script
skaffold dev --port-forward --skip-tests=true
```
