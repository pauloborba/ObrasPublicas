package pages

import geb.Page

class ObraShowPage extends Page{
    static url = "obra/show/1"

    static at = {
        title ==~ /Ver Obra/
    }

    static content = {
    }

    def select(String e, v) {
        if (v == 'delete') {
            assert withConfirm(true) { $("form").find(e, class: v).click() }
        } else {
            $("form").find(e, class: v).click()
        }
    }

    def verifyName(String obraName){
        return true
    }
}
