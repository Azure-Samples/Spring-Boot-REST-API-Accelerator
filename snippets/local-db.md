For local development on your laptop you can use docker compose
to launch a postgres 14 server along with a pgAdmin GUI. The
docker compose file is located in `infra/local` folder.

| Container | Port  |
|-----------|-------|
| Postgres  | 15432 |
| gpAdmin   | 15333 |

**Commands:**
1. **run local database**
```bash
cd infra/local
docker compose up 
```

**Stop local database**
```bash
cd infra/local
docker compose down 
```
**Access pgAdmin on [http://localhost:15433](http://localhost:15433)**
