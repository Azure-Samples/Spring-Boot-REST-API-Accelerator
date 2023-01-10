# Developing the accelerator

An simple application accelerator for Azure Spring Apps Enterprise tier service.
This is designed to teach you the concepts of an application accelerator and
highlight how accelerators simplifies the life developers.

## Features

This accelerator generate Spring Boot REST API project that is
targeted to run on Azure Spring Apps Service.

* choose the version of Java 11 or 17
* choose integration with Azure Key Vault

## Getting Started

1. Register the accelerator with Azure spring apps by following the instructions in [accelerator.md](accelerator.md)
2. Visit the accelerator URL in the Azure Spring Apps Instance where the accelerator was register
3. Select the accelerator, generate a project and follow the instructions in the generated project's readme.md

Below are azure cli commands to manage accelerators with Azure
Spring Apps Enterprise. 

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

## Register the accelerator 
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

## Unregister an accelerator

```bash
ASA_SERVICE_RG=demo && \
ASA_SERVICE_NAME=demo-asa && \
az spring application-accelerator customized-accelerator delete \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --name sample-api-accelerator  
```
