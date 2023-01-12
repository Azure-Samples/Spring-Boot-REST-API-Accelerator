# Developing the accelerator
An simple application accelerator for Azure Spring Apps Enterprise Tier.
This is designed to teach you the concepts of an application accelerator and
highlight how accelerators simplifies the life developers.

## Features
Asks the user to choose: 

* version of Java 11 or 17
* package name to use the generated code 
* Name of an Azure Key Vault to use to store secrets used by the API
* Name of postgres DB to create if the user asks for a database

# Getting Started
The rest of this ready explains how to register this accelerators 
with the Azure Spring Apps service. The readme file seen by the user
when they generate a project is located in ["app-readme.md"](app-readme.md) Below are
azure cli commands to manage accelerators with Azure Spring Apps.

## Enable Application Accelerator 
The first step is to enable the application accelerator capability
in Azure Spring Apps Enterprise Tier. You can use the command below
replace the `ASA_SERVICE_RG` and `ASA_SERVICE_NAME` environment
variables with the values for the resource group and service name
where Azure Spring Apps is running.

```bash
ASA_SERVICE_RG=demo && \
ASA_SERVICE_NAME=demo-asa && \
az spring application-accelerator create \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME}
```

## Register the Accelerator
The second step is to register the accelerator with Azure Spring Apps
using the command below.You will need to make modifications to match
where the Azure Spring Apps instance is deploy, along with the specific
details of accelerator such as name, git repo it is located in, and
display name.
```bash
ASA_SERVICE_RG=demo && \
ASA_SERVICE_NAME=demo-asa && \
az spring application-accelerator customized-accelerator create \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --name spring-boot-rest-api \
  --display-name "Spring Boot REST API" \
  --git-branch main \
  --git-interval 10 \
  --git-url https://github.com/asaikali/Spring-Boot-REST-API-Accelerator 
```

## List Deployed Accelerators
The command displays a table with all the metadata details of an accelerator.

```bash
ASA_SERVICE_RG=demo && \
ASA_SERVICE_NAME=demo-asa && \
az spring application-accelerator customized-accelerator list \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --output table
```

## Unregister an Accelerator
```bash
ASA_SERVICE_RG=demo && \
ASA_SERVICE_NAME=demo-asa && \
az spring application-accelerator customized-accelerator delete \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --name sample-api-accelerator  
```

