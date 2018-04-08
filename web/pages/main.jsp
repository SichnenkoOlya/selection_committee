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
<fmt:message key="label.sign_out" var="signOutTxt"/>

<body>
<c:set var="lastPage" value="pages/main.jsp" scope="session" />
<c:if test="${not empty sessionScope.userName }">
    Hello, ${userRole} ${userName}
    <br>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="SIGN_OUT"/>
        <input type="submit" name="commit" value="${signOutTxt}">
    </form>
</c:if>

<c:if test="${empty sessionScope.userName }">
    <a href="${pageContext.request.contextPath}/pages/sign_in.jsp">${signInTxt}</a>
</c:if>
</body>

<%@include file="/pages/partial/footer.jsp" %>