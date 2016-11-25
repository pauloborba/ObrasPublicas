package pages

import geb.Page
import obraspublicas.Engenheiro

/**
 * Created by Emanuel on 21/11/2016.
 */
class EngenheiroListPage extends Page {
    static url = "engenheiro/index"

    static at = {
        title ==~ /Engenheiro List/
    }

    static content = {
    }

    def checkEngenheiroAtList(cpf){
        def engenheiroRows = getTableRows()
        def testEngenheiro = Engenheiro.findByCpf(cpf)

        boolean find = false
        engenheiroRows.each {engenheiroRow -> find = (find || (engenheiroRow.find('td')[0].text() == testEngenheiro.cpf))}

        return find
    }

    def selectEngenheiroAtList(String cpf) {
        def engenheiroRow  = getTableRows()
        def showLink = engenheiroRow.find('td').find([text:cpf])
        showLink.click()
    }
    def selectTaxaAtrasada() {
        def engenheiroRow  = getTableRows()
        def showLink = engenheiroRow.find('td').find("taxasAtrasadasEngenheiro")
        showLink.click()
    }
    def getTableRows(){
        def listDiv = $('div', id: 'list-engenheiro')
        def obraTable = (listDiv.find('table'))[0]
        def obraRow  = obraTable.find('tbody').find('tr')

        return obraRow
    }
}
