import obraspublicas.*
import pages.ObraListPage
import pages.TaxaAtrasoPoliticoPage
import steps.TestDataAndOperations
import static cucumber.api.groovy.EN.*
import pages.PoliticoListPage
import pages.PoliticoShowPage


//#CONTROLLER
//Scenario: Adicionar politico nao existente
//Given que o sistema nao tem um politico com CPF "01234567891"
//When eu tentar cadastrar um politico com CPF "01234567891"
//Then o sistema ira cadastrar o politico de CPF "01234567891"

Given(~'^que o sistema nao tem um politico com CPF "([^"]*)"$'){
    String cpf ->
        Politico politico = Politico.findByCpf(cpf)
        assert politico == null
}

When(~'^eu tentar cadastrar um politico com CPF "([^"]*)"$'){
    String cpf ->
        TestDataAndOperations.createPolitico(cpf)
}

Then(~'^o sistema ira cadastrar o politico de CPF "([^"]*)"$'){
    String cpf ->
        Politico politico = Politico.findByCpf(cpf)
        assert TestDataAndOperations.politicoCompatibleTo(politico, cpf)
}

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

Then(~'^o sistema irá atualizar o politico de nome "([^"]*)" e CPF "([^"]*)"$') {
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
        assert TestDataAndOperations.politicoCompatibleTo(politico, cpf)
}

//Scenario: Adicionar político existente
//Given o sistema tem um político com nome “Eduardo” e CPF "01234567890”
//When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
//Then o sistema não irá cadastrar o político

Given(~'^que o sistema tem um politico de CPF "([^"]*)"$'){
    String cpf ->
        TestDataAndOperations.createPolitico(cpf)
        Politico politico = Politico.findByCpf(cpf)
        assert politico != null
}

Then(~'^o sistema nao ira cadastrar o politico de CPF "([^"]*)"$'){
    String cpf ->
        politicos = Politico.findAllByCpf(cpf)
        assert politicos.size() == 1
}
/************
 tpa
 ******/

//Scenario: Visualizar político
//Given que o usuario esta no menu de político e quer visualizar os detalhes do político com o cpf "98765432109"
//When o usuario seleciona o político com o cpf "98765432109"
//Then o sistema exibe os detalhes do político com o cpf "98765432109"


Given(~'^que o usuario esta no menu de político e quer visualizar os detalhes do político com o cpf "([^"]*)"$') {
    String cpf ->
        TestDataAndOperations.createPolitico(cpf)
        to PoliticoListPage
        at PoliticoListPage
}

When(~'^o usuario seleciona o político com o cpf "([^"]*)"$') {
    String cpf ->
        at PoliticoListPage
        assert page.checkPoliticoAtList(cpf) == true
        page.selectPoliticoAtList(cpf)
}

Then(~'^o sistema exibe os detalhes do político com o cpf "([^"]*)"$'){
    String cpf ->
        at PoliticoShowPage
        assert page.verifyCpfPolitico(cpf) == true
}
//Scenario: Visualizar taxa de atraso de obras de um político
//Given que o usuario esta no menu de político e tem um político com o cpf "98765432109"
//And existe "2" obra associada ao político com o cpf "98765432109"
//And existe "1" obra atrasada associada ao político com cpf "98765432109"
//When o usuário seleciona a opçao de taxa de atraso
//Then ele visualizará "100" % como sendo a taxa de atraso
Given(~'^que o usuario esta no menu de político e tem um político com o cpf "([^"]*)"$') {
    String cpf ->
    TestDataAndOperations.createPolitico(cpf)
        to PoliticoListPage
        at PoliticoListPage
}
And(~'^existe "([^"]*)" obra associada ao político com o cpf "([^"]*)"$') {
    int nObra, String cpf ->
        dep obras = TestDataAndOperations.findPoliticoObraByCPF(cpf)
        at ObraListPage
        boolean check = true
        int cont = 0
        obras.each {obra -> TestDataAndOperations.createObra(obra.get(0).nomeObra); check = check &&page.checkObraAtList(obra.get(0).nomeObra);cont= cont+1 }
        assert  check == true
        assert cont ==nObra
}

And(~'^existe "([^"]*)" obra atrasada associada ao político com o cpf "([^"]*)"$') {
    int nObra, String cpf ->
        dep obras = TestDataAndOperations.findPoliticoObraByCPF(cpf)
        at ObraListPage
        boolean check = true
        int cont = 0
        obras.each {obra -> TestDataAndOperations.createObra(obra.get(0).nomeObra); check = check &&page.checkObraAtList(obra.get(0).nomeObra);
            if(TestDataAndOperations.checkObraAtrasada(obra.get(0).nomeObra)) {cont =cont+1}}
        assert cont ==nObra
}
When(~'^o usuário seleciona a opçao de taxa de atraso$') {
        at PoliticoListPage
        page.selectTaxaAtrasada()
}
Then(~'^ele visualizará "([^"]*)" % como sendo a taxa de atraso$'){
    String taxa ->
        at TaxaAtrasoPoliticoPage
        assert page.verifyTaxa(taxa) == true
}