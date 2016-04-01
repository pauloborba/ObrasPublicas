#CONTROLLER

Scenario: Suspender um contrato
  Given que existe um contrato no systema da ordem X
  And  os stakeholders decidiram suspender o contrato para um determinado motivo
  When a decisão é tomada
  Then o contrato encontra-se suspenso

Scenario: Prosseguir um contrato
  Given que existe um contrato no systema suspenso com número da ordem X
  When  os stakeholders decidiram prosseguir o contrato depois de resolver algum problema
  Then o contrato é reativado

#GUI

Scenario: Listar contratos por odrem da data do ínicio
 Given que estou na página de contratos
 When eu seleciono a opção listar contratos pela ordem da data de início
 Then os contratos são listados em ordem que foram iniciado

Scenario: Listar contratos vencidos
 Given que estou na página de contratos
 When eu seleciono a opção listar contratos os contratos vencidos
 Then todos os contraros que já venceram são listados

