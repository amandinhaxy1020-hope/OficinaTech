# OficinaTech

Sistema de gestão para pequenas oficinas/torneadoras, desenvolvido como projeto de extensão em Análise e Desenvolvimento de Sistemas.

## Objetivo

Substituir controles manuais (caderno, WhatsApp, memória) por uma solução digital simples e segura, ajudando a oficina a:

- Cadastrar clientes e serviços
- Acompanhar o andamento dos serviços com código único de rastreio
- Permitir que o cliente acompanhe seu próprio serviço, sem login
- Controlar entrada/saída de materiais com alerta de estoque baixo
- Registrar resíduos gerados, promovendo educação ambiental
- Aproximar usuários com pouca familiaridade tecnológica de uma ferramenta digital

## Tecnologias

- **Back-end:** Java 21 + Spring Boot
- **Banco de dados:** PostgreSQL (hospedado no Neon)
- **Front-end:** Thymeleaf + HTML/CSS (mobile-first)
- **Segurança:** Spring Security + hash de senha com BCrypt
- **Versionamento:** Git + GitHub

## Perfis de acesso

**Administrador/funcionário:** login com e-mail e senha, acesso ao painel interno (clientes, serviços, materiais, resíduos).

**Cliente:** sem login — consulta o andamento do próprio serviço apenas com o código de acompanhamento (ex: `OFI-A82K91`), sem acesso a dados de outros clientes ou informações internas.

## Como rodar o projeto

1. Configure a variável de ambiente `DB_PASSWORD` com a senha do banco PostgreSQL
2. Rode: `mvn spring-boot:run`
3. Acesse `/login` para a área administrativa, ou `/acompanhar` para a consulta pública

### Acesso administrativo

Para executar o projeto localmente, configure um usuário administrador
de demonstração por meio das variáveis/configurações do ambiente.

Não são disponibilizadas credenciais reais neste repositório.

⚠️ Trocar essa senha antes de qualquer uso real.

## Estrutura do sistema

## Segurança

- Senhas armazenadas com hash BCrypt, nunca em texto puro
- Código de acompanhamento gerado aleatoriamente, não sequencial
- Rotas administrativas protegidas por autenticação
- Cliente não tem acesso a nenhum dado interno ou de outros clientes
- Credenciais do banco de dados nunca versionadas — carregadas via variável de ambiente

## Contexto acadêmico

Este sistema é parte de um projeto de extensão universitária, aplicando conceitos de análise de sistemas, desenvolvimento de software, banco de dados, segurança, usabilidade e educação ambiental em uma necessidade real de uma pequena oficina da comunidade.
