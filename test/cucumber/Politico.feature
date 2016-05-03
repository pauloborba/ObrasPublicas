Feature Políticos:
  As a usuário do sistema
  I want to adicionar, remover, modificar e visualizar políticos no sistema
  So That eu posso gerar páginas web para exibir informações sobre o político

#CONTROLLER
Scenario: Adicionar político não existente
Given que eu estou logado no sistema como "Administrador"
  And o sistema não tem um político com nome “Eduardo” e CPF "01234567890”
When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
Then o sistema irá cadastrar o político com o nome “Eduardo” e CPF “01234567890”

Scenario: Adicionar político existente
Given que eu estou logado no sistema como "Administrador"
  And o sistema tem um político com nome “Eduardo” e CPF "01234567890”
When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
Then o sistema não irá cadastrar o político

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