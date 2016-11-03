<%@ page import="obraspublicas.Engenheiro" %>



<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="engenheiro.cpf.label" default="Cpf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" required="" value="${engenheiroInstance?.cpf}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="engenheiro.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${engenheiroInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'telefones', 'error')} ">
	<label for="telefones">
		<g:message code="engenheiro.telefones.label" default="Telefones" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${engenheiroInstance?.telefones?}" var="t">
    <li><g:link controller="telefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="telefone" action="create" params="['engenheiro.id': engenheiroInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'telefone.label', default: 'Telefone')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'obras', 'error')} ">
	<label for="obras">
		<g:message code="engenheiro.obras.label" default="Obras" />
		
	</label>
	<g:select name="obras" from="${obraspublicas.Obra.list()}" multiple="multiple" optionKey="id" size="5" value="${engenheiroInstance?.obras*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'foto', 'error')} required">
	<label for="foto">
		<g:message code="engenheiro.foto.label" default="Foto" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="foto" required="" value="${engenheiroInstance?.foto}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="engenheiro.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" required="" value="${engenheiroInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: engenheiroInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="engenheiro.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${engenheiroInstance?.email}"/>

</div>

