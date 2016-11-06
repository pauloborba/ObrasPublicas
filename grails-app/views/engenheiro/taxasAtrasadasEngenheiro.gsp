<%--
  Created by IntelliJ IDEA.
  User: Emanuel
  Date: 04/11/2016
  Time: 23:01
--%>


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
<div id="list-taxaatraso">
    <h2>
        O percentual de obras atrasadas desse engenheiro é ${taxaAtrasadaEngenheiro}%
    </h2>
</div>
</body>
</html>