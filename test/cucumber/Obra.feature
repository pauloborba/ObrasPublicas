Feature: obra
  As a usuario do sistema
  I want to adicionar, remover, modificar e visualizar obras no sistema
  so that eu posso gerar paginas web para exibir informacoes sobre a obra


Scenario: adicionar obra nao existente
  Given que o sistema nao tem uma obra chamada "Praca do arsenal"
  When eu tentar cadastrar uma obra com o nome "Praca do arsenal"
  Then o sistema ira cadastrar a obra de nome "Praca do arsenal"

Scenario: adicionar obra existente
  Given que o sistema tem uma obra chamada "Praca do arsenal"
  When eu tentar cadastrar uma obra com o nome "Praca do arsenal"
  Then o sistema nao ira cadastrar a obra de nome "Praca do arsenal"

Scenario: visualizar obra
  Given que um visitante esta logado no sistema
  And  o sistema tem uma obra com o nome "Praca do arsenal"
  When ele tentar visualizar a obra com o nome "Praca do arsenal"
  Then o sistema mostrara as informacoes relacionadas a obra

Scenario: atualizar obra
  Given que existe uma obra no sistema chamada "Praca do Arsenal"
  When eu tentar atualizar os dados da obra com o nome "Praca do Arsenal"
  Then o sistema atualiza a obra

Scenario: remover obra nao existente
  Given que o sistema nao tem uma obra chamada "Praca do arsenal"
  When eu tentar remover a obra com o nome "Praca do arsenal"
  Then o sistema nao ira remover

Scenario: remover obra existente
  Given que o sistema tem uma obra chamada "Praca do arsenal"
  When eu tentar remover a obra com o nome "Praca do arsenal"
  Then o sistema ira remover a obra







Scenario: receber atualizacoes da obra por email
  Given  eu estou visualizando a obra "Praca do arsenal"
  When eu seleciono a opcao "Receber atualizacao por email"
  And preencho o campo de email com o email "teste@obralimpa.com"
  Then eu vejo uma mensagem de confirmacao
  And passo a receber o relatorio de alteracoes da obra no email "teste@obralimpa.com"

Scenario: visualizar obra
  Given que o usuario esta no menu de obras e quer visualizar os detalhes da obra "Praca do arsenal"
  When o usuario seleciona a obra "Praca do arsenal"
  Then o sistema exibe os detalhes da obra "Praca do arsenal"

Scenario: nova pagina de obra
  Given eu estou no menu de "obras"
  And nao existe uma obra com nome "Praca do Arsenal" na lista de obras
  When eu seleciono a opcao "Cadastrar"
  And eu tento cadastrar a obra com o nome "Praca do Arsenal"
  And seleciono a opcao "Salvar"
  Then eu recebo uma mensagem de confirmacao
  And vejo o nome "Praca do arsenal"

Scenario: compartilhar obra na rede social
  Given eu estou visualizando a obra "Praca do Arsenal"
  When  eu seleciono a opcao Compartilhar na Rede Social com o email "teste@teste.com" e senha "senha"
  Then eu vejo uma mensagem de confirmacao
  And passo visualizar na minha rede social a postagem com o nome "Praca do Arsenal"