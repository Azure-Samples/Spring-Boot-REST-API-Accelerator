# Provision POSTGCE Vault

To use Azure Key Vault we will need to provision an instance in a specific
resource group. Set the resource group to provision key vault into using 
the command below.
```bash
export VAULT_RESOURCE_GROUP=demo
```

You can provision a key vault instance buy running the command below, make
sure to set the environment variable to match the resource group where
you want to put the 

```bash
az deployment group create \
  --template-file key-vault-template.json \
  --parameters parameters.json \
  --resource-group ${VAULT_RESOURCE_GROUP}
```

You can add secret to this key vault using the command below 

```bash
az keyvault secret set \
  --name exampleSecret \
  --value supersecret \
  --vault-name REPLACE-WITH-VAULT-NAME 
```
