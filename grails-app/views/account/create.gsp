

<%@ page import="shameless.Account" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${accountInstance}">
            <div class="errors">
                <g:renderErrors bean="${accountInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="username"><g:message code="account.username.label" default="Username" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'username', 'errors')}">
                                    <g:textField name="username" value="${accountInstance?.username}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="account.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'password', 'errors')}">
                                    <g:textField name="password" value="${accountInstance?.password}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountExpired"><g:message code="account.accountExpired.label" default="Account Expired" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'accountExpired', 'errors')}">
                                    <g:checkBox name="accountExpired" value="${accountInstance?.accountExpired}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountLocked"><g:message code="account.accountLocked.label" default="Account Locked" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'accountLocked', 'errors')}">
                                    <g:checkBox name="accountLocked" value="${accountInstance?.accountLocked}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enabled"><g:message code="account.enabled.label" default="Enabled" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'enabled', 'errors')}">
                                    <g:checkBox name="enabled" value="${accountInstance?.enabled}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwordExpired"><g:message code="account.passwordExpired.label" default="Password Expired" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'passwordExpired', 'errors')}">
                                    <g:checkBox name="passwordExpired" value="${accountInstance?.passwordExpired}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="realName"><g:message code="account.realName.label" default="Real Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: accountInstance, field: 'realName', 'errors')}">
                                    <g:textField name="realName" value="${accountInstance?.realName}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
