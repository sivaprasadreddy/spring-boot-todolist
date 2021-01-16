# Running application on Kubernetes

## Install minikube
https://minikube.sigs.k8s.io/docs/start/

`brew install minikube` or

```shell
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-darwin-amd64
sudo install minikube-darwin-amd64 /usr/local/bin/minikube
```

* Start minikube

```shell
minikube start  //use docker driver
minikube start --driver=virtualbox
eval $(minikube docker-env)
```

* Build docker image: `./gradlew bootBuildImage`

* Deploy application

    * `kubectl apply -f k8s/config.yaml`
    * `kubectl apply -f k8s/postgresdb.yaml`
    * `kubectl apply -f k8s/todolist.yaml`
    * `kubectl scale --replicas=2 deployment spring-boot-todolist-deployment`

```shell

kubectl create deployment spring-boot-todolist --image sivaprasadreddy/spring-boot-todolist:latest -o yaml --dry-run=client > k8s/deployment.yaml

kubectl create service clusterip spring-boot-todolist --tcp 80:8080 -o yaml --dry-run=client > k8s/service.yaml

kubectl port-forward svc/spring-boot-todolist 9090:8080

kubectl create configmap spring-boot-todolist --from-file=./k8s/application.properties

kubectl create configmap todolist-k8s-configmap --from-file=./application.properties

kubectl get configmap spring-boot-todolist -o yaml
```
