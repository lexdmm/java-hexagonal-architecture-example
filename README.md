# Java-hexagonal-architecture-example

Aqui vai um exemplo básico de uma arquitetura hexagonal com três adaptadores em Java usando um projeto de bootstrap para inicialização rápida. Vou focar em um caso simples de uma aplicação de cadastro de usuários, onde temos:

1. Core Domain (Hexágono): As regras de negócio, interfaces e casos de uso.

2. Application Layer: Onde estão os ports (entradas e saídas da aplicação).

3. Adapters (Entradas e Saídas):
  - REST Adapter: Interface para expor a API para o mundo externo (HTTP).
  - Database Adapter: Persistência de dados.
  - Message Adapter: Integração via fila/mensagem (ex.: Kafka).

### Estrutura do Projeto
```
/src
├── core
│   └── domain
│       └── User.java
│   └── usecase
│       └── RegisterUser.java
├── application
│   └── ports
│       └── input
│           └── RegisterUserUseCase.java
│       └── output
│           └── UserRepository.java
├── adapters
│   └── inbound
│       └── rest
│           └── UserController.java
│   └── outbound
│       └── database
│           └── UserRepositoryImpl.java
│       └── message
│           └── KafkaProducer.java
├── Application.java
└── pom.xml
```
