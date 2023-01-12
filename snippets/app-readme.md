# PROJECT-TITLE
This project contains a Spring Boot based rest API designed to
run on the Azure Spring App Service. You can use this generated 
project to get started quickly. The generated code has a single
API that returns a random quote. 

# Local Development Environment
For local development you will need Java JAVA-VERSION and your 
favourite IDE. Just import the project into your IDE and you will
be able to launch it.

LOCAL-DB-USAGE

# Provision Azure Development Resources

## KeyVault
An ARM template for creating an Azure KeyVault is located in 
`infra/azure/KeyVault` folder. A handy shell script `create-key-vault.sh`
is provided to create the KeyVault instance in a resource group of your 
choice. Use command below.

```bash
VAULT_RESOURCE_GROUP=demo && \
az deployment group create \
  --template-file infra/azure/KeyVault/key-vault-template.json \
  --parameters infra/azure/KeyVault/parameters.json \
  --resource-group ${VAULT_RESOURCE_GROUP}
```

AZURE-DB-USAGE

# Deploying to Azure Spring Apps

## Prerequisites

In order to deploy the application to Azure Spring Apps (ASA) service
you will need the azure cli installed, along with the azure
spring apps extension. If the extension is not installed
you can install it with the command `az extension add --name spring`


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
export ASA_APP_NAME=REPLACE-WITH-APP-NAME
```

## List the currently deployed apps

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
  --name ${ASA_APP_NAME} \
  --output table
```

## Create a Passwordless Connection to KeyVault

In order for the app to authenticate itself to Azure KeyVault 
using the app's azure managed identity we need to configure
the access policies in KeyVault to allow this particular
app permissions to read secrets stored in the vault.


```bash
VAULT_NAME=asaikali-demo-vault && \
az spring connection create keyvault \
  --service ${ASA_SERVICE_NAME} \
  --resource-group ${ASA_SERVICE_RG} \
  --connection vault \
  --app ${ASA_APP_NAME} \
  --client-type springBoot \
  --vault ${VAULT_NAME} \
  --system-identity \
  --target-resource-group ${ASA_SERVICE_RG} 
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
  --artifact-path ./target/PROJECT-TITLE-0.0.1--SNAPSHOT.jar \
  --output table
```

## Stream the log files of the application

Run the command below to stream the app logs 
```bash
az spring app logs \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  -f \
  --name ${ASA_APP_NAME} 
```

## Delete the application

You can delete the application with the command below

```bash
az spring app delete \
  --resource-group ${ASA_SERVICE_RG} \
  --service ${ASA_SERVICE_NAME} \
  --name ${ASA_APP_NAME} 
```

