<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
    <title><spring:message code="label.signin"/></title>
</head>
<body>

<c:if test="${not empty param.error}">
    <spring:message code="label.loginerror" />
</c:if>

<form method="POST" action="<c:url value="/j_spring_security_check" />">
    <table>
        <tr>
            <td align="right"><spring:message code="label.login"/> </td>
            <td><input type="text" name="j_username" /></td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.password" /></td>
            <td><input type="password" name="j_password" /></td>
        </tr>

        <tr>
            <td><a href="<c:url value="/registration" />"><spring:message code="label.signup" /></a></td>
            <td colspan="2"><input type="submit" value=<spring:message code="label.signin"/> /></td>
        </tr>
    </table>
</form>
</body>
</html>