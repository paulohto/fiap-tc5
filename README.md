# Tech Challenge 

Bem-vindo(a) a documentação oficial desenvolvida para este Tech Challenge.

## Link do Repositório

- [Tech Challenge](https://github.com/JoneyPereira/fiap-tc5)

## Tecnologias e Ferramentas
- Java 17 e 21
- Maven
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger
- Spring Web
- Postman
- IntelliJ
- Git
- GitHub
- Docker

## Como inicar o projeto

Para inicar o projeto, utilize o `maven`. Caso não tenha o Maven instalado, você pode utilizar o wrapper que
acompanha o projeto. Neste caso, entre na pasta raiz de cada Serviço e utilize o comando `./mvnw`.
É necessário estar com `Docker` rodando para conexão com banco de dados.

| Comando                  | Descrição                       | Requisitos                  |
|--------------------------|---------------------------------|-----------------------------|
| `docker-compose up -d`   | Subir os serviços da aplicação  | Docker instalado na máquina |
| `./mvnw spring-boot:run` | Roda a aplicação localmente     | Postgres rodando            |

## Diagramas
![arquitetura](arquitetura.png)

--------------------------------------------------------------------------------------------
### tc5-login-users

| Método | Url          | Descrição               |
|--------|--------------|-------------------------|
| GET    | /torres/{id} | Get Torre Por ID        |
| PUT    | /torres/{id} | Atualiza Torre Por ID   |
| DELETE | /torres/{id} | Deleta Torre Por ID     |
| GET    | /torres      | Get All Torres          |
| POST   | /torres      | Cadastra uma nova Torre |


### Exemplos de entrada

##### <a>GET - /torres/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/torres/1'
```

##### <a>PUT - /torres/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'localhost:3000/torres/1' \
--header 'Content-Type: application/json' \
--data '{
    "nome":"Torre C"
}'
```

##### <a>DELETE - /torres/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request DELETE 'localhost:3000/torres/1'
```

##### <a>GET - /torres</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/torres'
```

##### <a>POST - /torres</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/torres' \
--header 'Content-Type: application/json' \
--data '{
    "nome":"Torre B",
    "localidadeId":1
}'
```
--------------------------------------------------------------------------------------------
### tc5-api-products

| Método | Url                           | Descrição                  |
|--------|-------------------------------|----------------------------|
| GET    | /reservas/{reservaId}         | Get Reserva Por ID         |
| PUT    | /reservas/{reservaId}         | Atualiza Reserva Por ID    |
| DELETE | /reservas/{reservaId}         | Deleta Reserva Por ID      |
| POST   | /reservas                     | Cria nova Reserva          |
| GET    | /reservas                     | Get All Reservas           |
| GET    | /reservas/cliente/{clienteId} | Get Reserva Por Cliente ID |


### Exemplos de entrada

##### <a>GET - /reservas/{reservaId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/reservas/970d66b4-16f1-46c0-8c79-b42ebd3a644d'
```

##### <a>PUT - /reservas/{reservaId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'localhost:3000/reservas/970d66b4-16f1-46c0-8c79-b42ebd3a644d' \
--header 'Content-Type: application/json' \
--data-raw '{
    "clienteEmail": "elinore.Wehner@example.com",
    "quartos": [
        1
    ],
    "dataCheckIn": "2024-04-23",
    "dataCheckOut": "2024-04-24",
    "adicionalList": {
        "café": 5,
        "refrigerante": 2
    }
}'
```

##### <a>DELETE - /reservas/{reservaId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request DELETE 'localhost:3000/reservas/970d66b4-16f1-46c0-8c79-b42ebd3a644d'
```

##### <a>POST - /reservas</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/reservas/novo' \
--header 'Content-Type: application/json' \
--data-raw '{
  "clienteEmail": "Elinore.Wehner@example.com",
  "quartos": [
    1
  ],
  "dataCheckIn": "2024-04-23",
  "dataCheckOut": "2024-04-24",
  "adicionalList": {
    "café": 1,
    "refrigerante": 2
  }
}'
```

##### <a>GET - /reservas</a> 
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/reservas'
```

##### <a>GET - /reservas/cliente/{clienteId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/reservas/cliente/2'
```
--------------------------------------------------------------------------------------------
### tc5-api-carts

| Método | Url                 | Descrição                                              |
|--------|---------------------|--------------------------------------------------------|
| GET    | /quartos/{quartoId} | Get Quarto Por ID                                      |
| PUT    | /quartos/{quartoId} | Atualiza Qaurto Por ID                                 |
| DELETE | /quartos/{quartoId} | Deleta Quarto Por ID                                   |
| POST   | /quartos/novo       | Cria Novo Quarto                                       |
| GET    | /quartos            | Get All Quartos                                        |
| GET    | /quartos/tipoquarto | Categorias de Quarto Disponiveis ex: "Luxo","Standard" |
| GET    | /quartos/busca      | Get Quarto Por Categoria ex: "Luxo","Standard"         |
| GET    | /quartos/amenidades | Get Amenidades disponiveis ex: "TV","Poltrona"         |

### Exemplos de entrada

##### <a>GET - /quartos/{quartoId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/quartos/1'
```


##### <a>PUT - /quartos/{quartoId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'localhost:3000/quartos/1' \
--header 'Content-Type: application/json' \
--data '{
    "tipoQuarto": "LUXO",
    "amenidades": [
        "AR_CONDICIONADO",
        "FRIGOBAR",
        "BANHEIRA",
        "VARANDA"
    ]
}'
```
##### <a>DELETE - /quartos/{quartoId}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request DELETE 'localhost:3000/quartos/1'
```
##### <a>POST - /quartos/novo</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/quartos/novo' \
--header 'Content-Type: application/json' \
--data '{
  "tipoQuarto": "LUXO",
  "amenidades": [
    "TV",
    "AR_CONDICIONADO",
    "FRIGOBAR",
    "BANHEIRA",
    "MESA_ESCRITORIO",
    "VARANDA"
  ]
}'
```
##### <a>GET - /quartos</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/quartos'
```
##### <a>GET - /quartos/tipoquarto</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/quartos/tipoquarto'
```
##### <a>GET - /quartos/busca</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/quartos/busca?tipoQuarto=LUXO'
```
##### <a>GET - /quartos/amenidades</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/quartos/amenidades'
```
--------------------------------------------------------------------------------------------
### tc5-payments

| Método | Url               | Descrição                  |
|--------|-------------------|----------------------------|
| GET    | /localidades/{id} | Get Localidade Por ID      |
| PUT    | /localidades/{id} | Atualiza Localidade Por ID |
| DELETE | /localidades/{id} | Deleta Localidade Por ID   |
| GET    | /localidades      | Get All Localidades        |
| POST   | /localidades      | Cria Localidade            |

### Exemplos de entrada

##### <a>GET - /localidades/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/localidades/1'
```
##### <a>PUT - /localidades/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request PUT 'localhost:3000/localidades/1' \
--header 'Content-Type: application/json' \
--data '{
    "id":1,
    "nome":"Ibis Interlagos",
    "endereco":"Av. Interlagos, 5111"
}'
```
##### <a>DELETE - /localidades/{id}</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location --request DELETE 'localhost:3000/localidades/1'
```
##### <a>GET - /localidades</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/localidades'
```
##### <a>POST - /localidades</a>
![Uses Curl](https://img.shields.io/badge/Curl-Uses-green)
```bash
curl --location 'localhost:3000/localidades' \
--header 'Content-Type: application/json' \
--data '{
    "nome":"Ibis Interlagos",
    "endereco":"Av. Interlagos, 5847"
}'
```