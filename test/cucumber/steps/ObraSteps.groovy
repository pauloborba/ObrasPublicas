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
		assert obras.size() <= 1
}
//Scenario Visualizar obra
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
		assert page.checkObraAtList(nomeObra) == true
		page.selectObraAtList(nomeObra)
}

Then(~'^o sistema exibe os detalhes da obra "([^"]*)"$'){
	String nomeObra ->
		at ObraShowPage
		assert page.verifyNomeObra(nomeObra) == true
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
		TestDataAndOperations.createObra(nomeObra)
		to ObraListPage
		at ObraListPage
	  	assert page.checkObraAtList(nomeObra) == true
	  	page.selectObraAtList(nomeObra)
    	at ObraShowPage
}

When(~'^eu seleciono a opcao "([^"]*)"$') {
	String option ->
//    	at ObraShowPage
//    	page.select(option)
//    	page.fillEmailData(email)
//    	page.select("Cadastrar")
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
//Scenario: Adicionar obra com data de termino anterior a data de início
//Given que o sistema nao tem uma obra chamada "Praca do arsenal"
//When eu tento cadastrar uma obra com o nome "Praca do arsenal"
//And insiro a data inicial "12 October 2017" e a data final "12 October 2013"
//Then o sistema nao ira cadastrar a obra de nome "Praca do arsenal"

And (~'^insiro a data inicial "([^"]*)" e a data final "([^"]*)"$'){
	String ini, fin ->
		assert TestDataAndOperations.checkDataFI(ini,fin) == true
}

//Scenario:  Adicionar obra com data de termino anterior a data corrente
//Given que o sistema nao tem uma obra chamada "Praca do arsenal"
//When eu tentar cadastrar uma obra com o nome "Praca do arsenal"
//And insiro a data final "12 October 2013"
//Then o sistema nao ira cadastrar a obra de nome "Praca do arsenal"
And (~'^insiro a data final "([^"]*)"$'){
	String fin ->
		assert TestDataAndOperations.checkDataFC(fin) == true
}
//Scenario: Atualizar nome de obra com nome já existente
//Given que o sistema tem uma obra chamada "Praca do arsenal"
//And tem uma obra com o nome "Ilha do retiro"
//When eu tentar atualizar o nome da obra "Praca do arsenal" com o nome "Ilha do retiro"
//Then o sistema não atualiza a obra com o novo nome "Ilha do retiro"

And(~'^tem uma obra com o nome "([^"]*)"$'){
	String nomeObra ->
		Obra obra = TestDataAndOperations.findObraByNome(nomeObra)
		assert obra != null
}
When(~'^eu tentar atualizar o nome da obra "([^"]*)" com o nome "([^"]*)"$'){
	String nome1, nome2 ->
		assert TestDataAndOperations.checkAtualizaNome(nome1, nome2) == false
}

Then(~'^o sistema não atualiza a obra com o novo nome "([^"]*)"$'){
	String nomeObra ->
		obras = Obra.findAllByNome(nomeObra)
		assert obras.size() <= 1
}

//Scenario: Adicionar obra de um politico inexistente
//Given que o sistema nao tem uma obra chamada "Praca do arsenal"
//And não existe um politico com o cpf "11122233344"
//When eu tentar cadastrar uma obra com o nome "Praca do arsenal"
//Then o sistema nao ira cadastrar a obra de nome "Praca do arsenal"
And(~'^não existe um politico com o cpf "([^"]*)"$'){
	String cpf ->
		Obra obra = TestDataAndOperations.findPoliticoByCPF(cpf)
		assert obra == null
}

/**
 * @author = ehmr
 **/
//Scenario: Remover obra existente
//	Given que o sistema tem uma obra chamada "Praca do arsenal"
//	When eu tentar remover a obra com o nome "Praca do arsenal"
//	Then o sistema ira remover a obra com nome "Praca do arsenal"
int sizeObrasBefore;
When (~'^eu tentar remover a obra com o nome "([^"]*)"$'){
	String nomeObra ->
		sizeObrasBefore = Obra.count()
		TestDataAndOperations.removeObra(nomeObra)
}
Then (~'^o sistema ira remover a obra com nome "([^"]*)"$'){
	String nomeObra ->
		assert Obra.count() == (sizeObrasBefore-1)
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
		to ObraListPage
		at ObraListPage
		assert page.checkObraAtList(nomeObra) == false
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
