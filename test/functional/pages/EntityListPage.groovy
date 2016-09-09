package pages

import geb.Page
import steps.InternationalizationHelper

class EntityListPage extends Page {
    static url = 'entity/index'

    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance

        String entity = "Entity"
        String entityList = helper.getMessage("default.list.label", entity)

        title ==~ entityList
    }
}