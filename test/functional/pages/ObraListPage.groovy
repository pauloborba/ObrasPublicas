package pages

import geb.Page
import obraspublicas.Obra


class ObraListPage extends Page{
    static url = "obra/index"

    static at = {
        title ==~ /Obra Listagem/
    }

    static content = {
    }

    def checkObraAtList(nomeObra){
        def listDiv = $('div', id: 'list-obra')
        def obraTable = (listDiv.find('table'))[0]
        def obraRows  = obraTable.find('tbody').find('tr')
        //def obraColumns = obraRows[row].find('td')
        def testObra = Obra.findByNome(nomeObra)



        boolean find = false
        obraRows.each {obraRow -> find = (find || (obraRow[0].text() == testObra.nome && obraRow[1].text() == testObra.descricao))}

        assert (find == true)
    }

    def selectObraAtList(String nomeObra) {
        def listDiv = $('div', id: 'list-obra')
        def obraTable = (listDiv.find('table'))[0]
        def obraRow  = obraTable.find('tbody').find('tr')
        def showLink = obraRow.find('td').find([text:nomeObra])
        showLink.click()
    }
}
