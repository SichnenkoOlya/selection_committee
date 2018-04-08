<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.enter" var="enterLabel"/>
<fmt:message key="error.wrongLoginOrPassword" var="wrongPassOrLoginTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.password" var="passwordTxt"/>
<fmt:message key="label.sign_in" var="singInTxt"/>
<fmt:message key="label.sign_up" var="singUpTxt"/>
<body>
<c:set var="lastPage" value="pages/sign_in.jsp" scope="session" />
<c:if test="${empty sessionScope.userName }">
    <h1>
        <label>
            <c:out value="${enterLabel}"/>
        </label>
    </h1>
    <c:if test="${requestScope.containsKey('wrongData')}">
        ${wrongPassOrLoginTxt}
    </c:if>
    <br/>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="SIGN_IN"/>
        <label for="loginInput">
                ${loginTxt}
        </label>
        <br/>
        <input id="loginInput" type="text" name="login" value=""/><br/>
        <label for="passwordInput">
                ${passwordTxt}
        </label>
        <br/>
        <input id="passwordInput" type="password" name="password" value=""/>
        <br/>
        <input type="submit" name="commit" value="${singInTxt}">
        <br/>
        <a href="${pageContext.request.contextPath}/pages/sign_up.jsp">${singUpTxt}</a>
    </form>
</c:if>
</body>

<%@include file="/pages/partial/footer.jsp" %>
