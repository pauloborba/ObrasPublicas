package obraspublicas



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PoliticoController {

    static allowedMethods = [update: "PUT"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Politico.list(params), model:[politicoInstanceCount: Politico.count()]
    }

    def show(Politico politicoInstance) {
        respond politicoInstance
    }

    def create() {
        respond new Politico(params)
    }

    @Transactional
    def save() {
        Politico politicoInstance = new Politico(params)
        if (politicoInstance == null) {
            notFound()
            return
        }

        if (politicoInstance.hasErrors()) {
            respond politicoInstance.errors, view:'create'
            return
        }

        politicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'politico.label', default: 'Politico'), politicoInstance.id])
                redirect politicoInstance
            }
            '*' { respond politicoInstance, [status: CREATED] }
        }
    }

    def edit(Politico politicoInstance) {
        respond politicoInstance
    }

    @Transactional
    def update(Politico politicoInstance) {
        if (politicoInstance == null) {
            notFound()
            return
        }

        if (politicoInstance.hasErrors()) {
            respond politicoInstance.errors, view:'edit'
            return
        }

        politicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Politico.label', default: 'Politico'), politicoInstance.id])
                redirect politicoInstance
            }
            '*'{ respond politicoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {

        Politico politicoInstance = new Politico(params)

        if (politicoInstance == null) {
            notFound()
            return
        }

        politicoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Politico.label', default: 'Politico'), politicoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'politico.label', default: 'Politico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
