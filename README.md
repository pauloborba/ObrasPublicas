# ObrasPublicas
Sistema de monitoramento de obras públicas de ESS

grails version: 2.4.3

JDK 1.7.0_65 SDK 7 (1.8 Não funciona)

Faça o download do chromedriver compatível com sua máquina e coloque ele na pasta chromedrivers.

Em GebConfig.groovy setar caminho do chromeDriver no File

Mark as Test Source todas as subpastas imediatas de test (não as subpastas das subpastas) 

Run configurations:

Grails:ObrasPublicas

-noreloading run-app

Cucumber:ObrasPublicas

(IntelliJ) Para rodar os testes, crie uma configuração do grails com a seguinte linha de comando: 

-noreloading test-app -Dgeb.env=chrome functional:cucumber

Emanuel Victor - feature - Mostrar quando um engenheiro possui uma ou mais obras atrasadas e/ou com orçamento estourado
Ao inicializar o ObrasPublicas, Primeiro é necessário Criar um Politico e um Engenheiro, para associalos quando for criar
uma Obra. Após criar a Obra e inserir suas datas planejadas e de termino, e seu preço estimado e preço final. Quando acessar
a Lista de Engenheiros, é possivel acessar as taxas de atraso e de estouro de cada engenheiro.

-------------------------------------------------------------------------------------------------------------------

Integração com o Travis-ci <br />
Entre em [Travis-CI](https://travis-ci.org/) <br />
Selecione o botão no canto superior direito "Sign in with github" <br />
Clique em seu nome no canto superior direito <br />
Pressione o botão cinza "Sync" caso seus repositórios não estejam aparecendo <br />
Caso os repositórios não aparecam, dê log out e entre novamente <br />
Escolha o repositório que deseja testar, no caso o TA, e clique no botão cinza para que ele se torne verde <br />
Faça um commit qualquer para ativar a build do travis <br />
Caso você queira ver mais do stacktrace utilize "--verbose" logo após o comando "--stacktrace" no arquivo .travis.yml do seu repositório <br />
Para receber emails sobre se a build passou ou não, ative seu email no perfil do github <br />

-------------------------------------------------------------------------------------------------------------------
