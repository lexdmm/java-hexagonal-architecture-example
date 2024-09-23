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
├── adapters
│   └── inbound
│       └── rest
│           └── UserController.java // Controller com operações CRUD
│   └── outbound
│       └── database
│           └── UserRepositoryImpl.java // *Removido* já que o JpaRepository gerencia isso
│       └── message
│           └── KafkaProducer.java  // Produtor de mensagens Kafka (opcional)
├── application
│   └── ports
│       └── input
│           └── RegisterUserUseCase.java  // Port de entrada para registro de usuário
│       └── output
│           └── UserRepository.java // Port de saída com JpaRepository para PostgreSQL
├── core
│   └── domain
│       └── User.java               // Entidade User
│   └── usecase
│       └── RegisterUser.java       // Caso de uso: RegisterUser
├── Application.java                // Classe principal do Spring Boot
└── pom.xml                         // Configurações do Maven e dependências

```
