package obraspublicas

import util.Telefone

class Pessoa {
    String nome
    String cpf
    String email

    static hasMany = [telefones : Telefone]

    static constraints = {
        cpf blank: false
        nome blank: false
    }
}
