<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<body>

<c:if test="${empty sessionScope.userName }">
    <h1>
        <fmt:message key="label.enter" var="enterLabel"/>
        <label>
            <c:out value="${enterLabel}"/>
        </label>
    </h1>
    <c:if test="${requestScope.containsKey('wrongData') }">
        Неверный логин или пароль
    </c:if>
    <i class="error"> <c:if
            test="${not empty  requestScope.message }">
        <c:out value="${  requestScope.message}"/>
    </c:if>
    </i> <br/>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="SIGN_IN"/>
        <label for="loginInput">
            <fmt:message key="label.login"/>
        </label>
        <br/>
        <input id="loginInput" type="text" name="login" value=""/><br/>
        <label for="passwordInput">
            <fmt:message key="label.password"/>
        </label>
        <br/>
        <input id="passwordInput" type="password" name="password" value=""/>
        <fmt:message key="label.sign_in" var="singInLabel"/>
        <br/>
        <input type="submit" name="commit" value="${singInLabel}">

    </form>

</c:if>
</body>
<%@include file="/pages/partial/footer.jsp" %>
