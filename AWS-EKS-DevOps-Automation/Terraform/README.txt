Terraform Infrastructure for Kubernetes Deployment

Overview:
This Terraform configuration automates the provisioning of AWS resources needed to deploy a website on Amazon EKS. It sets up the networking, Kubernetes cluster, and load balancing to support the deployment.

Terraform Structure:
- terraform/
  - main.tf (Defines AWS infrastructure components)
  - variables.tf (Stores variable definitions)
  - outputs.tf (Defines Terraform output values)
  - provider.tf (Configures AWS provider for Terraform)
  - backend.tf (Configures S3 and DynamoDB for Terraform state management)
  - terraform.tfvars (Contains values for Terraform variables)
  - modules/
    - VPC/
      - main.tf (Creates VPC, subnets, internet gateway, NAT gateway)
      - variables.tf (Defines variables for VPC module)
    - EKS/
      - main.tf (Creates EKS cluster and node groups)
      - variables.tf (Defines variables for EKS module)
    - ALB/
      - main.tf (Creates Application Load Balancer and target groups)
      - variables.tf (Defines variables for ALB module)

Infrastructure Components:
1. **VPC and Networking:**
   - Creates a custom VPC with public and private subnets.
   - Deploys an internet gateway for public access.
   - Configures route tables and NAT gateways for secure communication.

2. **EKS Cluster:**
   - Provisions an EKS cluster with node groups.
   - Enables necessary IAM roles and security policies.
   - Sets up Kubernetes API access.

3. **Application Load Balancer (ALB):**
   - Deploys an ALB to distribute traffic to Kubernetes services.
   - Configures security groups and target groups for routing.

Terraform Deployment Instructions:
1. Navigate to the terraform/ directory.
2. Initialize Terraform: `terraform init`
3. Plan the deployment: `terraform plan`
4. Apply the changes: `terraform apply -auto-approve`
5. Retrieve outputs to verify infrastructure: `terraform output`

Conclusion:
Terraform automates the AWS infrastructure setup, allowing seamless integration with Kubernetes for deploying the website. This ensures a scalable and secure deployment environment.

