package pages

import geb.Page

/**
 * Created by Emanuel on 21/11/2016.
 */
class EngenheiroShowPage extends Page {
    static at = {
        title ==~ /Show Engenheiro/
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

    def verifyCpfEngenheiro(String cpf){
        boolean find = false
        def engenheiroRows = getDisplayedFields()
        engenheiroRows.each {engenheiroRow -> find = (find || (engenheiroRow.find('span')[1].text() == cpf))}
        return find
    }

    def getDisplayedFields(){
        def listDiv = $('div', id: 'show-engenheiro')
        def engenheiroTable = (listDiv.find('ol'))[0]
        def engenheiroRows  = engenheiroTable.find('li')

        return engenheiroRows
    }
}
