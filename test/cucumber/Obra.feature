Feature Obra:
	As a usuário do sistema 
	I want to adicionar, remover, modificar e visualizar obras no sistema
	So That eu posso gerar páginas web para exibir informações sobre a obra



#CONTROLLER
Scenario: Adicionar obra não existente
	Given que eu estou logado no sistema como "Administrador" e o sistema não tem uma 
		obra chamada “Praça do arsenal”
	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
	Then o sistema irá cadastrar a obra

Scenario: Adicionar obra existente
	Given que eu estou logado no sistema como "Administrador" e o sistema tem uma 
		obra chamada “Praça do arsenal”
	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
	Then o sistema não irá cadastrar a obra



#GUI
Scenario: Receber atualizações da obra por email
	Given  eu estou visualizando uma a obra “Praça do arsenal”
	When eu seleciono a opção “Receber atualização por email”
	And preencho os campos de email com o email “teste@obralimpa.com”
	Then eu vejo uma mensagem de confirmação
	And passo a receber o relatório de alterações da obra no email  “teste@obralimpa.com”

Scenario Visualizar obra
	Given que o visitante “Eduardo” está no menu de obras e quer visualizar os detalhes da obra “Praça do Arsenal”
	When “Guilherme” clica na opção “Visualizar obras”
	And seleciona a localização da obra “Praça do Arsenal” no mapa
	Then o sistema exibe os detalhes da obra

