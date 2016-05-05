Feature Políticos:
  As a usuário do sistema
  I want to adicionar, remover, modificar e visualizar políticos no sistema
  So That eu posso gerar páginas web para exibir informações sobre o político

#CONTROLLER
  Scenario: Adicionar político não existente
    Given o sistema não tem um político com nome “Eduardo” e CPF "01234567890”
    When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
    Then o sistema irá cadastrar o político com o nome “Eduardo” e CPF “01234567890”

  Scenario: Adicionar político existente
    Given o sistema tem um político com nome “Eduardo” e CPF "01234567890”
    When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
    Then o sistema não irá cadastrar o político

Scenario: Atualizar político
Given que exista um politico com nome “Eduardo” e CPF "01234567890”
When eu tentar atualizar os dados do político  com nome “Eduardo” e CPF "01234567890”
Then o sistema irá atualizar o político


Scenario: Remover político existente 
Given o sistema tem um político com nome “Eduardo” e CPF "01234567890”
When eu tentar remover o político com o nome “Eduardo” e CPF “01234567890”
Then o sistema ira mostrar a mensagem politico "Eduardo" de CPF “01234567890” removido com sucesso



#GUI
  Scenario: Novo político
    Given que eu estou no menu “Políticos”
    And não existe nenhum político com o nome “Anderson” com o CPF “102.102.152-15”
    When eu seleciono a opção “Cadastrar”
    And eu tento cadastrar o político “Anderson” com CPF “102.102.152-15” e seleciono “Salvar”
    Then eu recebo a mensagem de confirmação
    And Consigo ver as informações do político cadastrado

  Scenario Visualizar político
    Given que o visitante “Guilherme” está no Menu “políticos”
    And o político  “Anderson”  com o CPF “102.102.152-15” está armazenado no sistema
    When “Guilherme” tenta visualizar o político  “Anderson”  com o CPF “102.102.152-15”
    Then “Guilherme” conseguirá visualizar as informações

<<<<<<< HEAD
Scenario: Visualizar político
Given: que o visitante “Guilherme” está no Menu “políticos”
And: o político  “Anderson”  com o CPF “102.102.152-15” está armazenado no
sistema
When: “Guilherme” tenta visualizar o político  “Anderson”  com o CPF
“102.102.152-15”
Then: “Guilherme” conseguirá visualizar as informações

Scenario: Editar informações de um politico 
    Given que o usuário esta na tela de atualizar político visualizando o  político “Eduardo” com cpf “01234567890”
    When ao  tentar atualizar os dados do político “Eduardo” com cpf “01234567890”
	Then: eu recebo a mensagem de confirmação
	And: Consigo ver as informações do político cadastrado
=======
  Scenario: Editar informações de um politico
    Given que o usuário esta na tela de atualizar político visualizando o  político “Eduardo” com cpf “01234567890”
    When ao  tentar atualizar os dados do político “Eduardo” com cpf “01234567890”
    Then eu recebo a mensagem de confirmação
    And Consigo ver as informações do político cadastrado
>>>>>>> 490963de3699a4b0dc7ea52f0ef3764b4efeb5c6
