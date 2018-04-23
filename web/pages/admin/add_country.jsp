<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18.04.2018
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.add_country" var="addCountryTxt"/>
<fmt:message key="label.country_name" var="countryNameTxt"/>
<fmt:message key="label.add" var="addTxt"/>

<body>

<c:set var="lastPage" value="pages/admin/add_country.jsp" scope="session" />

<h1>
    <label>
        <c:out value="${addCountryTxt}"/>
    </label>
</h1>
<br/>
<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="ADD_COUNTRY"/>
    <label for="countryNameInput">
        ${countryNameTxt}
    </label>
    <br/>
    <input id="countryNameInput" type="text" name="countryName" value=""/>
    <br/>

    <input type="submit" name="commit" value="${addTxt}">
    <br/>

</form>
</body>

<%@include file="/pages/partial/footer.jsp" %>

