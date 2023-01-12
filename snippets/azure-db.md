## Azure Database for PostgreSQL

An ARM template for creating a postgres database and putting
its password in the Key Vault created in the previous step
can is found at `infra/azure/Postgres`. A handy shell 
script `create-postgres-server.sh` is provided to run 
the ARM template. You will need to pass the resource group name
where the ARM template will deploy the postgres server to 
on the command line.

```bash
PG_RESOURCE_GROUP=demo && \
az deployment group create \
  --template-file infra/azure/Postgres/postgres-template.json \
  --parameters infra/azure/Postgres/parameters.json \
  --resource-group ${PG_RESOURCE_GROUP}
```
