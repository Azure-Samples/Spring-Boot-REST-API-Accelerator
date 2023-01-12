#!/bin/bash -e

RESOURCE_GROUP=${1}

set -x

az deployment group create \
  --template-file key-vault-template.json \
  --parameters parameters.json \
  --resource-group ${VAULT_RESOURCE_GROUP}