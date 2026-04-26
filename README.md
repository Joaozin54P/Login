# 🔐 API de Login - Spring Boot + JWT + MongoDB

Este projeto consiste no desenvolvimento de uma API REST para autenticação de usuários, utilizando **Spring Boot**, **JWT (JSON Web Token)** e **MongoDB**.

A aplicação permite realizar cadastro de usuários, autenticação e geração de token para acesso seguro aos serviços.

---

## 🎯 Objetivo

Desenvolver uma API de autenticação aplicando conceitos de:

* Segurança com JWT
* Criptografia de senha (BCrypt)
* Arquitetura em camadas (Controller, Service, Repository)
* Integração com banco NoSQL (MongoDB)

---

## 🛠 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (jjwt)
* Spring Data MongoDB
* MongoDB
* Postman

---

## 📁 Estrutura do Projeto

```bash
src/main/java/com/fatec/login
│
├── controller     # Recebe as requisições HTTP
├── service        # Regras de negócio
├── repository     # Comunicação com o banco
├── model          # Estrutura do Login
├── dto            # Request e Response
├── security       # JWT e autenticação
└── LoginApplication.java
````

---

## ⚙️ Funcionalidades

✔️ Cadastro de usuário
✔️ Criptografia de senha com BCrypt
✔️ Autenticação de usuário
✔️ Geração de token JWT
✔️ Atualização de dados
✔️ Exclusão de usuário
✔️ Associação do usuário com cliente (`clienteId`)

---

## 🌐 Endpoints da API

### 📌 Cadastro de Usuário

**POST /login**

```json
{
  "username": "joao_teste",
  "password": "123456",
  "role": "USER",
  "email": "joao@email.com",
  "clienteId": "69d71c12e5fd809162c63c63"
}
```

---

### 🔐 Autenticação (Login)

**POST /login/auth**

```json
{
  "username": "joao_teste",
  "password": "123456"
}
```

**Resposta:**

```json
eyJhbGciOiJIUzI1NiJ9...
```

---

### 📋 Listar Usuários

<img width="1095" height="611" alt="image" src="https://github.com/user-attachments/assets/645e6cae-1e30-427b-8007-db1e0226898d" />


---

### 🔄 Atualizar Usuário

<img width="1102" height="491" alt="image" src="https://github.com/user-attachments/assets/f47699a2-504c-4f70-9259-81c16cd45dd2" />


---

### ❌ Deletar Usuário

<img width="1113" height="367" alt="image" src="https://github.com/user-attachments/assets/67d70174-d121-40a9-b743-b0b1e79e7b9f" />


---

### ➕ Cadastro de Login

<img width="1110" height="499" alt="image" src="https://github.com/user-attachments/assets/f75b8536-f7b4-4cda-89e7-f7a4be1a4e44" />


---

### 🔐 Geração de Token

<img width="1121" height="403" alt="image" src="https://github.com/user-attachments/assets/0d96e8c4-c6e9-40f4-9242-f6922bc72634" />


---

## 📌 Observações

* As senhas são armazenadas de forma criptografada (BCrypt)
* O token JWT contém:

  * username
  * role
  * clienteId
* O token possui tempo de expiração
* O sistema segue padrão REST
* Cada usuário pode estar associado a um cliente através do `clienteId`

---

## 👨‍💻 Autores

Projeto desenvolvido por:

* **João Pedro da Silva Machado Felix**
* **Giovanna Aparecida Vivencio Rodrigues**

---

## 🎓 Contexto Acadêmico

Este projeto faz parte de uma arquitetura baseada em microsserviços, composta por:

* 🔐 Login → autenticação e geração de token
* 👤 Cliente → gerenciamento de clientes
* 📦 Produto → lista de compras
* 🌐 Gateway → roteamento das requisições

---

## 🏗 Arquitetura do Projeto

A aplicação segue o padrão de microsserviços, promovendo:

* Separação de responsabilidades
* Segurança com autenticação
* Integração entre serviços
* Organização e escalabilidade

O token JWT permite que outros serviços validem o usuário autenticado.

---

## 🚀 Considerações Finais

Este projeto teve como objetivo aplicar conceitos de autenticação e segurança em APIs REST, utilizando Spring Boot e JWT.

A implementação permitiu consolidar conhecimentos sobre proteção de endpoints, criptografia de dados e integração entre microsserviços.
