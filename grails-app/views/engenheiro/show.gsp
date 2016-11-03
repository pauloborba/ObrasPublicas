
<%@ page import="obraspublicas.Engenheiro" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'engenheiro.label', default: 'Engenheiro')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-engenheiro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-engenheiro" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list engenheiro">
			
				<g:if test="${engenheiroInstance?.cpf}">
				<li class="fieldcontain">
					<span id="cpf-label" class="property-label"><g:message code="engenheiro.cpf.label" default="Cpf" /></span>
					
						<span class="property-value" aria-labelledby="cpf-label"><g:fieldValue bean="${engenheiroInstance}" field="cpf"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${engenheiroInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="engenheiro.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${engenheiroInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${engenheiroInstance?.telefones}">
				<li class="fieldcontain">
					<span id="telefones-label" class="property-label"><g:message code="engenheiro.telefones.label" default="Telefones" /></span>
					
						<g:each in="${engenheiroInstance.telefones}" var="t">
						<span class="property-value" aria-labelledby="telefones-label"><g:link controller="telefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${engenheiroInstance?.obras}">
				<li class="fieldcontain">
					<span id="obras-label" class="property-label"><g:message code="engenheiro.obras.label" default="Obras" /></span>
					
						<g:each in="${engenheiroInstance.obras}" var="o">
						<span class="property-value" aria-labelledby="obras-label"><g:link controller="obra" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${engenheiroInstance?.foto}">
				<li class="fieldcontain">
					<span id="foto-label" class="property-label"><g:message code="engenheiro.foto.label" default="Foto" /></span>
					
						<span class="property-value" aria-labelledby="foto-label"><g:fieldValue bean="${engenheiroInstance}" field="foto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${engenheiroInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="engenheiro.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${engenheiroInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${engenheiroInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="engenheiro.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${engenheiroInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:engenheiroInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${engenheiroInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
