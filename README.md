# Patients API

A **Patients API** é uma API RESTful que permite gerenciar o cadastro de pacientes, suas informações básicas, e outras funcionalidades de um sistema hospitalar. A API foi construída utilizando **Spring Boot** e oferece endpoints para o cadastro e consulta de pacientes, além de integração com **Kafka** para envio de notificações quando os dados de um paciente são criados ou modificados.

## Funcionalidades

- **Cadastro de Pacientes**: Permite a criação de pacientes com dados como nome, CPF, endereço e número de contato.
- **Consulta de Pacientes**: Permite buscar pacientes pelo CPF e obter suas informações básicas.
- **Notificação via Kafka**: Envia uma mensagem para o tópico "Hospital" sempre que um novo paciente é cadastrado, para fins de integração com outros sistemas.

## Tecnologias

- **Spring Boot**: Framework para criação de aplicações Java baseadas em microserviços.
- **Kafka**: Sistema de mensageria para a troca de dados entre diferentes partes do sistema.
- **JPA/Hibernate**: Para persistência de dados no banco de dados MySQL.

## Endpoints

### 1. `POST /patients`
Cria um novo paciente.

**Request Body**:
```json 
{
  "name": "João Silva",
  "address": "Rua Exemplo, 123",
  "number": "123456789",
  "cpf": "12345678901"
}

Response:

Status: 201 Created
Body: "Paciente criado com sucesso"
2. GET /patients?cpf={cpf}
Busca um paciente pelo CPF.

Request Param:

cpf: CPF do paciente a ser consultado.
Response:

Status: 200 OK (Caso o paciente seja encontrado)

json
{
  "name": "João Silva",
  "address": "Rua Exemplo, 123",
  "number": "123456789",
  "cpf": "12345678901"
}
```

  Instalação
      1. Clonando o Repositório
      bash
      Copiar
      Editar
    ```  git clone https://github.com/seu-usuario/hospital-api.git
      cd hospital-api
      ```
      2. Configuração do Banco de Dados
      A API utiliza MySQL como banco de dados. Certifique-se de que o MySQL está instalado e em execução. Crie um banco de dados chamado hospital e ajuste as configurações no arquivo application.yml.

      
      yaml
      Copiar
      Editar
      spring:
        datasource:
          url: jdbc:mysql://localhost:3306/hospital?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo
          username: root
          password: sua-senha

          
 3. Executando a API
      Depois de configurar o banco de dados, basta rodar a aplicação com o comando:
      
      bash
      Copiar
      Editar
      mvn spring-boot:run
      A API estará disponível em http://localhost:8080.
      
      Integrações Futuras
      1. Integração com Médicos e Prontuários
      Planejamos futuras integrações com médicos e prontuários para expandir as funcionalidades do sistema hospitalar. A ideia é conectar os médicos aos pacientes, registrando suas especialidades e permitindo que os prontuários dos pacientes sejam atualizados diretamente pelos médicos.
      
      Possíveis Funcionalidades Futuras:
      Cadastro de Médicos: Adicionar um endpoint para cadastrar médicos com informações como nome, especialidade, etc.
      Prontuário Eletrônico: Criar um sistema de prontuário eletrônico, onde médicos podem registrar as consultas, diagnósticos e tratamentos dos pacientes.
      Histórico Médico: Permitir que médicos visualizem o histórico de atendimentos dos pacientes e adicione novos registros no prontuário.
      Notificações de Atendimento: Enviar notificações via Kafka sempre que um médico atender um paciente ou alterar o prontuário.
      2. Fluxo de Trabalho Médico
      Quando um paciente é registrado, ele pode ser associado a um médico responsável.
      O médico pode então acessar e atualizar o prontuário do paciente, registrando informações sobre diagnósticos, tratamentos e prescrições.
      Notificações podem ser enviadas via Kafka para sistemas externos ou outras partes do hospital sempre que um novo diagnóstico for adicionado ou o estado de saúde do paciente mudar.
