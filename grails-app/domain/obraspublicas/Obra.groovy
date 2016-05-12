package obraspublicas

import util.Endereco

class Obra {
    String nome
    String descricao
    Endereco endereco
    List<URI> imagens
    double precoPlanejado
    double precoFinal
    Date dataInicio
    Date dataTermino
    double latitude
    double longitude
    Politico politicoResponsavel
    String empresaResponsavel

    static hasOne = [politico : Politico]

    static constraints = {
        precoPlanejado blank: false
        dataInicio blank: false
    }
}
