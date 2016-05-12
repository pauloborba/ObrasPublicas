package util

import obraspublicas.Pessoa

class Telefone {
    int ddd
    int telefone

    static hasOne = [pessoa : Pessoa]

    static constraints = {
    }
}
