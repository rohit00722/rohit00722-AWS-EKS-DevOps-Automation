variable "vpc_id" {
  description = "VPC ID where the ALB will be deployed"
  type        = string
}

variable "subnet_ids" {
  description = "List of subnet IDs for the ALB"
  type        = list(string)
}

variable "alb_name" {
  description = "Name of the ALB"
  type        = string
  default     = "my-alb"
}

variable "alb_security_group" {
  description = "Security group for the ALB"
  type        = string
}

variable "target_group_name" {
  description = "Target group name"
  type        = string
  default     = "my-target-group"
}

variable "target_port" {
  description = "Port for the target group"
  type        = number
  default     = 80
}

variable "target_protocol" {
  description = "Protocol for the target group"
  type        = string
  default     = "HTTP"
}

variable "listener_port" {
  description = "Listener port for the ALB"
  type        = number
  default     = 80
}

variable "listener_protocol" {
  description = "Listener protocol for the ALB"
  type        = string
  default     = "HTTP"
}
