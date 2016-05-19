
<%@ page import="obraspublicas.Obra" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'obra.label', default: 'Obra')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-obra" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-obra" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="precoPlanejado" title="${message(code: 'obra.precoPlanejado.label', default: 'Preco Planejado')}" />
					
						<g:sortableColumn property="dataPlanejada" title="${message(code: 'obra.dataPlanejada.label', default: 'Data Planejada')}" />
					
						<g:sortableColumn property="dataTermino" title="${message(code: 'obra.dataTermino.label', default: 'Data Termino')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'obra.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="empresaResponsavel" title="${message(code: 'obra.empresaResponsavel.label', default: 'Empresa Responsavel')}" />
					
						<th><g:message code="obra.endereco.label" default="Endereco" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${obraInstanceList}" status="i" var="obraInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${obraInstance.id}">${fieldValue(bean: obraInstance, field: "precoPlanejado")}</g:link></td>
					
						<td><g:formatDate date="${obraInstance.dataPlanejada}" /></td>
					
						<td><g:formatDate date="${obraInstance.dataTermino}" /></td>
					
						<td>${fieldValue(bean: obraInstance, field: "descricao")}</td>
					
						<td>${fieldValue(bean: obraInstance, field: "empresaResponsavel")}</td>
					
						<td>${fieldValue(bean: obraInstance, field: "endereco")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${obraInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
