package pages

import geb.Page

class ObraShowPage extends Page{
   // static url = "obra/show/1" //não precisa disso pq vc não usa to ObraShowPage, vc clica num link q redireciona pra ela
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

    def verifyName(String nomeObra){
        def listDiv = $('div', id: 'show-obra')
        def obraTable = (listDiv.find('ol'))[0]
        def obraRows  = obraTable.find('li')
        //def obraColumns = obraRows[row].find('td')
        //def testObra = Obra.findByNome(nomeObra)

        boolean find = false
        obraRows.each {obraRow -> find = (find || (obraRow.find('span')[1].text() == nomeObra))}
        return find
    }
}
