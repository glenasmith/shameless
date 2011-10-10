
<%@ page import="shameless.Account" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'account.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="username" title="${message(code: 'account.username.label', default: 'Username')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'account.password.label', default: 'Password')}" />
                        
                            <g:sortableColumn property="accountExpired" title="${message(code: 'account.accountExpired.label', default: 'Account Expired')}" />
                        
                            <g:sortableColumn property="accountLocked" title="${message(code: 'account.accountLocked.label', default: 'Account Locked')}" />
                        
                            <g:sortableColumn property="enabled" title="${message(code: 'account.enabled.label', default: 'Enabled')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${accountInstanceList}" status="i" var="accountInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${accountInstance.id}">${fieldValue(bean: accountInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: accountInstance, field: "username")}</td>
                        
                            <td>${fieldValue(bean: accountInstance, field: "password")}</td>
                        
                            <td><g:formatBoolean boolean="${accountInstance.accountExpired}" /></td>
                        
                            <td><g:formatBoolean boolean="${accountInstance.accountLocked}" /></td>
                        
                            <td><g:formatBoolean boolean="${accountInstance.enabled}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${accountInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
