# Jenkins and SonarQube Integration with Kubernetes

## Overview
This document provides a detailed guide on how Jenkins and SonarQube are set up and integrated with Kubernetes (EKS) for CI/CD and code quality analysis.

## Prerequisites
Before starting, ensure the following components are installed and configured:

### Jenkins Setup
- An EC2 instance for Jenkins with:
  - Java 11 or later
  - Jenkins installed
  - Docker installed and running
  - Required plugins:
    - Kubernetes Plugin
    - Pipeline Plugin
    - Docker Pipeline
    - Git Plugin
    - SonarQube Scanner
- IAM role attached to the Jenkins EC2 instance for accessing ECR and EKS
- `kubectl` installed and configured to interact with the EKS cluster
- AWS CLI installed and configured

### SonarQube Setup
- An EC2 instance or Kubernetes pod for SonarQube with:
  - PostgreSQL as the database backend
  - Proper security group settings allowing access from Jenkins
  - SonarQube scanner installed in Jenkins

## Jenkins Pipeline Workflow

1. **Checkout Code**
   - Jenkins pulls the latest code from the repository.
   
2. **Run SonarQube Analysis**
   - Jenkins triggers a SonarQube scan using the SonarQube scanner plugin.
   - Results are sent to the SonarQube server for analysis.
   - Pipeline proceeds only if quality gates pass.

3. **Build and Push Docker Image**
   - Docker image is built using the latest code.
   - Image is tagged and pushed to AWS Elastic Container Registry (ECR).

4. **Deploy to Kubernetes (EKS)**
   - Kubernetes manifests are updated with the new image version.
   - Deployment is applied using `kubectl`.
   - Rolling update ensures zero downtime.

## Integration with Kubernetes (EKS)

- Jenkins interacts with EKS using `kubectl`.
- Kubernetes namespaces (`prod-main` and `prod-backup`) are used for isolation.
- Persistent Volumes (EBS) store data persistently for SonarQube and application pods.
- Horizontal Pod Autoscaler (HPA) ensures efficient resource utilization.

## Security Considerations
- AWS IAM roles restrict access to required services.
- Secrets are encrypted using Kubernetes secrets management.
- SonarQube access is secured with authentication and restricted network access.

## Monitoring & Logging
- Jenkins logs are stored on the EC2 instance and can be forwarded to AWS CloudWatch.
- SonarQube reports are accessible via its dashboard for continuous improvement.
- Kubernetes metrics can be monitored using Prometheus and Grafana.

## Conclusion
This setup ensures an automated CI/CD pipeline with integrated code quality analysis, security, and scalability. The combination of Jenkins, SonarQube, and Kubernetes provides an efficient development workflow with high reliability.

