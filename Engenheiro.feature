Feature: Engenheiros
  As a usuário do sistema
  I want to adicionar, remover, modificar e visualizar engenheiros no sistema
  So That eu posso gerar páginas web para exibir informações sobre do engenheiro

  #CONTROLLER
   Scenario: Adicionar engenheiro nao existente
    Given que o sistema nao tem um engenheiro com CPF "01234567891" 
      When eu tentar cadastrar um engenheiro com CPF "01234567891"
    Then o sistema ira cadastrar o engenheiro de CPF "01234567891"

  Scenario: Adicionar um engenheiro existente
    Given que o sistema tem um engenheiro de CPF "98765432109" 
    When eu tentar cadastrar um engenheiro de cpf "98765432109"
    Then o sistema nao ira cadastrar o engenheiro de CPF "98765432109"

  Scenario: Visualizar obras associadas a engenheiro em ordem alfabetica como default
    Given que o sistema possui o engenheiro "José da Silva" de CPF "123456789-01"
    And "José da Silva" possui a obra "Praça do Arsenal"
    And a obra "Praça dos Dogs"
    When eu solicito a lista de obras do engenheiro "José da Silva"
    Then o sistema retorna uma lista com a obra "Praça do Arsenal" encontrando-se primeiro do que a obra "Praça dos Dogs"

  Scenario: Retornar taxa de obras atrasadas de um engenheiro
    Given que o sistema possui o engenheiro "José da Silva" de CPF "123456789-01"
    And o sistema tem 5 obras associadas ao engenheiro de CPF "123456789-01"
    And o sistema tem 2 obras atrasadas associadas ao engenheiro de CPF "123456789-01"
    When eu solicito a taxa de obras atrasadas do engenheiro de CPF "123456789-01"
    Then o sistema retorna uma taxa de 40% de obras atrasadas

  Scenario: Verificar status de um engenheiro
    Given que o sistema possui o engenheiro "José da Silva" de CPF "123456789-01"
    And o engenheiro de CPF "123456789-01" possui 2 obras irregulares
    When eu tento verificar o status do engenheiro de CPF "123456789-01"
    Then o sistema retorna "Irregular" como status

  //Feature adição e atualização de engenheiros

  Scenario: Adicionar engenheiro com CPF digitado incorretamente
    Given o sistema só aceita CPF no formato "123456789-01" contendo 11 números
    When eu tento adicionar um engenheiro com CPF "123456789-ab"
    Then o sistema não adiciona o engenheiro
    And retorna uma mensagem de erro

  Scenario: Atualizar engenheiro com CPF de engenheiro já existente
    Given o sistema possui o engenheiro "José da Silva" com CPF "12345678-01"
    And o sistema possui "Maria do Carmo" de CPF "120456780-01"
    When eu tento atualizar o engenheiro "José da Silva" com o CPF "120456780-01"
    Then o sitema não atualiza e o CPF de "José da Silva" é "123456789-01"

  Scenario: Atualizar enhenheiro com obra já finalizada
    Given o sistema possui o engenheiro "José da Silva" com CPF "123456789-01"
    And exista a obra "Praça dos Dogs" associada ao engenheiro de CPF "123456789-01"
    And existe a obra "Praça do Arsenal" com status "Finalizada"
    When eu tento trocar a obra "Praça dos Dogs" pela obra "Praça do Arsenal" nas informações do engenheiro "José da Silva" de CPF "123456789-01"
    Then o sistema não atualiza as informações do engenheiro de CPF "123456789-01"

  Scenario: Associar obra já finalizada a um engenheiro
    Given o sistema possui o engenheiro "José da Silva" com CPF "123456789-01"
    And existe a obra "Praça dos Dogs" com status "Finalizada"
    When eu tento associar a obra "Praça dos Dogs" ao engenheiro de CPF "123456789-01"
    Then o sistema não associa a obra ao engenheiro


  #Gui
  Scenario: Novo engenheiro
    Given que eu estou no menu “Engenheiro”
    And não existe nenhum engenheiro com o nome “Anderson” com o CPF “102.102.152-15”
    When eu seleciono a opção “Cadastrar”
    And eu tento cadastrar o Engenheiro “Anderson” com CPF “102.102.152-15” e seleciono “Salvar”
    Then eu recebo a mensagem de confirmação
    And Consigo ver as informações do engenheiro cadastrado

  Scenario: Editar informações de um engenheiro
    Given que o usuário esta na tela de atualizar engenheiro visualizando o engeheiro “Eduardo” com cpf “01234567890”
    When ao  tentar atualizar os dados do engenheiro “Eduardo” com cpf “01234567890”
    Then eu recebo a mensagem de confirmação
    And Consigo ver as novas informações do engenheiro cadastrado