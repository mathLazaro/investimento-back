# investimento-back-api

Esta API foi desenvolvida para gerenciar investimentos, oferecendo operações CRUD (Create, Read, Update, Delete) para ativos financeiros.

## Funcionalidades

Realiza operaçõs basicas de integração com o banco de dados.

## Tecnologias utilizadas

 - Liguagem: Java
 - Banco de dados: PostgreSQL
 - Frameworks: Spring
 - ORM: Hibernate
 - Ferramentas: Docker, Swagger, Lombok

## Execução do projeto

### Via container docker

*Para executar esse projeto via docker compose é necessário ter instalado o Docker e o Docker Compose.*

A partir da pasta do projeto clonado localmente, basta executar o seguinte comando no terminal:

> sudo docker-compose up -d

### Localmente

*É necessário ter instalado o Java 21 e Maven*

Primeiramente, mude a url do banco de dados no arquivo `application.yaml` para:

> url: jdbc:postgresql://localhost:5432/postgres

A partir da pasta do projeto clonado localmente, instalar as dependencias:

> mvn install -DskipTests

E, posteriormente, executar a aplicação:

> mvn spring-boot:start


### Endpoints

| Método | Rota                       | Descrição                 |
|--------|----------------------------|---------------------------|
| `POST`  | /investimentos| Cadastra um novo investimento |
| `GET`   | /investimentos?page=&size= | Lista todos investimentos |
| `GET`   | /investimentos/{id}| Consulta um investimento pelo ID |
| `PUT`   | /investimentos/{id}| Atualiza um investimento  |
| `DELETE` | /investimentos/{id}| Remove um investimento    |
| `GET` | /swagger-ui/index.html | Documentação da api |


