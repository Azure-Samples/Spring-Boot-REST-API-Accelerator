#!/bin/sh

RESOURCE_GROUP=demo
POSTGRES_ADMIN_PASSWORD=oeuaop23pyeuoaoup2345p23.p4oeuo

az deployment group create --resource-group ${RESOURCE_GROUP} \
    --name initial \
    --template-file="postgres-arm-template.json" \
    --parameters parameter.json administratorLoginPassword=${POSTGRES_ADMIN_PASSWORD}


  echo "Creating Postgres Database $ACMEFIT_CATALOG_DB_NAME"
  az postgres db create \
    --resource-group demo \
    --name quotes \
    --server-name asaikali-postgres.postgres.database.azure.com

# update
