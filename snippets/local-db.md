For local development on your laptop you can use docker compose
to launch a postgres 14 server along with a pgAdmin GUI. The
docker compose file launch two containers.
1. Postgres 14 accessible on `localhost:15432`
2. gpAdmin accessible on [http://localhost:15433](http://localhost:15433)**

The `docker-compose.yaml` is located in `infra/local` directory.
**run local database**
```bash
cd infra/local
docker compose up 
```
**Stop local database**
```bash
cd infra/local
docker compose down 
```
