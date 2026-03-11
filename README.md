📚 Literalura
=============

Literalura é uma aplicação backend desenvolvida em **Java com Spring Boot** que permite buscar livros em uma API pública, armazenar as informações em um banco de dados e realizar consultas sobre autores, livros e idiomas.

O sistema foi desenvolvido com foco em **consumo de APIs externas, persistência de dados e organização em camadas**, seguindo boas práticas de desenvolvimento backend.

🚀 Funcionalidades
==================

A aplicação permite:

*   🔎 Buscar livros pelo título através de uma API externa
    
*   💾 Salvar livros encontrados no banco de dados
    
*   👩‍💻 Listar todos os livros registrados
    
*   ✍️ Listar autores cadastrados
    
*   📅 Listar autores vivos em determinado ano
    
*   🌎 Listar livros por idioma
    
*   📊 Consultar estatísticas sobre livros cadastrados
    

🛠️ Tecnologias Utilizadas
==========================

*   **Java 17**
    
*   **Spring Boot**
    
*   **Spring Data JPA**
    
*   **Hibernate**
    
*   **PostgreSQL** (ou H2)
    
*   **Maven**
    
*   **API Gutendex** (API pública de livros)
    
*   **Jackson** (conversão de JSON)
    

🌐 API Utilizada
================

O projeto consome a API pública:

🔗 [https://gutendex.com](https://gutendex.com)

Essa API fornece informações sobre livros do **Projeto Gutenberg**, incluindo:

*   título
    
*   autor
    
*   idioma
    
*   número de downloads
    

Exemplo de endpoint utilizado:
https://gutendex.com/books/?search=dom+casmurro

📂 Estrutura do Projeto
=======================

literalura
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.literalura
│   │   │       ├── model
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       ├── dto
│   │   │       └── principal
│   │   │
│   │   └── resources
│   │       ├── application.properties
│   │
├── pom.xml
└── README.md

⚙️ Configuração do Projeto
==========================

### 1️⃣ Clonar o repositório

git clone https://github.com/seu-usuario/literalura.git

Entrar na pasta do projeto:

cd literalura`

### 2️⃣ Configurar o banco de dados

No arquivo **application.properties** configure seu banco:

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true`

### 3️⃣ Instalar dependências

Se estiver usando Maven:

mvn install`

### 4️⃣ Executar o projeto

mvn spring-boot:run`

Ou execute pela sua IDE (IntelliJ / VSCode).

🖥️ Como usar
=============

Ao executar a aplicação, será exibido um **menu interativo no console** com opções como:

1 - Buscar livro pelo título
2 - Listar livros registrados
3 - Listar autores registrados
4 - Listar autores vivos em determinado ano
5 - Listar livros por idioma
0 - Sair

Basta selecionar a opção desejada e seguir as instruções.

📊 Exemplo de busca
===================

Entrada:

Digite o nome do livro:
Dom Casmurro`

Saída:

Livro encontrado:
Título: Dom Casmurro
Autor: Machado de Assis
Idioma: pt
Downloads: 5421  `

🧠 Conceitos aplicados
======================

Este projeto aplica diversos conceitos importantes de backend:

*   Consumo de **API REST**
    
*   Conversão de **JSON para objetos Java**
    
*   Uso de **DTOs**
    
*   **Persistência de dados com JPA**
    
*   Relacionamento entre entidades
    
*   Organização em **camadas (Controller, Service, Repository)**
    
*   Uso de **Streams e Optional**
    

📌 Melhorias Futuras
====================

Algumas melhorias que podem ser implementadas:

*   Criar interface **REST API** (Controller)
    
*   Criar **frontend para visualização**
    
*   Implementar **filtros avançados**
    
*   Adicionar **paginação**
    
*   Implementar **testes automatizados**
    

👩‍💻 Autora
============

Desenvolvido por **Isabela**

📎 GitHub: https://github.com/isacosta15

📎 LinkedIn: https://www.linkedin.com/in/isabela-nunes-dev/
