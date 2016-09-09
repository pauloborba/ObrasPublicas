<%@ page import="obraspublicas.Entity" %>



<div class="fieldcontain ${hasErrors(bean: entityInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="entity.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${entityInstance?.name}"/>

</div>

