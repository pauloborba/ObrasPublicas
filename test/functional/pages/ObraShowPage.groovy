package pages

import geb.Page


class ObraShowPage extends Page{
    static url = "obra/show"

    static at = {
        title ==~ /Ver Obra/
    }

    static content = {
    }
}
