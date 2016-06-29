package obraspublicas

class Obra {
    String nome
    String descricao
    String imagem
    double precoPlanejado
    double precoFinal
    Date dataPlanejada
    Date dataTermino
    double latitude
    double longitude
    String empresaResponsavel

    static hasOne = [politicoResponsavel : Politico]

    static constraints = {
        precoPlanejado blank: false
        dataPlanejada blank: false
        dataTermino null: true
    }

    public String toString(){
        String desc = ""
        desc += this.nome + ". "
        desc += this.descricao

        return desc
    }

    public String getDataPlanejadaFormatada(){
        return this.dataPlanejada.getDay() + "/" + this.dataPlanejada.getMonth() + "/" + this.dataPlanejada.getYear()
    }

    public String getDataTerminoFormatada(){
        return this.dataTermino.getDay() + "/" + this.dataTermino.getMonth() + "/" + this.dataTermino.getYear()
    }

    public String getStatusAndamentObra(){
        if(dataTermino == null){
            if(System.currentTimeMillis() > this.dataPlanejada.getTime())
                return "A obra está atrasada!"
            else
                return "A obra está no prazo!"

        }else{
            if(this.dataTermino > this.dataPlanejada)
                return "Esta obra foi entregue atrasada!"
            else
                return "Esta obra foi entregue no prazo!"
        }
    }

    public String getStatusPrecoObra(){
        if(this.precoPlanejado >= this.precoFinal)
            return "Esta obra não estourou o orçamento!"
        else
            return "Esta obra estourou o orçamento!"
    }
}
