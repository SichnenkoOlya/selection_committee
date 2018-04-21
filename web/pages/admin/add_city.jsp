<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18.04.2018
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.add_city" var="addCityTxt"/>
<fmt:message key="label.city_name" var="cityNameTxt"/>
<fmt:message key="label.add" var="addTxt"/>
<fmt:message key="label.country" var="countryTxt"/>

<body>

<h1>
    <label>
        <c:out value="${addCityTxt}"/>
    </label>
</h1>
<br/>
<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="SIGN_UP"/>
    <label for="cityNameInput">
        ${cityNameTxt}
    </label>
    <br/>
    <input id="cityNameInput" type="text" name="cityName" value=""/>
    <br/>

    <label for="countries">
        ${countryTxt}
    </label>

    <select id="countries" name="country">
        <c:forEach var="country" items="${countries}">
            <option value="${country.countryId}">${country.name}</option>
        </c:forEach>
    </select>

    <input type="submit" name="commit" value="${addTxt}">
    <br/>

</form>
</body>

<%@include file="/pages/partial/footer.jsp" %>