import cucumber.api.PendingException
import pages.ObraListPage
import pages.ObraShowPage

import static cucumber.api.groovy.EN.*
import obraspublicas.*
import steps.TestDataAndOperations

//CONTROLLER
//Scenario: Adicionar obra não existente
//	Given que o sistema não tem uma obra chamada “Praça do arsenal”
//	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
//	Then o sistema irá cadastrar a obra de nome "Praça do arsenal"
/**
* @author = ehmr
*/
Given(~'^que o sistema nao tem uma obra chamada "([^"]*)"$'){
	String nomeObra -> 
		Obra obra = Obra.findByNome(nomeObra)
		assert obra == null
		//assert true
}

When(~'^eu tentar cadastrar uma obra com o nome "([^"]*)"$'){
	String nomeObra ->
    	TestDataAndOperations.createObra(nomeObra)
}

Then(~'^o sistema ira cadastrar a obra de nome "([^"]*)"$'){
	String nomeObra ->
		Obra obra = Obra.findByNome(nomeObra)
		assert TestDataAndOperations.obraCompatibleTo(obra, nomeObra)
}


//Scenario: Adicionar obra existente
//	Given que o sistema tem uma obra chamada “Praça do arsenal”
//	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
//	Then o sistema não irá cadastrar a obra de nome "Praça do arsenal"
/**
* @author = ehmr
*/
Given(~'^que o sistema tem uma obra chamada "([^"]*)"$'){
	String nomeObra ->
		TestDataAndOperations.createObra(nomeObra)
		Obra obra = Obra.findByNome(nomeObra)
		assert obra != null
}

Then(~'^o sistema nao ira cadastrar a obra de nome "([^"]*)"$'){
	String nomeObra ->
		obras = Obra.findAllByNome(nomeObra)
    	assert obras.size() == 1
}

//Scenario Visualizar obra GUI
//	Given que o usuário está no menu de obras e quer visualizar os detalhes da obra "Praça do arsenal"
//	When o usuário seleciona a obra "Praça do arsenal"
//	Then o sistema exibe os detalhes da obra "Praça do arsenal"
/**
 * @author = ehmr
 */
Given(~'^que o usuario esta no menu de obras e quer visualizar os detalhes da obra "([^"]*)"$') {
	String nomeObra ->
		TestDataAndOperations.createObra(nomeObra)
		to ObraListPage
		at ObraListPage
}

When(~'^o usuario seleciona a obra "([^"]*)"$') {
	String nomeObra ->
		at ObraListPage
		page.checkObraAtList(nomeObra)
		page.selectObraAtList(nomeObra)
}

Then(~'^o sistema exibe os detalhes da obra "([^"]*)"$'){
	String nomeObra ->
		at ObraShowPage
		assert page.verifyName(nomeObra) == true
}

//GUI
//Scenario: Receber atualizações da obra por email
//	Given  eu estou visualizando a obra “Praça do arsenal”
//	When eu seleciono a opção “Receber atualização por email”
//	And preencho o campo de email com o email “teste@obralimpa.com”
//	Then eu vejo uma mensagem de confirmação
//	And passo a receber o relatório de alterações da obra no email  “teste@obralimpa.com”
/**
* @author = ehmr
*/
Given(~'^eu estou visualizando a obra "([^"]*)"$') {
	String nomeObra ->
//		to ObraPage
//		at ObraPage
//  	page.checkObraAtList(nomeObra)
//  	page.selectObra(nomeObra)
//    	at ObraShowPage
}

When(~'^eu seleciono a opcao "([^"]*)"$') {
	String option ->
//    at ObraShowPage
//    page.select(option)
//    page.fillEmailData(email)
//    page.select("Cadastrar")
}

And(~'^preencho o campo de email com o email "([^"]*)"$'){
	String email ->
}

Then(~'^eu vejo uma mensagem de confirmacao com o nome "([^"]*)" e email "([^"]*)"$'){
	String nomeObra, email ->
	    //throw new PendingException()
		//assert page.verifyPageContainsText(email) == true
		assert false
}

