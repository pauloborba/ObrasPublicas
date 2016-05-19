package obraspublicas

import util.Partido

class Politico extends Pessoa {
    Partido partido
    String foto
    String descricao
    double qualidade

    static hasMany = [obras : Obra]

    static constraints = {
        obras blank: true
        foto blank: true
        obras null: true
    }
}
