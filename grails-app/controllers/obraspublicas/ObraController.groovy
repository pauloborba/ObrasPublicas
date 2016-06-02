package obraspublicas



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ObraController {

    static allowedMethods = [update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Obra.list(params), model:[obraInstanceCount: Obra.count()]
    }

    def show(Obra obraInstance) {
        respond obraInstance
    }

    def create() {
        respond new Obra(params)
    }

    @Transactional
    def save() {
        Obra obraInstance = new Obra(params)
        if (obraInstance == null) {
            notFound()
            return
        }

        if (obraInstance.hasErrors()) {
            respond obraInstance.errors, view:'create'
            return
        }

        obraInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'obra.label', default: 'Obra'), obraInstance.id])
                redirect obraInstance
            }
            '*' { respond obraInstance, [status: CREATED] }
        }
    }

    def edit(Obra obraInstance) {
        respond obraInstance
    }

    @Transactional
    def update(Obra obraInstance) {
        if (obraInstance == null) {
            notFound()
            return
        }

        if (obraInstance.hasErrors()) {
            respond obraInstance.errors, view:'edit'
            return
        }

        obraInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Obra.label', default: 'Obra'), obraInstance.id])
                redirect obraInstance
            }
            '*'{ respond obraInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Obra obraInstance) {

        if (obraInstance == null) {
            notFound()
            return
        }

        obraInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Obra.label', default: 'Obra'), obraInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
