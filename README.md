# good-morning-hotels
Challenge para un proyecto en spring-boot para reforzar y aprender cosas nuevas en una AMS.

Este es el proyecto base.

Componentes estructurales
#Postgres on docker
I need to pull postgres image

`docker pull postgres:latest`

To run the Docker container using previus `postgres.latest` image 

`docker run -itd -e POSTGRES_USER=gmh_root -e POSTGRES_PASSWORD=adminadmin -p 5432:5432 -v /Users/guichosun/data:/var/lib/postgresql/data --name postgres-server-container postgres`

# Eureka server 
Es el ancargado del registro y descubrimiento en la AMS. Este componwnte se tiene que ejecutar primero.


Se divide en estos diferentes microservicios.

# Hoteles

# Habitaciones

# Reservas

# Huéspedes

