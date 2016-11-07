#
# Created by Emanuel on 06/11/16.

#if ($ObrasAtrasadasEngenheiro&&ObrasEstouradasEngenheiro)
Feature: Engenheiro
  As a usuário do sistema
  I want to adicionar, remover, modificar, visualizar engenheiros no sistema e ver o relatorio das obras do engenheiro
  So That eu posso gerar páginas web para exibir informações sobre o engenheiro

###GUI
#  Scenario: Visualizar taxa de atraso de obras de um engenheiro
#    Given que o usuario esta no menu de engenheiro e tem um engenheiro com o cpf "12345678901"
#    And existe "2" obra associada ao engenheiro com o cpf "12345678901"
#    And existe "1" obra atrasada associada ao engenheiro com cpf "12345678901"
#    When o usuário seleciona a opçao de taxa de atraso
#    Then ele visualizará "50"% como sendo a taxa de atraso
#
#  Scenario: Visualizar taxa de obras com orçamentos estourados de um engenheiro
#    Given que o usuario esta no menu de engenheiro e tem um engenheiro com o cpf "12345678901"
#    And existe "2" obra associada ao engenheiro com o cpf "12345678901"
#    And existe "1" obra com orçamento estourado associada ao engenheiro com cpf "12345678901"
#    When o usuário seleciona a opçao de taxa de orçamentos estourados
#    Then ele visualizará "50"% como sendo a taxa de atraso


##CONTROLLER Scenario
  Scenario: Devolver a taxa de atraso de obras de um determinado engenheiro
    Given que o sistema tem um engenheiro com o cpf "12345678901"
    And o sistema tem "2" obras associada ao engenheiro com o cpf "12345678901"
    And o sistema tem "1" obra atrasada associada ao engenheiro com o cpf "12345678901"
    Then o percentual de obras atrasadas para o engenheiro com cpf "12345678901" é de "50"%


  Scenario: Devolver a taxa de obras com orçamentos estourados de um determinado engenheiro
    Given que o sistema tem um engenheiro com o cpf "12345678901"
    And o sistema tem "2" obras associada ao engenheiro com o cpf "12345678901"
    And o sistema tem "1" obra com orçamento estourado associada ao engenheiro com o cpf "12345678901"
    Then o percentual de obras com orcamento estourado para o engenheiro com cpf "12345678901" é de "50"%

#end