# Spring-Boot-REST-API-Accelerator

An simple application accelerator creating Spring Boot based API for the
Azure Spring Apps Enterprise tier service. This is designed to teach you 
the concepts of an application accelerator and highlight how accelerators 
simplifies the life developers.

# Local Development

For local development you will need Java and your favourite IDE. 
Just import the project into your IDE and you will be able to launch it.

# Deploying to Azure Spring Apps

## Prerequisites

In order to deploy the application to Azure Spring Apps (ASA) service
you will need the azure cli installed, along with the azure
spring apps extension. If the extension is not installed
you can install it with the command `az extension add --name spring`

Setup of any dependant azure resources can be found in the
`/azure` folder. If the folder does not exist then you don't 
need it.

## Set environment variables
All `az spring` commands require two common parameters. The name of
the ASA service and the name of the resource group that the ASA
service has been created in. You can set the resource group name
by passing it via the `--resource-group` option and the service
name with the `--service` option. If the `--resource-group` and
`--service` are not specified then the default settings of the
azure cli are used. In order to avoid conflicts with your local
azure cli setup run the command below to export two environment
variables that the rest of the commands in this document will use.

```bash
export ASA_SERVICE_RG=demo 
export ASA_SERVICE_NAME=demo-asa 
export ASA_APP_NAME=quotes-demo
```

## Lst the currently deployed apps

Run the command below to see what apps are currently deployed
to the ASA instance.

```bash
az spring app list \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --output table
```

## Create the application in Azure Spring Apps

Before we can deploy the application code we need to tell Azure Spring Apps
to create the app so that we can start deploying code. You can create the app
with the command below.

```bash
az spring app create \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --assign-endpoint true \
  --system-assigned true \
  --cpu 1000m \
  --memory 1Gi \
  --name ${ASA_APP_NAME} 
```

## Deploy the application code

Azure spring apps can deploy application code from source or from a complied
`.jar`. Lets deploy the app as a `.jar` file. Compile the app suing the
typical maven command

```bash
./mvnw clean package
```
Run the command below to deploy the app.
```bash
az spring app deploy \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --name ${ASA_APP_NAME} \
  --artifact-path ./target/Spring-Boot-REST-API-Accelerator-0.0.1-SNAPSHOT.jar
```

## Delete the application

You can delete the application with the command below

```bash
az spring app delete \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --name ${ASA_APP_NAME} 
```
