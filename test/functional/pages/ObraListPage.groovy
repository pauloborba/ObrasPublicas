package pages

import geb.Page

class ObraListPage extends Page{
    static url = "obra/index"

    static at = {
        title ==~ /Obra Listagem/
    }

    static content = {
    }

}
