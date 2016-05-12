package obraspublicas

import util.Partido

class Politico extends Pessoa {
    Partido partido
    URI foto
    String descricao
    double qualidade

    static hasMany = [obras : Obra]

    static constraints = {
        obras blank: true
    }
}
