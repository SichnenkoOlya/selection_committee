<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'en'}" scope="session"/>
<fmt:setLocale value="${locale}"/>
<c:set var="userName" value="${sessionScope.get('userName')}"/>
<c:set var="userRole" value="${sessionScope.get('userRole')}"/>

<fmt:setBundle basename="text" scope="session"/>
<fmt:message key="label.Russian" var="russianTxt"/>
<fmt:message key="label.English" var="englishTxt"/>

<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>


<header>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="CHANGE_LOCALE"/>
        <input type="hidden" name="locale" value="ru"/>
        <select onchange="submit()">
            <option name="locale" value="ru" >${russianTxt}</option>
            <option name="locale" value="en" >${englishTxt}</option>
        </select>
        <input id="russian" type="submit" name="commit" value=${russianTxt}>
    </form>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="CHANGE_LOCALE"/>
        <input type="hidden" name="locale" value="en"/>
        <input id="english" type="submit" name="commit" value=${englishTxt}>
    </form>
</header>