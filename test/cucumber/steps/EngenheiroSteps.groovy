package steps


import static cucumber.api.groovy.EN.*
import obraspublicas.*
import pages.*
import steps.TestDataAndOperations


/**
 * Created by Emanuel on 06/11/2016.
 */
//if ($ObrasAtrasadasEngenheiro&&ObrasEstouradasEngenheiro)

//CONTROLLER Scenario
//Scenario: Devolver a taxa de atraso de obras de um determinado engenheiro
//Given que o sistema nao tem um engenheiro com o cpf "12345678901"
//When eu cadastrar um engenheiro com o cpf "12345678901"
//And o sistema tem "2" obras associada ao engenheiro com o cpf "12345678901"
//And o sistema tem "1" obra atrasada associada ao engenheiro com o cpf "12345678901"
//Then o percentual de obras atrasadas para o engenheiro com cpf "12345678901" é de "50"%

Given(~'^que o sistema nao tem um engenheiro com o cpf "([^"]*)"$'){
    String cpf ->
        Engenheiro engenheiro = Engenheiro.findByCpf(cpf)
        assert engenheiro == null
}

When(~'^eu cadastrar um engenheiro com o cpf "([^"]*)"$'){
    String cpf ->
        TestDataAndOperations.createEngenheiro(cpf)
}

And(~'^o sistema tem "([^"]*)" obras associada ao engenheiro com o cpf "([^"]*)"$'){
    int qtdObrasEngenheiro, String cpf ->
        int qtd = TestDataAndOperations.qtdObrasEngenheiro(cpf)
        assert qtd == qtdObrasEngenheiro
}

And(~'^o sistema tem "([^"]*)" obra atrasada associada ao engenheiro com o cpf "([^"]*)"$'){
    int qtdObrasAtrasadasEngenheiro, String cpf ->
        int qtd = TestDataAndOperations.qtdObrasAtrasadasEngenheiro(cpf)
        assert qtdObrasAtrasadasEngenheiro == qtd
}

Then(~'^o percentual de obras atrasadas para o engenheiro com cpf "([^"]*)" é de "([^"]*)"%$'){
    String cpf, float porcetagem ->
        float qtd = TestDataAndOperations.taxaObrasAtrasadasEngenheiro(cpf)
        assert porcetagem == qtd
}

//CONTROLLER Scenario
//Scenario: Devolver a taxa de obras com orçamentos estourados de um determinado engenheiro
//Given que o sistema nao tem um engenheiro com o cpf "12345678901"
//When eu cadastrar um engenheiro com o cpf "12345678901"
//And o sistema tem "2" obras associada ao engenheiro com o cpf "12345678901"
//And o sistema tem "1" obra com orçamento estourado associada ao engenheiro com o cpf "12345678901"
//Then o percentual de obras com orcamento estourado para o engenheiro com cpf "12345678901" é de "50"%


And(~'^o sistema tem "([^"]*)" obra com orçamento estourado associada ao engenheiro com o cpf "([^"]*)"$') {
    int qtdObrasEstouradasEngenheiro, String cpf ->
        int qtd = TestDataAndOperations.qtdObrasEstouradasEngenheiro(cpf)
        assert qtdObrasEstouradasEngenheiro == qtd
}

Then(~'^o percentual de obras com orcamento estourado para o engenheiro com cpf "([^"]*)" é de "([^"]*)"%$'){
    String cpf, float porcetagem ->
        float qtd = TestDataAndOperations.taxaObrasEstouradasEngenheiro(cpf)
        assert porcetagem == qtd
}
//GUI Scenario
//Scenario: Visualizar detalhes de um determinado engenheiro
//Given que o usuario esta no menu de engenheiro e quer visualizar os detalhes do engenheiro com o cpf "12345678901"
//When o usuario seleciona o engenheiro com o cpf "12345678901"
//Then o sistema exibe os detalhes do engenheiro com o cpf "12345678901"

Given(~'^que o usuario esta no menu de engenheiro e quer visualizar os detalhes do engenheiro com o cpf "([^"]*)"$') {
    String cpf ->
        TestDataAndOperations.createEngenheiro(cpf)
        to EngenheiroListPage
        at EngenheiroListPage
}

When(~'^o usuario seleciona o engenheiro com o cpf "([^"]*)"$') {
    String cpf ->
        at EngenheiroListPage
        assert page.checkEngenheiroAtList(cpf) == true
        page.selectEngenheiroAtList(cpf)
}

Then(~'^o sistema exibe os detalhes do engenheiro com o cpf "([^"]*)"$'){
    String cpf ->
        at EngenheiroShowPage
        assert page.verifyCpfEngenheiro(cpf) == true
}
//end