//============other
/**
 * @author = ehmr
 */
//Scenario: Visualizar obra
//	Given que o sistema tem uma obra cadastrada com o nome "Praca do arsenal"
//	When eu tentar visualizar a obra com o nome "Praca do arsenal"
//	Then o sistema mostrara as informacoes relacionadas a obra com o nome "Praca do arsenal"
When (~'^eu tentar visualizar a obra com o nome "([^"]*)"$'){
	String nomeObra ->
}
Then (~'^o sistema mostrara as informacoes relacionadas a obra com o nome "([^"]*)"$'){
	String nomeObra ->
		assert false
}

/**
 * @author = tpa
 */
//Scenario: Atualizar obra
//	Given que existe uma obra no sistema chamada "Praca do arsenal"
//	When eu tentar atualizar os dados da obra com o nome "Praca do arsenal"
//	Then o sistema atualiza a obra com o nome "Praca do arsenal"
When (~'^eu tentar atualizar os dados da obra com o nome "([^"]*)"$'){
	String nomeObra ->                        //tem que verificar
		TestDataAndOperations.atualizaObra(nomeObra)//tem que verificar
}
Then (~'^o sistema atualiza a obra com o nome "([^"]*)"$'){
	String nomeObra ->
		Obra obra = Obra.findByNome(nomeObra)
		assert TestDataAndOperations.obraCompatibleTo(obra, nomeObra)
}

/**
 * @author = ehmr
 **/
//Scenario: Remover obra nao existente
//	Given que o sistema nao tem uma obra chamada "Praca do arsenal"
//	When eu tentar remover a obra com o nome "Praca do arsenal"
//	Then o sistema nao ira remover a obra com o nome "Praca do arsenal"
When (~'^eu tentar remover a obra com o nome "([^"]*)"$'){
	String nomeObra ->
}
Then (~'^o sistema nao ira remover a obra com o nome "([^"]*)"$'){
	String nomeObra ->
		assert false
}

/**
 * @author = ehmr
 **/
//Scenario: Remover obra existente
//	Given que o sistema tem uma obra chamada "Praca do arsenal"
//	When eu tentar remover a obra com o nome "Praca do arsenal"
//	Then o sistema ira remover a obra com nome "Praca do arsenal"
Then (~'^o sistema ira remover a obra com nome "([^"]*)"$'){
	String nomeObra ->
		assert false
}

//other gui

/**
 * @author = ehmr
 **/
//Scenario: Nova pagina de obra
//	Given eu estou no menu de "obras"
//	And nao existe uma obra com nome "Praca do Arsenal" na lista de obras
//	When eu seleciono a opcao "Cadastrar"
//	And eu tento cadastrar a obra com o nome "Praca do Arsenal"
//	And seleciono a opcao "Salvar"
//	Then eu recebo uma mensagem de confirmacao
//	And vejo o nome "Praca do arsenal"
Given (~'^eu estou no menu de obras e nao existe uma obra com nome "([^"]*)" na lista de obras$'){
	String nomeObra ->
}
And (~'^eu tento cadastrar a obra com o nome "([^"]*)"$'){
	String nomeObra ->
}
And (~'^seleciono a opcao "([^"]*)"$'){
	String option ->
}
Then (~'^eu vejo uma mensagem de confirmacao com o nome "([^"]*)"$'){
	String nomeObra ->
		assert false
}

/**
 * @author = tpa
 **/
//Scenario: compartilhar obra na rede social
//	Given eu estou visualizando a obra "Praca do Arsenal"
//	When  eu seleciono a opcao "Compartilhar na Rede Social"
//  And preencho os campos com o email "teste@teste.com" e senha "senha"
//	Then eu vejo uma mensagem de confirmacao com o nome "Praca do arsenal"
//	And passo visualizar na minha rede social a postagem com o nome "Praca do Arsenal"
And (~'^preencho os campos com o email "([^"]*)" e senha "([^"]*)"$'){
	String email, senha ->
}
And (~'^passo visualizar na minha rede social a postagem com o nome "([^"]*)"$'){
	String nomeObra ->
		assert false
}
