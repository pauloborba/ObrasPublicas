

//Scenario: Atualizar político
//Given que exista um politico com nome “Eduardo” e CPF "01234567890”
//When eu tentar atualizar os dados do político  com nome “Eduardo” e CPF "01234567890”
//Then o sistema irá atualizar o político








Given(~'^que existe um politico no sistema chamado"([^"]*)" e CPF "([^"]*)"$'){
	String politicoName, cpf -> 
	Politico politico = Politico.findByCpfAndName(cpf, politicoName)
	assert politico != null
}

When (~'^eu tento atualizar os dados do polico com o nome"([^"]*)" e CPF "([^"]*)"$') {
	String politicoName, cpf ->                        //tem que verificar
	 TestDataAndOperations.atualizarPolitico(politicoName,cpf)//tem que verificar
}

Then(~'^o sistema irá atualizar o politico de nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName, cpf ->
        Politico politico = Politico.findByName(politicoName)
        assert TestDataAndOperations.compatibleTo(politico, politicoName,cpf)
}


//Scenario: Remover político existente 
//Given o sistema tem um político com nome “Eduardo” e CPF "01234567890”
//When eu tentar remover o político com o nome “Eduardo” e CPF “01234567890”
//Then o sistema ira mostrar a mensagem politico "Eduardo" de CPF “01234567890” removido com sucesso

Given(~'^o sistema tem um político chamado "([^"]*)" e CPF "([^"]*)"$'){
	String politicoName, cpf -> 
	Politico politico = Politico.findByCpfAndName(cpf, politicoName)
	assert politico != null
}

When (~'^eu tento remover o polico com o nome"([^"]*)" e CPF "([^"]*)"$') {
	String politicoName, cpf ->                        //tem que verificar
	 TestDataAndOperations.deletarPolitico(politicoName,cpf)//tem que verificar
}

Then(~'^o sistema irá remover o politico de nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName, cpf ->
        Politico politico = Politico.findByName(politicoName)
        assert TestDataAndOperations.compatibleTo(politico, politicoName,cpf)
}


