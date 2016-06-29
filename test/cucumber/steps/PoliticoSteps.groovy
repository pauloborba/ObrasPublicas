import obraspublicas.*
import steps.TestDataAndOperations
import static cucumber.api.groovy.EN.*


//#CONTROLLER
//Scenario: Adicionar político não existente
//Given o sistema não tem um político com nome “Eduardo” e CPF "01234567890”
//When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
//Then o sistema irá cadastrar o político com o nome “Eduardo” e CPF “01234567890”

Given(~'^o sistema não tem um político com o nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName, cpf ->
    Politico politico = Politico.findByCpfAndName(cpf,politicoName)
    assert politico==null
}

When (~'^eu tentar cadastrar um politico com o nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName,cpf ->
    TestDataAndOperations.createPolitico(politicoName,cpf)
}

Then(~'^o sistema irá cadastrar o politico de nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName, cpf ->
        Politico politico = Politico.findByName(politicoName)
        assert TestDataAndOperations.politicoCompatibleTo(politico, cpf)
}

//Scenario: Atualizar id de um politico
//Given que exista um politico com  CPF "01234567890”
//When eu tentar atualizar o id do político  com CPF "01234567890”
//Then o olitico de CPF "01234567890" tera seu id atualizado
Given(~'^o politico com CPF "([^"]*)” esta armazenado no sistema$'){
    String  cpf ->
    TestDataAndOperations.createPolitico(cpf)
    Politico politico = Politico.findByCpf(cpf)
    assert politico != null
}

When (~'^eu tentar atualizar o id do politico de CPF "([^"]*)”$') {
    String cpf ->
    Long newId
        TestDataAndOperations.updateIdPolitico(cpf, newId)
}

Then(~'^o politico de CPF "([^"]*)" tera seu id atualizado$') {
    String cpf->
        Politico politico= Politico.findByCpf(cpf)
        assert TestDataAndOperations.politicoCompatibleTo(politico, cpf)
}

//Scenario: Remover político existente
//Given o politico com CPF "01234567890” esta armazenado no sistema
//When eu tentar remover o político com CPF “01234567890”
//Then o politico de CPF “01234567890” sera removido


When(~'^eu tentar remover o politico de CPF “([^"]*)”$') {
    String cpf ->
        TestDataAndOperations.deletePolitico(Cpf)
}

Then(~'^o politico de CPF “([^"]*)” sera removido$'){
    String cpf ->
        testpolitico = Politico.findAllByCpf(cpf)
        assert testpolitico == null
}

//Scenario: Adicionar político existente
//Given o sistema tem um político com nome “Eduardo” e CPF "01234567890”
//When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
//Then o sistema não irá cadastrar o político

Given(~'^o sistema tem um político de nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName, cpf ->
    Politico politico = Politico.findByCpfAndName(cpf,politicoName)
    assert politico != null
}

When (~'^ao tentar cadastrar um político com o nome "([^"]*)" e CPF "([^"]*)"$'){
    String politicoName, cpf ->                        //tem que verificar
    TestDataAndOperations.createPolitico(politicoName,cpf)//tem que verificar
}

Then(~'^o sistema não irá cadastrar o político de nome "([^"]*)" e CPF "([^"]*)"$') {
    String politicoName,cpf ->
    politicos = Politico.findAllByCpfAndName(cpf,politicoName)
    assert politicos.size() == 1
}
