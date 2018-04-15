<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.users" var="usersTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.role" var="roleTxt"/>

<body>
<table border="1">
    <caption>${usersTxt}</caption>
    <tr>
        <th>${loginTxt}</th>
        <th>${roleTxt}</th>
    </tr>
<c:forEach var="user" items="${users}">
    <tr>
        <td> <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${user.login}">${user.login}</a></td>
        <td>${user.role}</td>
    </tr>
</c:forEach>

</table>
</body>
<%@include file="/pages/partial/footer.jsp" %>
