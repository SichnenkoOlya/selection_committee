<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 31.03.2018
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.sign_in" var="signInTxt"/>

<body>
<c:if test="${not empty sessionScope.userName }">
    Hello, ${userRole} ${userName}
    <br>
    <form action="mainController" method="post">
        <input type="hidden" name="command" value="SIGN_OUT"/>
        <input type="submit" name="commit" value="${signInTxt}">
    </form>
</c:if>

<c:if test="${not empty sessionScope.userName }">
    Hello, ${userRole} ${userName}
    <br>
    <form action="mainController" method="post">
        <input type="hidden" name="command" value="SIGN_OUT"/>
        <input type="submit" name="commit" value="${signInTxt}">
    </form>
</c:if>
</body>

<%@include file="/pages/partial/footer.jsp" %>