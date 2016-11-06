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

    @Transactional
    def save(Engenheiro engenheiroInstance) {
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
