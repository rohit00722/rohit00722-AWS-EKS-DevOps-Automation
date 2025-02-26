## Helm Charts for Kubernetes Deployment

### Overview:
This Helm setup automates the deployment and management of Kubernetes applications. It includes Helm charts for deploying our main application and monitoring stack (Grafana and Prometheus). Helm simplifies Kubernetes deployments by using templated YAML configurations, making it easier to deploy, upgrade, and maintain our applications.

---

### Helm Directory Structure:
```
helm_charts/
├── charts/
│   ├── my-app/
│   │   ├── templates/
│   │   │   ├── deployment.yaml
│   │   │   ├── service.yaml
│   │   │   ├── ingress.yaml
│   │   │   ├── helpers.tpl
│   │   ├── values.yaml
│   │   ├── chart.yaml
│   ├── monitoring/
│   │   ├── templates/
│   │   │   ├── grafana-deployment.yaml
│   │   │   ├── prometheus-deployment.yaml
│   │   │   ├── service.yaml
│   │   ├── values.yaml
│   │   ├── chart.yaml
```

---

### Explanation of Components:

#### 1. **my-app Chart:**
This Helm chart deploys our main application.
- **templates/deployment.yaml**: Defines the Kubernetes Deployment for the application.
- **templates/service.yaml**: Exposes the application as a Kubernetes service.
- **templates/ingress.yaml**: Configures an Ingress resource for external access.
- **values.yaml**: Stores configuration values such as replica count, image details, and service type.
- **chart.yaml**: Contains metadata about the Helm chart, such as version and description.

#### 2. **monitoring Chart:**
This Helm chart deploys monitoring tools (Grafana and Prometheus) in Kubernetes.
- **templates/grafana-deployment.yaml**: Defines the deployment for Grafana.
- **templates/prometheus-deployment.yaml**: Defines the deployment for Prometheus.
- **templates/service.yaml**: Creates services for both monitoring components.
- **values.yaml**: Stores configurations for Grafana and Prometheus, such as storage and authentication settings.
- **chart.yaml**: Metadata file for the monitoring Helm chart.

---

### Helm Installation and Deployment:
1. **Ensure Helm is installed:**
   ```sh
   helm version
   ```
   If not installed, install it using:
   ```sh
   curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash
   ```

2. **Navigate to the Helm charts directory:**
   ```sh
   cd helm_charts/
   ```

3. **Deploy the application chart:**
   ```sh
   helm install my-app charts/my-app/
   ```

4. **Deploy the monitoring stack:**
   ```sh
   helm install monitoring charts/monitoring/
   ```

5. **Verify deployments:**
   ```sh
   kubectl get pods
   kubectl get services
   ```

6. **Upgrade deployments (if needed):**
   ```sh
   helm upgrade my-app charts/my-app/
   helm upgrade monitoring charts/monitoring/
   ```

7. **Uninstall deployments (if needed):**
   ```sh
   helm uninstall my-app
   helm uninstall monitoring
   ```

---

### Purpose of Helm in This Project:
- Automates deployment with reusable configurations.
- Manages Kubernetes resources efficiently.
- Enables easy updates and rollbacks.
- Simplifies service exposure and networking.

By using Helm, we ensure that our Kubernetes deployment is **scalable**, **manageable**, and **repeatable** with minimal manual intervention.

