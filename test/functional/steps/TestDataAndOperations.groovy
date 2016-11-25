package steps

import obraspublicas.*
import util.EnderecoController

class TestDataAndOperations {

        static obras = [
        [nome               : "Praca do arsenal",
        descricao          : "Praça localizada no recife antigo",
        imagem             : "http://www.turismonorecife.com.br/sites/default/files/praca_do_arsenal_0.jpg",
        precoPlanejado     : 1250000.23,
        precoFinal         : 25000000.50,
        dataPlanejada      : (new Date("12 October 2012")),
        dataTermino        : (new Date("12 October 2016")),
        latitude           : 12,
        longitude          : 45,
        empresaResponsavel : "Moura Dubeux"//,
        //politicoResponsavel: TestDataAndOperations.findPoliticoByCPF("01234567891")
        ],

        [nome               : "Ilha do Retiro",
        descricao          : "Casa do leão",
        imagem             : "youtube.com.br",
        precoPlanejado     : 1250000.23,
        precoFinal         : 100000.00,
        dataPlanejada      : (new Date("12 October 2017")),
        dataTermino        : (new Date("12 October 2010")),
        latitude           : 12,
        longitude          : 40,
        empresaResponsavel : "Edu Dubeux"//,
        //politicoResponsavel: TestDataAndOperations.findPoliticoByCPF("98765432109")
        ],


        [nome               : "Escola do Moura",
        descricao          : "Praça localizada na Varzea",
        imagem             : "http://www.turismonorecife.com.br/sites/default/files/praca_do_arsenal_0.jpg",
        precoPlanejado     : 1250465000.23,
        precoFinal         : 25000000.50,
        dataPlanejada      : (new Date("25 October 2012")),
        dataTermino        : (new Date("12 October 2016")),
        latitude           : 12,
        longitude          : 45,
        empresaResponsavel : "Moura Dubeux"//,
        //politicoResponsavel: TestDataAndOperations.findPoliticoByCPF("01234567891")
        ],

        [nome               : "Hospital Thayonara",
        descricao          : "Rua do Morro",
        imagem             : "http://www.turismonorecife.com.br/sites/default/files/praca_do_arsenal_0.jpg",
        precoPlanejado     : 1256540000.23,
        precoFinal         : 25006540000.50,
        dataPlanejada      : (new Date("12 October 2012")),
        dataTermino        : (new Date("22 October 2016")),
        latitude           : 12,
        longitude          : 45,
        empresaResponsavel : "Moura Dubeux"//,
        //politicoResponsavel: TestDataAndOperations.findPoliticoByCPF("01234567891")
        ],
    ]
    /**
     * @author = evfgs
     */
    static engenheiros = [
            [nome: "José da Silva",
             foto: "foto.jpg",
             cpf: "12345678901",
             email: "joseobra@obra.com",
             descricao: "engenheiro esforçado",
             titulacao: "civil"],

            [nome: "Emanuel Silva",
             foto: "foto.jpg",
             cpf: "05423024463",
             email: "emanuelobra@obra.com",
             descricao: "engenheiro preguiçoso",
             titulacao: "eletrico"]
    ]
    /**
     * @author = evfgs
     */
    static engenheiroObra = [
            [nomeObra: "Ilha do Retiro",
             cpfResponsavel: "12345678901"],

            [nomeObra: "Praca do arsenal",
             cpfResponsavel: "12345678901"]
    ]
    static public def findObraByNome(String obraNome) {
        return obras.find { obra ->
            obra.nome == obraNome
        }
    }
    //if ($ObrasAtrasadasEngenheiro&&ObrasEstouradasEngenheiro)
    static public void createEngenheiro(String cpf) {
        def cont = new EngenheiroController()
        cont.params << TestDataAndOperations.findEngenheiroByCPF(cpf)
        Engenheiro engenheiro = TestDataAndOperations.findEngenheiroByCPF(cpf)
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public def findEngenheiroByCPF(String engenheiroCPF){
        engenheiros.find { engenheiro ->
            engenheiro.cpf == engenheiroCPF
        }
    }
    static public int qtdObrasEngenheiro(String cpf){
        int qtdObras = 0
        for(int i = 0; i < engenheiroObra.size(); i++){
            if (engenheiroObra.get(i).cpfResponsavel == cpf){
                qtdObras++;
            }
        }
        return qtdObras
    }
    static public int qtdObrasAtrasadasEngenheiro(String cpf){
        int obrasAtrasadasEngenheiro = 0
        for(int i = 0; i < engenheiroObra.size(); i++){
            if(engenheiroObra.get(i).cpfResponsavel == cpf){
                def obra = findObraByNome(engenheiroObra.get(i).nomeObra);
                if(obra.dataTermino > obra.dataPlanejada){
                    obrasAtrasadasEngenheiro++;
                }
            }
        }
        return obrasAtrasadasEngenheiro
    }
    static public int qtdObrasEstouradasEngenheiro(String cpf){
        int obrasEstouradasEngenheiro = 0
        for(int i = 0; i < engenheiroObra.size(); i++){
            if(engenheiroObra.get(i).cpfResponsavel == cpf){
                def obra = findObraByNome(engenheiroObra.get(i).nomeObra);
                if(obra.precoFinal > obra.precoPlanejado){
                    obrasEstouradasEngenheiro++;
                }
            }
        }
        return obrasEstouradasEngenheiro;
    }
    static public float taxaObrasEstouradasEngenheiro(String cpf){
        float taxaEstouradaEngenheiro = 0
        int div = 0;
        for(int i = 0; i < engenheiroObra.size(); i++){
            if(engenheiroObra.get(i).cpfResponsavel == cpf){
                def obra = findObraByNome(engenheiroObra.get(i).nomeObra);
                div++;
                if(obra.precoFinal > obra.precoPlanejado){
                    taxaEstouradaEngenheiro++;
                }
            }
        }
        taxaEstouradaEngenheiro = (taxaEstouradaEngenheiro/div)*100
        return taxaEstouradaEngenheiro
    }
    static public float taxaObrasAtrasadasEngenheiro(String cpf){
        float taxaAtrasoEngenheiro = 0
        int div = 0;
        for(int i = 0; i < engenheiroObra.size(); i++){
            if(engenheiroObra.get(i).cpfResponsavel == cpf){
                def obra = findObraByNome(engenheiroObra.get(i).nomeObra);
                div++;
                if(obra.dataTermino > obra.dataPlanejada){
                    taxaAtrasoEngenheiro++;
                }
            }
        }
        taxaAtrasoEngenheiro = (taxaAtrasoEngenheiro/div)*100
        return taxaAtrasoEngenheiro
    }
    //end
}
