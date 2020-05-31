# spring-boot-todolist

A sample SpringBoot application to learn various deployment options.

## Deployment

### Run SpringBoot application on a Linux VM
1. Create a VM using Vagrant
2. Provision required software using shell scripts
3. Provision required software using Ansible
4. Create a Vagrant box with required softwares pre-installed and publish to VagrantCloud
5. Run SpringBoot application as a Systemd service
6. Run SpringBoot application as a docker container

### Run SpringBoot application on AWS EC2
1. Create an EC2 instance and RDS (Postgres) on AWS using AWS Console
2. Deploy application as a Systemd service using shell scripts/Ansible

### Run SpringBoot application on AWS EC2 using Terraform
1. Create an EC2 instance and RDS (Postgres) on AWS using Terraform
2. Deploy application as a Systemd service using shell scripts/Ansible

### Run SpringBoot application on AWS EC2 using CloudFormation
1. Create an EC2 instance and RDS (Postgres) on AWS using CloudFormation
2. Deploy application as a Systemd service using shell scripts/Ansible

### Run SpringBoot application on AWS EC2 using AWS CDK
1. Create an EC2 instance and RDS (Postgres) on AWS using AWS CDK
2. Deploy application as a Systemd service using shell scripts/Ansible

### Run SpringBoot application on AWS ECS using CloudFormation
1. Create an EC2 instance and RDS (Postgres) on AWS using CloudFormation
2. Deploy application as a docker container

### Run SpringBoot application on AWS EKS
1. Create an EKS Cluster
2. Deploy application as a docker container
