
<%@ page import="obraspublicas.Engenheiro" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'engenheiro.label', default: 'Engenheiro')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-engenheiro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-engenheiro" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="cpf" title="${message(code: 'engenheiro.cpf.label', default: 'Cpf')}" />
					
						<g:sortableColumn property="nome" title="${message(code: 'engenheiro.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="foto" title="${message(code: 'engenheiro.foto.label', default: 'Foto')}" />
					
						<g:sortableColumn property="descricao" title="${message(code: 'engenheiro.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'engenheiro.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="titulacao" title="${message(code: 'engenheiro.titulacao.label', default: 'Titulacao')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${engenheiroInstanceList}" status="i" var="engenheiroInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${engenheiroInstance.id}">${fieldValue(bean: engenheiroInstance, field: "cpf")}</g:link></td>
					
						<td>${fieldValue(bean: engenheiroInstance, field: "nome")}</td>
					
						<td>${fieldValue(bean: engenheiroInstance, field: "foto")}</td>
					
						<td>${fieldValue(bean: engenheiroInstance, field: "descricao")}</td>
					
						<td>${fieldValue(bean: engenheiroInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: engenheiroInstance, field: "titulacao")}</td>

						<td><g:link class="edit" action="edit" resource="${engenheiroInstance}"><img src="${assetPath(src: 'editIco.png')}" width="50px"/></g:link></td>

						<td>
							<g:form url="[resource:engenheiroInstance, action:'delete']" method="DELETE">
								<g:actionSubmitImage value="${message(code: 'default.button.delete.label', default: 'Delete')}" action="delete"
													 onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"
													 src="${assetPath(src: 'deleteIco.png')}" width="50px"/>
							</g:form>
						</td>
						%{--if ($ObrasAtrasadasEngenheiro&&ObrasEstouradasEngenheiro)--}%
						<td><g:link action="taxasAtrasadasEngenheiro" id="${engenheiroInstance.id}"> Taxas de atraso </g:link></td>
						<td><g:link action="taxasEstouradasEngenheiro" id="${engenheiroInstance.id}"> Taxas de estouro </g:link></td>
						%{--end--}%
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${engenheiroInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
