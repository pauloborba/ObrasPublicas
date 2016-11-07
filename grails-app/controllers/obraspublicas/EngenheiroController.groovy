package obraspublicas



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EngenheiroController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Engenheiro.list(params), model:[engenheiroInstanceCount: Engenheiro.count()]
    }

    def show(Engenheiro engenheiroInstance) {
        respond engenheiroInstance
    }

    def create() {
        respond new Engenheiro(params)
    }
//if ($ObrasAtrasadasEngenheiro&&ObrasEstouradasEngenheiro)
    //Refatoração em taxasAtrasadasEngenheiro e taxasEstouradasEngenheiro
    def qtdObrasEngenheiroResponsavel(Engenheiro engenheiro) {
        int qtdObras = 0;
        if (Obra.list().size() > 0) {
            for (int i = 0; i < Obra.list().size(); i++) {
                if (Obra.list().get(i).getCpfEngenheiroResponsavel().equals(engenheiro.cpf)) {
                    qtdObras++;
                }
            }
        }
        return qtdObras
    }
    //Refatoração
    def obraAtrasadaOrEstourada(){
        float taxaAtrasada = 0;
        float taxaEstourada = 0;
        if (Obra.list().size() > 0){
            for(int i = 0; i < Obra.list().size(); i++){
                if(Obra.list().get(i).isAtrasada()){
                    taxaAtrasada++;
                }
                if(Obra.list().get(i).isEstourada()){
                    taxaEstourada++;
                }
            }
        }
        Map<String, Float> taxas = new HashMap<String, Float>();
        taxas.put("taxaAtrasada", taxaAtrasada);
        taxas.put("taxaEstourada", taxaEstourada)
        return taxas
//        List taxas = new ArrayList()
//        taxas.add(taxaAtrasada)
//        taxas.add(taxaEstourada)
//        return taxas
    }

    def taxasAtrasadasEngenheiro(Engenheiro engenheiro) {
        float taxaAtrasada = obraAtrasadaOrEstourada().get("taxaAtrasada")
        taxaAtrasada = (taxaAtrasada / qtdObrasEngenheiroResponsavel(engenheiro)) * 100
        respond Engenheiro.list(params), model: [taxaAtrasadaEngenheiro: taxaAtrasada]
    }

    def taxasEstouradasEngenheiro(Engenheiro engenheiro) {
        float taxaEstourada = obraAtrasadaOrEstourada().get("taxaEstourada")
        taxaEstourada = (taxaEstourada / qtdObrasEngenheiroResponsavel(engenheiro)) * 100
        respond Engenheiro.list(params), model: [taxasEstouradasEngenheiro: taxaEstourada]
    }
//end

    @Transactional
    def save() {
        Engenheiro engenheiroInstance = new Engenheiro(params)

        if (engenheiroInstance == null) {
            notFound()
            return
        }

        if (engenheiroInstance.hasErrors()) {
            respond engenheiroInstance.errors, view:'create'
            return
        }

        engenheiroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'engenheiro.label', default: 'Engenheiro'), engenheiroInstance.id])
                redirect engenheiroInstance
            }
            '*' { respond engenheiroInstance, [status: CREATED] }
        }
    }

    def edit(Engenheiro engenheiroInstance) {
        respond engenheiroInstance
    }

    @Transactional
    def update(Engenheiro engenheiroInstance) {
        if (engenheiroInstance == null) {
            notFound()
            return
        }

        if (engenheiroInstance.hasErrors()) {
            respond engenheiroInstance.errors, view:'edit'
            return
        }

        engenheiroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Engenheiro.label', default: 'Engenheiro'), engenheiroInstance.id])
                redirect engenheiroInstance
            }
            '*'{ respond engenheiroInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Engenheiro engenheiroInstance) {

        if (engenheiroInstance == null) {
            notFound()
            return
        }

        engenheiroInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Engenheiro.label', default: 'Engenheiro'), engenheiroInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'engenheiro.label', default: 'Engenheiro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
