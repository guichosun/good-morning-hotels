# good-morning-hotels
Challenge para un proyecto en spring-boot para reforzar y aprender cosas nuevas en una AMS.

This is the MSA's main project.

## Componentes estructurales

### * MongoDB on docker

I need to pull __mongo:6.0__ image

`docker pull mongo:6.0`

**IMPORTANTE** Tener cuidado de que al momento de crear el container o hacer run, de que la carpeta del volumen tiene que estar vacia.

I need to create a container based on mongo image called **monguis**:

`docker create -p27017:27017 --name monguis --network gmh-network -v /Users/guichosun/data:/data/db -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=adminadmin123 -e MONGO_INITDB_DATABASE=testdb mongo:6.0`

to run a container, use the run command. Its more easy. If doesn't exist the image, then it pulls the image, also, create a container.

`docker run -d -p27017:27017 --name monguis --network gmh-network -v /Users/guichosun/data:/data/db -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=adminadmin123 -e MONGO_INITDB_DATABASE=testdb mongo:6.0`

This Command will give you a bash shell inside your **monguis** container: 
`docker exec -it monguis bash`

To enter the container logs `docker logs --follow monguis`

To re-start the **monguis**

`docker start --interactive monguis`

---
### * Postgres on docker

I need to pull postgres image

`docker pull postgres:latest`

To run the Docker container using previus `postgres.latest` image 

`docker run -itd -e POSTGRES_USER=gmh_root -e POSTGRES_PASSWORD=adminadmin -p 5432:5432 -v /Users/guichosun/data:/var/lib/postgresql/data --name postgres-server-container postgres`

To re-start the **postgres-server-container**

`docker start --interactive postgres-server-container`

---
### * Eureka server 

Es el ancargado del registro y descubrimiento en la AMS. Este componwnte se tiene que ejecutar primero.

---
### * API Gateway

This is an implemented of the APIGateway pattern. Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.

Spring Cloud Gateway provides a powerful way to handle HTTP traffic between microservices. It also provides several mechanisms for securing the gateway, including JWT.

---
There are several important microservices.

---
### * Hoteles

---
### * Habitaciones

---
### * Reservas

---
### * Huéspedes

Service to manage all request for Guest features. 

It implements `spring-boot-starter-security` 