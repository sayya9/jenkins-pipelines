# Intallation
```
helm repo add nabsul https://nabsul.github.io/helm
helm repo up
helm upgrade -i k8s-ecr-login-renew -n appaegis --version 1.0.5 -f values.yaml nabsul/k8s-ecr-login-renew
```
