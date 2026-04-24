# Projeto didatico: Spring Data JPA + H2 + Entity Usuario

Este projeto foi criado para demonstrar, da forma mais simples possivel, que:

- uma classe anotada com `@Entity` ja pode ser mapeada pelo Hibernate;
- o ORM pode gerar a tabela automaticamente;
- e a estrutura pode ser visualizada no `H2 Console`;
- tudo isso mesmo antes de criar `Repository`, `Service` ou `Controller`.

## Estrutura do projeto

```text
src/main/java/com/exemplo/usuariosimples
 ├── UsuarioSimplesApplication.java
 └── domain
     └── Usuario.java
```

## Dependencias principais do `pom.xml`

- `spring-boot-starter-data-jpa`: ativa JPA + Hibernate
- `h2`: banco em memoria
- `spring-boot-starter-web`: incluido apenas para permitir abrir o H2 Console no navegador
- `spring-boot-starter-test`: teste basico de contexto

## Classe Entity

A classe `Usuario` fica no package `domain` e possui:

- `@Entity`: diz que a classe representa uma tabela
- `@Table(name = "usuarios")`: define o nome da tabela
- `@Id`: chave primaria
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`: id automatico
- `@Column`: regras simples de coluna

## application.properties em destaque

```properties
server.port=8081

spring.datasource.url=jdbc:h2:mem:usuariosdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### O que cada bloco faz

#### 1. Porta da aplicacao

```properties
server.port=8081
```

Sobe a aplicacao na porta 8081.

#### 2. Datasource H2

```properties
spring.datasource.url=jdbc:h2:mem:usuariosdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

Cria um banco H2 em memoria chamado `usuariosdb`.

#### 3. H2 Console

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Permite acessar o navegador em:

```text
http://localhost:8081/h2-console
```

#### 4. JPA / Hibernate

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

- `ddl-auto=update`: cria/atualiza a tabela com base na `@Entity`
- `show-sql=true`: mostra SQL no console
- `format_sql=true`: formata melhor a saida

## Como executar no IntelliJ

### 1. Abrir o projeto

- `File > Open`
- selecione a pasta do projeto
- aguarde o Maven baixar as dependencias

### 2. Rodar a aplicacao

Execute a classe:

```text
UsuarioSimplesApplication
```

Ou use o Maven:

```bash
mvn spring-boot:run
```

## Como testar no H2 Console

Depois de subir a aplicacao, abra:

```text
http://localhost:8081/h2-console
```

Use estes dados:

- **JDBC URL:** `jdbc:h2:mem:usuariosdb`
- **User Name:** `sa`
- **Password:** deixe em branco

## Consultas SQL para testar

### Ver as tabelas

```sql
SHOW TABLES;
```

### Ver a estrutura da tabela

```sql
SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'USUARIOS';
```

### Consultar dados

```sql
SELECT * FROM USUARIOS;
```

## O que observar no console da aplicacao

Ao iniciar, voce deve ver logs relacionados a:

- inicializacao do Tomcat
- conexao H2
- Hibernate/JPA
- criacao ou atualizacao da tabela

Exemplos de pontos importantes:

```text
Tomcat initialized with port 8081 (http)
HikariPool - Added connection conn... url=jdbc:h2:mem:usuariosdb
```

## Observacao didatica importante

Neste projeto nao existe `Repository` de proposito.

A ideia e mostrar que:

```text
@Entity + JPA + Hibernate + application.properties = tabela gerada no banco
```

Ou seja, a `Repository` nao cria a tabela. Ela sera util depois para manipular os dados.

## Proxima evolucao sugerida

1. adicionar `UsuarioRepository extends JpaRepository<Usuario, Long>`
2. criar `Service`
3. criar `Controller`
4. expor endpoints REST

