<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 21.04.2018
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="error.wrongLoginOrPassword" var="wrongPassOrLoginTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.sign_in" var="singInTxt"/>
<fmt:message key="label.edit_user_profile" var="editProfileTxt"/>
<fmt:message key="label.save" var="saveTxt"/>
<fmt:message key="label.email" var="emailTxt"/>
<body>
<c:set var="lastPage" value="pages/sign_up.jsp" scope="session" />

<c:if test="${empty sessionScope.userName }">
    <h1>
        <label>
            <c:out value="${editProfileTxt}"/>
        </label>
    </h1>
    <c:if test="${requestScope.containsKey('wrongData')}">
        ${wrongPassOrLoginTxt}
    </c:if>
    <br/>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="EDIT_USER_PROFILE"/>
        <label for="loginInput">
                ${loginTxt}
        </label>
        <br/>
        <input id="loginInput" type="text" name="login" value="${user.login}"/>
        <br/>
        <label for="emailInput">
                ${emailTxt}
        </label>
        <br/>
        <input id="emailInput" type="text" name="email" value="${user.email}"/>

        <br/>
        <input type="submit" name="commit" value="${saveTxt}">
        <br/>
    </form>
</c:if>
</body>

<%@include file="/pages/partial/footer.jsp" %>