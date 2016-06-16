Feature: Obra
  As a usuario do sistema
  I want to adicionar, remover, modificar e visualizar obras no sistema
  So That eu posso gerar paginas web para exibir informacoes sobre a obra

#CONTROLLER
Scenario: Adicionar obra nao existente
  Given que o sistema nao tem uma obra chamada "Praca do arsenal"
  When eu tentar cadastrar uma obra com o nome "Praca do arsenal"
  Then o sistema ira cadastrar a obra de nome "Praca do arsenal"

Scenario: Adicionar obra existente
  Given que o sistema tem uma obra chamada "Praca do arsenal"
  When eu tentar cadastrar uma obra com o nome "Praca do arsenal"
  Then o sistema nao ira cadastrar a obra de nome "Praca do arsenal"

Scenario: Atualizar obra
  Given que o sistema nao tem uma obra chamada "Praca do arsenal"
  When eu tentar atualizar os dados da obra com o nome "Praca do arsenal"
  Then o sistema atualiza a obra com o nome "Praca do arsenal"

Scenario: Remover obra existente 
    Given que o sistema tem uma obra chamada "Praca do arsenal"
    When eu tentar remover a obra com o nome "Praca do arsenal"
    Then o sistema ira remover a obra com nome "Praca do arsenal"

Scenario: Verificar status andamento obra
    Given que o sistema tem uma obra chamada "Praca atrasada" que esta atrasada mas esta com status "emDia"
    When eu tentar verificar o status da obra com o nome "Praca atrasada"
    Then o sistema ira atualizar obra com nome "Praca atrasada" para "atrasada"

#GUI
Scenario: Receber atualizacoes da obra por email
  Given eu estou visualizando a obra "Praca do arsenal"
  When eu seleciono a opcao "Receber atualizacao por email"
  And preencho o campo de email com o email "teste@obralimpa.com"
  Then eu vejo uma mensagem de confirmacao com o nome "Praca do arsenal" e email "teste@obralimpa.com"

Scenario: Visualizar obra
  Given que o usuario esta no menu de obras e quer visualizar os detalhes da obra "Praca do arsenal"
  When o usuario seleciona a obra "Praca do arsenal"
  Then o sistema exibe os detalhes da obra "Praca do arsenal"

Scenario: Nova pagina de obra
  Given eu estou no menu de obras e nao existe uma obra com nome "Praca do Arsenal" na lista de obras
  When eu seleciono a opcao "Cadastrar"
  And eu tento cadastrar a obra com o nome "Praca do Arsenal"
  And seleciono a opcao "Salvar"
  Then eu vejo uma mensagem de confirmacao com o nome "Praca do arsenal"

Scenario: compartilhar obra na rede social
  Given eu estou visualizando a obra "Praca do arsenal"
  When  eu seleciono a opcao "Compartilhar na Rede Social"
  And preencho os campos com o email "teste@teste.com" e senha "senha"
  Then eu vejo uma mensagem de confirmacao com o nome "Praca do arsenal"
  And passo visualizar na minha rede social a postagem com o nome "Praca do Arsenal"