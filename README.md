# TQI Evolution Backend 2021

## Requisitos

* Git
* Java 11
* Docker
* Spring boot
* Postgres
* Maven
* JWT
* Hibernate

## Banco de Dados

### Postgres

[Postgres Docker Hub](https://hub.docker.com/_/postgres)

* Criação do banco de dados via Docker

```shell script
docker run --name tqi-avaliacao -d -p 5432:5432 -e POSTGRES_USER=postgres_user_tqi -e POSTGRES_PASSWORD=SUA_SENHA -e POSTGRES_DB=tqi postgres
```
* Conectar ao container

```shell script
docker run -it --rm --net=host postgres /bin/bash
```

* Tabelas

```shell script
CREATE TABLE cliente (
  id	           bigserial NOT NULL,
  nome             varchar(255),
  e-mail           varchar(255),
  cpf              varchar(20),
  rg               varchar(20),
  endereco         varchar(255),
  renda            numeric(10,2),
  senha            varchar(255)	
);

CREATE TABLE emprestimo (
  id		   bigserial NOT NULL,
  id_cliente       bigint,
  valor            numeric(10,2),
  parcelas         int,
  data_pri_par	   date	
);
```
* Acesso

```shell script
docker exec -it tqi /bin/bash
psql -h localhost -U postgres_user_tqi tqi
```
## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 11
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver
+ Lombok
+ JWT
+ Spring Security
+ Maven

## Documentação API Postman

[Documentação API TQI Evolution 2022 - Back-End [Paulo Bruni]](https://documenter.getpostman.com/view/18075832/UVXesdpc)
