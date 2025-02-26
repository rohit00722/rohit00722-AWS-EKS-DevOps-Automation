My DevOps Project (Without Helm)

## Overview
This project provides a **highly available, scalable, and resilient** Kubernetes setup on **AWS EKS**, ensuring:
- **High Availability** with multi-node EKS cluster
- **Fault Tolerance** with separate namespaces for **Prod-Main** and **Prod-Backup**
- **Persistent Storage** via EBS-backed PVCs
- **Auto Scaling** using HPA when memory usage exceeds **70%**
- **Traffic Management** through ALB Ingress
- **Monitoring** with **Prometheus & Grafana**
- **Secrets Encryption** using Kubernetes Secrets

## Prerequisites
- **AWS CLI**, **kubectl**, and **eksctl** installed
- AWS IAM permissions for EKS, EC2, S3, IAM

## Deployment Steps
1. **Create EKS Cluster:**
   ```sh
   ./scripts/setup-eks.sh
   ```
2. **Deploy Kubernetes Manifests:**
   ```sh
   ./scripts/deploy.sh
   ```
3. **Verify Deployments:**
   ```sh
   kubectl get pods -n prod-main
   kubectl get pods -n prod-backup
   ```

## Scaling & HPA
- Auto-scales when memory crosses **70%**
- Check status:
  ```sh
  kubectl get hpa -n prod-main
  ```

## Secrets Encryption
- Encrypted Kubernetes secrets using AWS KMS.
- Apply encrypted secrets:
  ```sh
  kubectl apply -f kubernetes/secret.yaml
  ```

## Cleanup
To destroy cluster and all resources:
```sh
./scripts/cleanup.sh
```

