# Project Manual: DevOps Infrastructure Setup

## Introduction
This project is a complete DevOps pipeline implementation, covering containerization, orchestration, CI/CD automation, infrastructure as code (IaC), and monitoring. The primary objective is to create a highly scalable, automated, and secure infrastructure using industry best practices. By implementing this setup, we achieve an optimized, reliable, and production-ready infrastructure that ensures smooth deployment, monitoring, and management of applications.

## Objectives
1. **Automated Deployment:** Streamline the deployment process using Kubernetes and Helm.
2. **Scalability:** Utilize Kubernetes Horizontal Pod Autoscaler (HPA) for dynamic scaling.
3. **Monitoring & Logging:** Implement Grafana and Prometheus for real-time monitoring.
4. **Security & Compliance:** Use Kubernetes secrets and best practices to enhance security.
5. **Infrastructure as Code (IaC):** Manage infrastructure using Terraform for consistency and reproducibility.
6. **Continuous Integration & Continuous Deployment (CI/CD):** Automate build, test, and deployment processes using Jenkins and SonarQube.

## Project Components
### 1. **Docker**
- **Purpose:** Containerizes the application for consistent execution across environments.
- **Files:**
  - `Dockerfile`: Defines the container image.
  - `README.txt`: Describes the Docker setup.

### 2. **Helm Charts**
- **Purpose:** Manages Kubernetes application deployments.
- **Files:**
  - `Chart.yaml`: Metadata for Helm charts.
  - `values.yaml`: Configurations for deployments.
  - `templates/`: Contains deployment, service, ingress, and helper templates.

### 3. **Jenkins Pipeline**
- **Purpose:** Automates CI/CD workflow.
- **Files:**
  - `pipeline-with-sonarqube.groovy`: Defines the Jenkins pipeline with SonarQube integration.
  - `sonar-project.properties.txt`: Configuration for SonarQube.
  - `Prerequisites.txt`: Required setup instructions.

### 4. **Kubernetes Configurations**
- **Purpose:** Orchestrates application deployment, scaling, and networking.
- **Infrastructure Setup:**
  - **2 Nodes, Each Containing 2 Servers:** The architecture is designed for high availability and redundancy, ensuring failover support.
  - **Automated Deployment:** Applications are deployed seamlessly with Helm charts, reducing manual intervention.
- **Files:**
  - `manifests/`: Contains YAML files for services and deployments.
  - `prod-main/`, `prod-backup/`: Separate configurations for different environments.
  - `monitoring/`: Contains Grafana and Prometheus configurations.
  - `scripts/`: Automates deployment and setup tasks.

### 5. **Terraform Infrastructure**
- **Purpose:** Manages AWS infrastructure using Terraform.
- **Files:**
  - `main.tf`, `variables.tf`, `backend.tf`, `outputs.tf`: Define AWS resources.
  - `Modules/`: Contains separate modules for ALB, EKS, and VPC.

## Step-by-Step Execution
### Step 1: **Infrastructure Setup with Terraform**
1. Initialize Terraform: `terraform init`
2. Plan the infrastructure: `terraform plan`
3. Apply changes: `terraform apply`

### Step 2: **Build and Push Docker Images**
1. Navigate to the `docker_files/` directory.
2. Build the image: `docker build -t my-app .`
3. Push to registry: `docker push <your-repository>/my-app`

### Step 3: **Deploy Helm Charts to Kubernetes**
1. Deploy My-App: `helm install my-app helm_charts/charts/my-app`
2. Deploy Monitoring Stack: `helm install monitoring helm_charts/charts/monitoring`

### Step 4: **Configure CI/CD Pipeline in Jenkins**
1. Install Jenkins and required plugins.
2. Set up a pipeline with `pipeline-with-sonarqube.groovy`.
3. Integrate with SonarQube for code quality analysis.
4. Automate deployments through the pipeline.

### Step 5: **Monitor and Scale Kubernetes Cluster**
1. Access Grafana and Prometheus dashboards.
2. Set up alerts and logging mechanisms.
3. Ensure auto-scaling is working via HPA.

## Achievements and Impact
- **Infrastructure Resilience:** The two-node setup ensures high availability, minimizing downtime.
- **Automation:** Reduced manual intervention with Jenkins CI/CD.
- **Scalability:** Kubernetes ensures smooth scaling and high availability.
- **Security:** Kubernetes secrets and Terraform best practices enhance security.
- **Observability:** Monitoring with Grafana and Prometheus enables proactive issue resolution.
- **Infrastructure Efficiency:** Terraform ensures consistency and easy modifications.
- **Self-Healing Architecture:** Kubernetes automatically replaces failed pods to maintain service continuity.

## Conclusion
This project provides a robust, production-ready DevOps setup that ensures efficiency, security, and automation. With a two-node infrastructure and automated deployment pipeline, it guarantees high availability and seamless application management. The entire stack is designed to meet industry best practices, ensuring that applications are deployed seamlessly and maintained effortlessly.

