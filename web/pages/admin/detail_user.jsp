<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 15.04.2018
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.users" var="usersTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.role" var="roleTxt"/>
<fmt:message key="label.email" var="emailTxt"/>
<fmt:message key="label.block" var="blockTxt"/>
<fmt:message key="label.unblock" var="unblockTxt"/>
<fmt:message key="label.makeAdmin" var="makeAdminTxt"/>


<fmt:message key="label.phoneNumber" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.name" var="nameTxt"/>
<fmt:message key="label.enrollee.surname" var="surnameTxt"/>
<fmt:message key="label.enrollee.patronymic" var="patronymicTxt"/>
<fmt:message key="label.enrollee.phone_number" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.faculty" var="facultyTxt"/>
<fmt:message key="label.city" var="cityTxt"/>
<fmt:message key="label.country" var="countryTxt"/>
<fmt:message key="label.passport" var="passportTxt"/>
<fmt:message key="label.sertificateScore" var="sertificateScoreTxt"/>
<body>

<table border="1">
    <caption>${usersTxt}</caption>
    <tr>
        <th>${loginTxt}</th>
        <th>${user.login}</th>
    </tr>
    <tr>
        <th>${roleTxt}</th>
        <th>${user.role}</th>
        <c:if test="${user.role=='USER'}">
            <form action="${pageContext.request.contextPath}/mainController" method="post">
                <input type="hidden" name="command" value="CHANGE_USER_ROLE"/>
                <input type="hidden" name="id" value="${user.userId}"/>
                <input type="hidden" name="role" value="ADMIN"/>
                <input type="submit" name="commit" value="${makeAdminTxt}">
            </form>
        </c:if>
    </tr>
    <tr>
        <th>${emailTxt}</th>
        <th>${user.email}</th>
    </tr>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="CHANGE_USER_LOCK"/>
        <input type="hidden" name="id" value="${user.userId}"/>
        <input type="hidden" name="lock" value="${not user.isBlocked}"/>
        <c:if test="${user.isBlocked}">
            <input type="submit" name="commit" value="${unblockTxt}">
        </c:if>
        <c:if test="${not user.isBlocked}">
            <input type="submit" name="commit" value="${blockTxt}">
        </c:if>
    </form>
</table>

<c:if test="${ not empty enrollee}">
    <table border="1">
        <tr>
            <th>${surnameTxt}</th>
            <th>${enrollee.surname}</th>
        </tr>
        <tr>
            <th>${nameTxt}</th>
            <th>${enrollee.name}</th>
        </tr>
        <tr>
            <th>${patronymicTxt}</th>
            <th>${enrollee.patronymic}</th>
        </tr>
        <tr>
            <th>${phoneNumberTxt}</th>
            <th>${enrollee.phoneNumber}</th>
        </tr>
    </table>
    <td>
    <c:if test="${enrollee.statusId eq 6}">
        <form action="${pageContext.request.contextPath}/mainController" method="post">
            <input type="hidden" name="command" value="CHANGE_ENROLLEE_STATUS"/>
            <input type="hidden" name="newStatusId" value="4"/>
            <input type="hidden" name="userId" value="${user.userId}"/>
            <input type="submit" name="commit" value="Confirm document">
        </form>
    </c:if>
</td>
</c:if>
</body>
<%@include file="/pages/partial/footer.jsp" %>