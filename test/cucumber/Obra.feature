Feature Obra:
  As a usuário do sistema 
  I want to adicionar, remover, modificar e visualizar obras no sistema
  So That eu posso gerar páginas web para exibir informações sobre a obra


#CONTROLLER
Scenario: Adicionar obra não existente
  Given que o sistema não tem uma obra chamada “Praça do arsenal”
  When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
  Then o sistema irá cadastrar a obra de nome "Praça do arsenal"

Scenario: Adicionar obra existente
  Given que o sistema tem uma obra chamada “Praça do arsenal”
  When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
  Then o sistema não irá cadastrar a obra de nome "Praça do arsenal"

Scenario: Visualizar obra
  Given que um visitante está logado no sistema como “guilherme”
  And  o sistema tem uma obra com o nome “Praça do arsenal”
  When ele tentar visualizar a obra com o nome “Praça do arsenal”
  Then o sistema mostrará as informações relacionadas a obra

Scenario: Atualizar obra
  Given que existe uma obra no sistema chamada “Praça do Arsenal”
  When eu tentar atualizar os dados da obra com o nome “Praça do Arsenal”
  Then o sistema atualiza a obra

Scenario: Remover obra não existente 
  Given que eu estou logado no sistema como Administrador e o sistema não tem uma 
    obra chamada “Praça do arsenal”
    When eu tentar remover a obra com o nome “Praça do arsenal”
    Then o sistema não irá remover

Scenario: Remover obra existente 
    Given que eu estou logado no sistema como Administrador e o sistema tem uma 
    obra chamada “Praça do arsenal”
    When eu tentar remover a obra com o nome “Praça do arsenal”
    Then o sistema irá remover a obra


 Scenario: Remover obra nÃ£o existente 
  Given que eu estou logado no sistema como Administrador e o sistema nÃ£o tem uma 
    obra chamada â€œPraÃ§a do arsenalâ€
  When eu tentar remover a obra com o nome â€œPraÃ§a do arsenalâ€
  Then o sistema nÃ£o irÃ¡ remover

Scenario: Remover obra existente 
  Given que eu estou logado no sistema como Administrador e o sistema tem uma 
    obra chamada â€œPraÃ§a do arsenalâ€
  When eu tentar remover a obra com o nome â€œPraÃ§a do arsenalâ€
  Then o sistema irÃ¡ remover a obra

#GUI
<<<<<<< HEAD
Scenario: Nova pÃ¡gina de obra
Given eu estou no menu de â€œobrasâ€
And nÃ£o existe uma obra com nome â€œPraÃ§a do Arsenalâ€ na lista de obras
When eu seleciono a opÃ§Ã£o â€œCadastrarâ€
And eu tento cadastrar a obra com o nome â€œPraÃ§a do Arsenalâ€
And seleciono a opÃ§Ã£o â€œSalvarâ€
Then eu recebo uma mensagem de confirmaÃ§Ã£o
And vejo o nome â€œPraÃ§a do arsenalâ€

Scenario: compartilhar obra no facebook
Given eu esteja visualizando uma obra com o nome â€œPraÃ§a do Arsenalâ€
When  eu selecionar a opÃ§Ã£o â€œcompartilhar no facebook â€œ
And  preencher os campos do facebook
Then eu recebo uma mensagem de confirmaÃ§Ã£o

Scenario: compartilhar obra no twitter
Given eu esteja visualizando uma â€œobraâ€ 
When  eu selecionar a opÃ§Ã£o â€œcompartilhar no twitterâ€œ
And  preencher os campos do twitter
Then eu recebo uma mensagem de confirmaÃ§Ã£o 
=======
Scenario: Receber atualizações da obra por email
  Given  eu estou visualizando a obra “Praça do arsenal”
  When eu seleciono a opção “Receber atualização por email”
  And preencho o campo de email com o email “teste@obralimpa.com”
  Then eu vejo uma mensagem de confirmação
  And passo a receber o relatório de alterações da obra no email  “teste@obralimpa.com”

Scenario Visualizar obra
  Given que o usuário está no menu de obras e quer visualizar os detalhes da obra "Praça do arsenal"
  When o usuário seleciona a obra "Praça do arsenal"
  Then o sistema exibe os detalhes da obra "Praça do arsenal"

Scenario: Nova página de obra
  Given eu estou no menu de “obras”
  And não existe uma obra com nome “Praça do Arsenal” na lista de obras
  When eu seleciono a opção “Cadastrar”
  And eu tento cadastrar a obra com o nome “Praça do Arsenal”
  And seleciono a opção “Salvar”
  Then eu recebo uma mensagem de confirmação
  And vejo o nome “Praça do arsenal”

Scenario: compartilhar obra na rede social
  Given eu estou visualizando a obra “Praça do Arsenal”
  When  eu seleciono a opção Compartilhar na Rede Social com o email "teste@teste.com" e senha "senha"
  Then eu vejo uma mensagem de confirmação
  And passo visualizar na minha rede social a postagem com o nome "Praça do Arsenal"
>>>>>>> 490963de3699a4b0dc7ea52f0ef3764b4efeb5c6
