package steps

import pages.EntityListPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^Dummy given$/) { ->
    assert true
}

Given(~/^Dummy given web$/) { ->
    to EntityListPage
    at EntityListPage
}

When(~/^Dummy when$/) { ->
    assert true
}

Then(~/^Dummy then$/) { ->
    assert true
}