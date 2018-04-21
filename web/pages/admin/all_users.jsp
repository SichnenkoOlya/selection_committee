<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.users" var="usersTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.role" var="roleTxt"/>

<body>
<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="SHOW_USERS_BY_STATUS"/>
    <input type="hidden" name="statusId" value="4"/>
    <input type="submit" name="commit" value="Users with documents">
</form>

<br>
<table border="1">
    <caption>${usersTxt}</caption>
    <tr>
        <th>${loginTxt}</th>
        <th>${roleTxt}</th>
    </tr>
<c:forEach var="user" items="${users}">
    <tr>
        <td>

            <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${user.login}">${user.login}</a>
        <img src="${user.imagePath}" height="100" width="100">

        </td>
        <td>${user.role}</td>


    </tr>
</c:forEach>

</table>
</body>
<%@include file="/pages/partial/footer.jsp" %>
