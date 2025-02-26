Purpose of this Dockerfile
==========================
This Dockerfile is responsible for creating a containerized version of our web application,
which is then deployed to AWS EKS (Kubernetes) using Jenkins CI/CD pipeline.

How it Works with Jenkins & Kubernetes
======================================
1. Jenkins Pipeline Uses this Dockerfile:
   - Jenkins pulls the latest website code from the repository.
   - It builds a Docker image using this Dockerfile.
   - The built image is tagged and pushed to Amazon Elastic Container Registry (ECR).

2. Kubernetes (EKS) Deploys the Image:
   - Kubernetes pulls the latest Docker image from ECR.
   - It updates the running application using rolling deployment.
   - Traffic is managed using Kubernetes services and an Ingress controller.

Breakdown of the Dockerfile
===========================
- Ubuntu Base Image: Provides a lightweight, stable Linux environment.
- Apache Installation: Apache web server is installed to serve the website.
- Copying Source Code: The website’s `src/` directory is copied to Apache's root directory.
- Exposing Port 80: Ensures the container can serve HTTP traffic.
- Running Apache: Apache runs in the foreground to keep the container active.

Next Steps
==========
- Ensure Jenkins Pipeline is Configured Correctly:
  - Pipeline should build the Docker image and push it to ECR.
  - Kubernetes should pull the latest image and redeploy the application.
- Test the Deployment:
  - Verify that Kubernetes is pulling the correct image version.
  - Check if the website is accessible via the Kubernetes Ingress URL.
