import rgms.tool.SNSTool


Given(~'^que existe uma obra no sistema chamada"([^"]*)"$'){
	String nomeObra -> 
	Obra obra = Obra.findByName(nomeObra)
	assert obra == null
}

When (~'^eu tento atualizar os dados da obra com o nome"([^"]*)"$'){
	String nomeObra ->                        //tem que verificar
	TestDataAndOperations.atualizaObra(nomeObra)//tem que verificar
}

Then(~'^o sistema atualiza a obra"([^"]*)"$'){
	String nomeObra ->
	Obra obra = Obra.findByName(nomeObra)
	assert TestDataAndOperations.compatibleTo(obra, nomeObra)
}



Given(~'^eu estou visualizando a obra "([^"]*)"$') { 
	String nomeObra ->
	to ObraPage
	at ObraPage
    page.checkObraAtList(nomeObra)
    page.selectObra(nomeObra)
    at ObraShowPage
}

When(~'^eu seleciono a opção Compartilhar na Rede Social com o email "([^"]*)" e senha "([^"]*)"$') { 
	String email, senha ->
    at ObraShowPage
    page.selectShareSNS(email, senha)
    at ObraShowPage
}

Then(~'^eu vejo uma mensagem de confirmação And passo visualizar na minha rede social a postagem com o nome"([^"]*)"$'){
	String nomeObra ->
	assert SNSToll.consult(nomeObra)
}