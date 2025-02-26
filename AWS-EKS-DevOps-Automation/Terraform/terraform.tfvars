aws_region = "us-east-1"
vpc_cidr_block = "10.0.0.0/16"
public_subnets = ["10.0.1.0/24", "10.0.2.0/24"]
private_subnets = ["10.0.3.0/24", "10.0.4.0/24"]
cluster_name = "my-eks-cluster"
instance_type = "t3.medium"
desired_capacity = 2
max_capacity = 3
min_capacity = 1
alb_name = "my-application-load-balancer"
