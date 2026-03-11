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

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   https://gutendex.com/books/?search=dom+casmurro   `

📂 Estrutura do Projeto
=======================

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   literalura│├── src│   ├── main│   │   ├── java│   │   │   └── com.literalura│   │   │       ├── model│   │   │       ├── repository│   │   │       ├── service│   │   │       ├── dto│   │   │       └── principal│   │   ││   │   └── resources│   │       ├── application.properties│   │├── pom.xml└── README.md   `

⚙️ Configuração do Projeto
==========================

### 1️⃣ Clonar o repositório

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   git clone https://github.com/seu-usuario/literalura.git   `

Entrar na pasta do projeto:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   cd literalura   `

### 2️⃣ Configurar o banco de dados

No arquivo **application.properties** configure seu banco:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   spring.datasource.url=jdbc:postgresql://localhost:5432/literaluraspring.datasource.username=seu_usuariospring.datasource.password=sua_senhaspring.jpa.hibernate.ddl-auto=updatespring.jpa.show-sql=true   `

### 3️⃣ Instalar dependências

Se estiver usando Maven:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   mvn install   `

### 4️⃣ Executar o projeto

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   mvn spring-boot:run   `

Ou execute pela sua IDE (IntelliJ / VSCode).

🖥️ Como usar
=============

Ao executar a aplicação, será exibido um **menu interativo no console** com opções como:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   1 - Buscar livro pelo título2 - Listar livros registrados3 - Listar autores registrados4 - Listar autores vivos em determinado ano5 - Listar livros por idioma0 - Sair   `

Basta selecionar a opção desejada e seguir as instruções.

📊 Exemplo de busca
===================

Entrada:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   Digite o nome do livro:Dom Casmurro   `

Saída:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   Livro encontrado:Título: Dom CasmurroAutor: Machado de AssisIdioma: ptDownloads: 5421   `

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

Desenvolvido por **Bela**

📎 GitHub: 

📎 LinkedIn:
