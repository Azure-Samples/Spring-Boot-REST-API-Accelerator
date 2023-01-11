#!/bin/sh

az spring app create \
  -n quotes \
  -s demo-asa -g demo \
  --assign-endpoint true \
  --env SPRING_DATASOURCE=asaikali-postgres.postgres.database.azure.com

# Bind catalog service to Postgres
az spring connection create postgres-flexible \
    --resource-group demo \
    --service demo-asa \
    --connection quotes_db_connection \
    --app quotes \
    --deployment default \
    --tg demo \
    --server asaikali-postgres \
    --database quotes \
    --client-type springboot \
    --system-identity


az spring app deploy -n quotes -s demo-asa -g demo  --artifact-path target/sample-api-accelerator-0.0.1-SNAPSHOT.jar