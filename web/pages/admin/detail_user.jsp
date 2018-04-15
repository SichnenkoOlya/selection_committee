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
    </tr>
    <tr>
        <th>${emailTxt}</th>
        <th>${user.email}</th>
    </tr>

</table>
</body>
<%@include file="/pages/partial/footer.jsp" %>