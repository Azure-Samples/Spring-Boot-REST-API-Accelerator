#!/bin/bash -e

export RESOURCE_GROUP=demo
export APP_NAME=quotes
export ASA_SERVICE_NAME=demo-asa
export VAULT_NAME=REPLACE-WITH-VAULT-NAME
export PG_SERVER_NAME=REPLACE-WITH-POSTGRES-SERVER-NAME

#
# compute some settings
#

export VAULT_URL=https://${VAULT_NAME}.vault.azure.net/
export PG_SERVER_HOST=${PG_SERVER_NAME}.postgres.database.azure.com

