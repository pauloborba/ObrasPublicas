
<%@ page import="obraspublicas.Politico" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'politico.label', default: 'Politico')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-politico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-politico" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="cpf" title="${message(code: 'politico.cpf.label', default: 'Cpf')}" />
					
						<g:sortableColumn property="nome" title="${message(code: 'politico.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="foto" title="${message(code: 'politico.foto.label', default: 'Foto')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'politico.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'politico.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="partido" title="${message(code: 'politico.partido.label', default: 'Partido')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${politicoInstanceList}" status="i" var="politicoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${politicoInstance.id}">${fieldValue(bean: politicoInstance, field: "cpf")}</g:link></td>
					
						<td>${fieldValue(bean: politicoInstance, field: "nome")}</td>
					
						<td>${fieldValue(bean: politicoInstance, field: "foto")}</td>
					
						<td>${fieldValue(bean: politicoInstance, field: "descricao")}</td>
					
						<td>${fieldValue(bean: politicoInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: politicoInstance, field: "partido")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${politicoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
