import steps.TestDataAndOperations

import static cucumber.api.groovy.EN.*


//CONTROLLER
//Scenario: Adicionar obra não existente
//	Given que eu estou logado no sistema como "Administrador" e o sistema não tem uma 
//		obra chamada “Praça do arsenal”
//	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
//	Then o sistema irá cadastrar a obra de nome "Praça do arsenal"


/**
* @author = ehmr
*/
Given(~'^que eu estou logado no sistema como "([^"]*)" e o sistema não tem uma obra chamada "([^"]*)"$'){
	String login, filename -> 
	Obra obra = Obra.findByName(filename)
	assert obra == null
}

When (~'^eu tentar cadastrar uma obra com o nome "([^"]*)"$'){
	String filename ->                        //tem que verificar
	TestDataAndOperations.createObra(filename)//tem que verificar
}

Then(~'^o sistema irá cadastrar a obra de nome "([^"]*)"$'){
	String filename ->
	Obra obra = Obra.findByName(filename)
	assert TestDataAndOperations.compatibleTo(obra, filename)
}


//Scenario: Adicionar obra existente
//	Given que eu estou logado no sistema como "Administrador" e o 
//		sistema tem uma obra chamada “Praça do arsenal”
//	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
//	Then o sistema não irá cadastrar a obra de nome "Praça do arsenal"

/**
* @author = ehmr
*/
Given(~'^que eu estou logado no sistema como "([^"]*)" e o sistema tem uma obra chamada "([^"]*)"$'){
	String login, filename -> 
	Obra obra = Obra.findByName(filename)
	assert obra != null
}

When (~'^eu tentar cadastrar uma obra com o nome "([^"]*)"$'){
	String filename ->                        //tem que verificar
	TestDataAndOperations.createObra(filename)//tem que verificar
}

Then(~'^o sistema não irá cadastrar a obra de nome "([^"]*)"$'){
	String filename ->
	obras = Obra.findAllByName(filename)
    assert obras.size() == 1
}


//GUI
//Scenario: Receber atualizações da obra por email
//	Given  eu estou visualizando uma a obra “Praça do arsenal”
//	When eu seleciono a opção “Receber atualização por email”
//	And preencho os campos de email com o email “teste@obralimpa.com”
//	Then eu vejo uma mensagem de confirmação
//	And passo a receber o relatório de alterações da obra no email  “teste@obralimpa.com”

/**
* @author = ehmr
*/
Given(~'^eu estou visualizando uma a obra "([^"]*)"$') { 
	String filename ->
    to ObraShowPage
    at ObraShowPage
}

When(~'^eu seleciono a opção "([^"]*)" And preencho os campos de email com o email "([^"]*)"$') { 
	String option, email ->
    at ObraShowPage
    page.select(option)
    page.fillEmailData(email)
    page.select("Cadastrar")
}

Then(~'^eu vejo uma mensagem de confirmação And passo a receber o relatório de alterações da obra no email "([^"]*)"$'){
	String email ->
	assert page.verifyPageContainsText(email) == true
}

//Scenario Visualizar obra
//	Given que o visitante “Eduardo” está na lista de obras e quer visualizar os detalhes da obra "Praça do arsenal"
//	When “Eduardo” clica na obra "Praça do arsenal"
//	Then o sistema exibe os detalhes da obra "Praça do arsenal"


/**
* @author = ehmr
*/
Given(~'^Given que o visitante "([^"]*)" está no menu de obras e quer visualizar os detalhes da obra "([^"]*)"$') { 
	String name, filename ->
    to ObraPage
    at ObraPage
}

When(~'^"([^"]*)" clica na obra "([^"]*)"$') { 
	String nome, filename ->
    at ObraPage
    page.checkObraAtList(filename)
    page.selectObra(filename)
}

Then(~'^o sistema exibe os detalhes da obra "([^"]*)"$'){
	String filename ->
	at ObraShowPage
	assert page.verifyName(filename) == true
}