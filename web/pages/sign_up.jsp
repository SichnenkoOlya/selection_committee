<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="error.wrongLoginOrPassword" var="wrongPassOrLoginTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.password" var="passwordTxt"/>
<fmt:message key="label.sign_in" var="singInTxt"/>
<fmt:message key="label.registration" var="registrationTxt"/>
<fmt:message key="label.sign_up" var="signUpTxt"/>
<fmt:message key="label.confirm_password" var="confirmPasswordTxt"/>
<fmt:message key="label.email" var="emailTxt"/>
<body>
<c:set var="lastPage" value="pages/sign_up.jsp" scope="session" />
<c:if test="${empty sessionScope.userName }">
    <h1>
        <label>
            <c:out value="${registrationTxt}"/>
        </label>
    </h1>
    <c:if test="${requestScope.containsKey('wrongData')}">
        ${wrongPassOrLoginTxt}
    </c:if>
    <br/>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="SIGN_UP"/>
        <label for="loginInput">
                ${loginTxt}
        </label>
        <br/>
        <input id="loginInput" type="text" name="login" value=""/>
        <br/>
        <label for="passwordInput">
                ${passwordTxt}
        </label>
        <br/>
        <input id="passwordInput" type="password" name="password" value=""/>
        <br/>
        <label for="passwordConfirmInput">
                ${confirmPasswordTxt}
        </label>
        <br/>
        <input id="passwordConfirmInput" type="password" name="confirmPassword" value=""/>
        <br/>
        <label for="emailInput">
                ${emailTxt}
        </label>
        <br/>
        <input id="emailInput" type="text" name="email" value=""/>

        <br/>
        <input type="submit" name="commit" value="${signUpTxt}">
        <br/>
    </form>
</c:if>
</body>

<%@include file="/pages/partial/footer.jsp" %>

