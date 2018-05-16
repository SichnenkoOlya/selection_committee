<%--
  Created by IntelliJ IDEA.
  User: Olya
  Date: 28.03.2018
  Time: 0:30
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="text" scope="session"/>
<fmt:message key="label.university" var="titleTxt"/>
<html>
<head>
    <title>${titleTxt}</title>
</head>
<body>
<c:set var="locale" value="${not empty cookie.locale.value ? cookie.locale.value: 'en'}" scope="session"/>
<fmt:setLocale value="${locale}"/>
<jsp:forward page="/mainController">
    <jsp:param name="command" value="MAIN"/>
</jsp:forward>
</body>
</html>
