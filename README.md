[![Build Status](https://travis-ci.org/gihMarquess/loja-pescaria.svg?branch=master)](https://travis-ci.org/gihMarquess/loja-pescaria)

Products API  version 1.0.0
==================
- API desenvolvida para o gerenciamento de produtos da loja de pesca

OBS: Ela foi criada a partir do contrato rmal importado pelo restlet:


https://anypoint.mulesoft.com/mocking/api/v1/links/281ceebd-b63d-4fac-b833-fb2f0c681dac/
Essa url pode ser colocada no restlet client e o código encontra-se nesse projeto.

Para a vizualização gráfica desta api, foi gerado o swagger, permitindo que os métodos sejam testados diretamente pelo local:
http://localhost:8080/swagger-ui.html#/products-controller
Não sendo necessária a utilização do postman

Getting started
---------------
O banco de dados utilizado foi o mysql, e para que a applicação rode, é necessário ter um banco de dados chamado ###products criado.


A API RESTful de produtos da loja de pesca contém as seguintes características:

•Projeto criado com Spring Boot e Java 8
•Banco de dados MySQL com JPA e Spring Data JPA
•Migração de banco de dados com Flyway
•Testes unitários e de integração com JUnit e Mockito
•Integração com TravisCI ###

