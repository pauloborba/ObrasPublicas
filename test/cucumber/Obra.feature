Feature Obras:
  As a usuário do sistema
  I want to adicionar, remover, modificar e visualizar obras no sistema
  So That eu posso gerar páginas web para exibir informações sobre a obra

#CONTROLLER
Scenario: Visualizar obra
Given que um visitante está logado no sistema como “Guilherme”
And o sistema tem uma obra com o nome “Praça do arsenal”
When ele tentar visualizar a obra com o nome “Praça do arsenal”
Then o sistema mostrará as informações relacionadas a obra

Scenario: Atualizar obra
Given que eu estou logado no sistema como “administrador”
And existe uma obra no sistema chamada “Praça do Arsenal”
When eu tentar atualizar os dados da obra com o nome “Praça do Arsenal”
Then o sistema irá atualizar a obra
And exibir uma mensagem de confirmação

#GUI
Scenario: Nova página de obra
Given eu estou no menu de “obras”
And não existe uma obra com nome “Praça do Arsenal” na lista de obras
When eu seleciono a opção “Cadastrar”
And eu tento cadastrar a obra com o nome “Praça do Arsenal”
And seleciono a opção “Salvar”
Then eu recebo uma mensagem de confirmação
And vejo o nome “Praça do arsenal”

Scenario: compartilhar obra no facebook
Given eu esteja visualizando uma obra com o nome “Praça do Arsenal”
When  eu selecionar a opção “compartilhar no facebook “
And  preencher os campos do facebook
Then eu recebo uma mensagem de confirmação