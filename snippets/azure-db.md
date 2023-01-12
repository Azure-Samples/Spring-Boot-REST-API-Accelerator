# Azure Database for PostgreSQL

An ARM template for creating a postgres database and putting
its password in the Key Vault created in the previous step
can is found at `/infra/azure/Postgres`. A handy shell 
script `create-postgres-server.sh` is provided to run 
the ARM template. You will need to pass the resource group name
where the ARM template will deploy the postgres server to 
on the command line.

```bash
cd infra/azure/Postgres
PG_RESOURCE_GROUP=demo ./create-postgres-server.sh ${PG_RESOURCE_GROUP}
```
