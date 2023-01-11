#!/bin/bash -e

RESOURCE_GROUP=${1}

set -x

az deployment group create \
  --template-file postgres-template.json \
  --parameters parameters.json \
  --resource-group ${RESOURCE_GROUP}