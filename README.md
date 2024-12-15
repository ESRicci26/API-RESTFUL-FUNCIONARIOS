# Documentação Completa do Projeto

## Introdução
Este projeto consiste em uma aplicação web desenvolvida em **Java Spring Boot**, com suporte para API RESTful e uma interface baseada em **Thymeleaf** para gerenciamento de funcionários. Ele permite operações de **CRUD (Create, Read, Update, Delete)** para dados de funcionários em um banco de dados MySQL.

## Estrutura do Projeto
### Pacotes e Classes

#### Pacote: `com.javaricci.ApiRestfulFuncionarios.Controller`
**Classes:**

1. **`FuncionarioApiController`**
   - Responsável pelos endpoints da API RESTful para gerenciamento de funcionários.
   - **Métodos:**
     - `listarFuncionarios`: Retorna todos os funcionários.
     - `buscarFuncionarioPorId`: Busca um funcionário pelo ID.
     - `salvarFuncionarioApi`: Cria um novo funcionário.
     - `atualizarFuncionario`: Atualiza um funcionário existente pelo ID.
     - `deletarFuncionarioApi`: Exclui um funcionário pelo ID.

2. **`FuncionarioWebController`**
   - Gera as rotas e interações da interface web com suporte às operações de CRUD.
   - **Métodos:**
     - `listarFuncionarios`: Exibe todos os funcionários na interface web.
     - `salvarFuncionario`: Cria um novo funcionário via formulário.
     - `editarFuncionario`: Busca dados para edição de um funcionário existente.
     - `deletarFuncionario`: Remove um funcionário especificado.

#### Pacote: `com.javaricci.ApiRestfulFuncionarios.Entity`
**Classe:** `Funcionario`
- Define o modelo de dados para o funcionário com anotações JPA.
- **Atributos:**
  - `id`: Identificador único (auto incrementado).
  - `nomeCompleto`, `dataNascimento`, `salarioMensal`, `diasTrabalhados`, `jornadaMensal`, `salarioReceber`, `endereco`, `bairro`, `cep`, `cidade`.
- **Métodos:** Getters e Setters.

#### Pacote: `com.javaricci.ApiRestfulFuncionarios.Repository`
**Classe:** `FuncionarioRepository`
- Interface que herda `JpaRepository`, permitindo operações CRUD automáticas no banco de dados.

#### Pacote: `com.javaricci.ApiRestfulFuncionarios.Service`
**Classe:** `FuncionarioService`
- Contém a lógica de negócio.
- **Métodos:**
  - `listarTodos`: Retorna todos os funcionários.
  - `salvar`: Salva ou atualiza um funcionário.
  - `buscarPorId`: Retorna um funcionário pelo ID.
  - `existeId`: Verifica a existência de um ID.
  - `deletar`: Exclui um funcionário pelo ID.

#### Classe Principal
**`ApiRestfulFuncionariosSpringBootApplication`**
- Classe principal que inicia a aplicação Spring Boot.

#### Arquivo de Configuração
**`application.properties`**
- Configurações do banco de dados MySQL.
  - URL: `jdbc:mysql://localhost:3306/apirestfulfuncionarios`.
  - Usuário: `root`.
  - Senha: `EfCr2608`.

#### Frontend (Thymeleaf)
**Arquivo:** `funcionarios.html`
- Formulário e tabela para interações de gerenciamento de funcionários.

---

## Endpoints da API RESTful
### Funcionalidades:

1. **Obter todos os funcionários:**
   - **Método:** GET
   - **URL:** `/api/funcionarios`
   - **Resposta:** Lista de funcionários.

2. **Obter funcionário por ID:**
   - **Método:** GET
   - **URL:** `/api/funcionarios/{id}`
   - **Resposta:** Objeto do funcionário correspondente.

3. **Criar novo funcionário:**
   - **Método:** POST
   - **URL:** `/api/funcionarios`
   - **Corpo:**
     ```json
     {
       "nomeCompleto": "João Silva",
       "dataNascimento": "1990-01-01",
       "salarioMensal": 3000.50
     }
     ```

4. **Atualizar funcionário existente:**
   - **Método:** PUT
   - **URL:** `/api/funcionarios/{id}`
   - **Corpo:**
     ```json
     {
       "id": 1,
       "nomeCompleto": "João Silva Atualizado",
       "salarioMensal": 3500.75
     }
     ```

5. **Excluir funcionário:**
   - **Método:** DELETE
   - **URL:** `/api/funcionarios/{id}`

---

## Guia de Instalação e Execução
### Requisitos:
- **Java JDK 11+**
- **MySQL 5.7+**
- **Maven**

### Passos:
1. Clone o repositório do projeto.
2. Configure o banco de dados MySQL com as credenciais especificadas no `application.properties`.
3. Execute o comando:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a interface web em: `http://localhost:8080/funcionarios`.
5. Acesse a API em: `http://localhost:8080/api/funcionarios`.

---

## Interface Web
**URL:** `http://localhost:8080/funcionarios`

### Funcionalidades:
1. Visualizar todos os funcionários.
2. Adicionar um novo funcionário.
3. Editar ou excluir um funcionário existente.

---

## Tecnologias Utilizadas
1. **Java Spring Boot**
2. **Thymeleaf**
3. **JPA/Hibernate**
4. **MySQL**
5. **Bootstrap**

---

## Exemplos de Uso
### Criação de Funcionário via API
**Requisição:** POST `/api/funcionarios`
```json
{
  "nomeCompleto": "Maria Oliveira",
  "dataNascimento": "1995-05-10",
  "salarioMensal": 4500.00
}
```

**Resposta:**
```json
{
  "id": 5,
  "nomeCompleto": "Maria Oliveira",
  "dataNascimento": "1995-05-10",
  "salarioMensal": 4500.00
}
```

### Edição de Funcionário via Web
1. Clique no botão **Editar** na tabela.
2. Atualize os dados no formulário.
3. Clique em **Salvar**.

---

## Conclusão
Este projeto demonstra como criar uma aplicação completa utilizando Spring Boot e Thymeleaf, com suporte a operações CRUD em uma API RESTful e uma interface web responsiva. A documentação acima cobre todos os aspectos necessários para utilização e manutenção do sistema.
