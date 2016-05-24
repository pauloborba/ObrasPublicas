@ignore
Feature: politico
  As a usuario do sistema
  I want to adicionar, remover, modificar e visualizar politicos no sistema
  so that eu posso gerar paginas web para exibir informacoes sobre o politico


  Scenario: adicionar politico nao existente
    Given o sistema nao tem um politico com nome “Eduardo” e CPF "01234567890”
    When eu tentar cadastrar um politico com o nome “Eduardo” e CPF “01234567890”
    Then o sistema ira cadastrar o politico com o nome “Eduardo” e CPF “01234567890”

  Scenario: adicionar politico existente
    Given o sistema tem um politico com nome “Eduardo” e CPF "01234567890”
    When eu tentar cadastrar um politico com o nome “Eduardo” e CPF “01234567890”
    Then o sistema nao ira cadastrar o politico

  Scenario: atualizar politico
    Given que exista um politico com nome “Eduardo” e CPF "01234567890”
    When eu tentar atualizar os dados do politico  com nome “Eduardo” e CPF "01234567890”
    Then o sistema ira atualizar o politico


  Scenario: remover politico existente
    Given o sistema tem um politico com nome “Eduardo” e CPF "01234567890”
    When eu tentar remover o politico com o nome “Eduardo” e CPF “01234567890”
    Then o sistema ira mostrar a mensagem politico "Eduardo" de CPF “01234567890” removido com sucesso







  Scenario: novo politico
    Given que eu estou no menu “Politicos”
    And nao existe nenhum politico com o nome “Anderson” com o CPF “102.102.152-15”
    When eu seleciono a opcao “Cadastrar”
    And eu tento cadastrar o politico “Anderson” com CPF “102.102.152-15” e seleciono “Salvar”
    Then eu recebo a mensagem de confirmacao
    And Consigo ver as informacoes do politico cadastrado

  Scenario: visualizar politico
    Given que o visitante “Guilherme” esta no Menu “politicos”
    And o politico  “Anderson”  com o CPF “102.102.152-15” esta armazenado no sistema
    When “Guilherme” tenta visualizar o politico  “Anderson”  com o CPF “102.102.152-15”
    Then “Guilherme” conseguira visualizar as informacoes

  Scenario: editar informacoes de um politico
    Given que o usuario esta na tela de atualizar politico visualizando o  politico “Eduardo” com cpf “01234567890”
    When ao  tentar atualizar os dados do politico “Eduardo” com cpf “01234567890”
    Then eu recebo a mensagem de confirmacao
    And Consigo ver as informacoes do politico cadastrado
