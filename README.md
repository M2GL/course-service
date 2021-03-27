# course-service
course-service

Micro-service : application java avec spring boot et une base de donnée PostgreSql

for the data base 

"docker run -d  --name postgres-service  -e POSTGRES_PASSWORD=azerty  -p 5435:5432 postgres"

or with persisten volume 

docker run -d  --name postgres-service  -e POSTGRES_PASSWORD=azerty  -e PGDATA=/var/lib/postgresql/data/pgdata -v /Users/Billel/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/postgres-service-data:/var/lib/postgresql/data -p 5435:5432 postgres
