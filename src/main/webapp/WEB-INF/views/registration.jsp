<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title><spring:message code="label.registration"/></title>
    </head>
    <body>
        <form:form method="post" action="/user/add" commandName="user">
            <table>
                <c:if test="${!empty message}" >
                    <tr>
                        <td></td>
                        <td>
                            <spring:message code="label.login"/> <spring:message code="label.buzy"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td><form:label path="email"><spring:message code="label.login"/></form:label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"><input type="submit" value=<spring:message code="label.send"/> /></td>
                </tr>
            </table>
        </form:form>
        <a href="<c:url value="/signin"/>" ><spring:message code="label.signin"/></a>
    </body>
</html>
