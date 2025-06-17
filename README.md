# Taskey

Taskey é um gerenciador de tarefas construído com Spring Boot, inspirado na ideia de que cada tarefa é uma chave para o progresso. Desenvolvido como projeto acadêmico com foco em boas práticas de camadas, JPA e tratamento de exceções.

## Tecnologias

- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 Database (banco em memória)  
- Maven  

## Funcionalidades

- CRUD completo para entidade User (Create, Read, Update, Delete)  
- Estrutura em camadas: Repository, Service, Resource (Controller)  
- Tratamento de exceções com exceção personalizada e handler global  
- Banco H2 configurado para perfil de teste  
- Dados iniciais populados para testes (Maria Brown e Alex Green)  

## Como executar

1. Clone o repositório:  
   ```bash
   git clone https://github.com/calloc2/taskey/
2. Abra no IntelliJ IDEA ou sua IDE favorita

3. Execute a classe principal TaskeyApplication.java

4. A API estará disponível em http://localhost:8080/users

## Endpoints disponíveis

| Método | Endpoint    | Descrição                |
| ------ | ----------- | ------------------------ |
| GET    | /users      | Listar todos os usuários |
| GET    | /users/{id} | Buscar usuário por ID    |
| POST   | /users      | Criar novo usuário       |
| PUT    | /users/{id} | Atualizar usuário        |
| DELETE | /users/{id} | Deletar usuário          |
