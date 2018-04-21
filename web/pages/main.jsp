<%@ taglib prefix="ctg" uri="http://sichnenko.by/pages/" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 31.03.2018
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.sign_in" var="signInTxt"/>
<fmt:message key="label.sign_out" var="signOutTxt"/>
<fmt:message key="label.my_profile" var="myProfileTxt"/>
<fmt:message key="label.faculties" var="facultiesTxt"/>
<fmt:message key="label.facultyName" var="facultyNameTxt"/>
<fmt:message key="label.description" var="descriptionTxt"/>
<fmt:message key="label.change_password" var="changePasswordTxt"/>
<body>

<br>

<br>
<c:if test="${requestScope.containsKey('errorLoadingFaculties')}">
    errorLoadingFaculties
</c:if>

<form action="${pageContext.request.contextPath}/uploadController" method="post" enctype="multipart/form-data">
    <input type="hidden" name="command" value="LOAD_FACULTY_IMAGE"/>
    <input type="hidden" name="facultyId" value="1"/>
    <input type="file" name="image" />
    <input type="submit" />
</form>

<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="SHOW_ENROLLEE_FILL_PAGE"/>
    <input type="submit" name="commit" value="${myProfileTxt}">
</form>


<c:if test="${not empty sessionScope.login }">
    Hello, ${userRole} ${login}
    <br>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="SIGN_OUT"/>
        <input type="submit" name="commit" value="${signOutTxt}">
    </form>
    <br>

    <br>
    <form action="${pageContext.request.contextPath}/uploadController" method="post" enctype="multipart/form-data">
        <input type="hidden" name="command" value="CHANGE_AVATAR"/>
        <input type="hidden" name="userId" value="${user.userId}"/>
        <input type="file" name="image" />
        <input type="submit" />
    </form>
    <br>

    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="SHOW_ENROLLEE_FILL_PAGE"/>
        <input type="submit" name="commit" value="${myProfileTxt}">
    </form>

    <a href="${pageContext.request.contextPath}/pages/edit_profile.jsp">Редактировать</a>


</c:if>

<c:if test="${empty sessionScope.login }">
    <a href="${pageContext.request.contextPath}/pages/sign_in.jsp">${signInTxt}</a>
</c:if>
</body>

<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="SHOW_ALL_USERS"/>
    <input type="submit" name="commit" value="Users">
</form>

<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="SHOW_CHANGE_PASSWORD_PAGE"/>
    <input type="submit" name="commit" value="${changePasswordTxt}">
</form>
<ctg:admin role="${role}">
<form action="${pageContext.request.contextPath}/mainController" method="post">
    <input type="hidden" name="command" value="SHOW_ADD_FACULTY_PAGE"/>
    <input type="submit" name="commit" value="Add new faculty">
</form>
</ctg:admin>
<table border="1">
    <caption>${facultiesTxt}</caption>
    <tr>
        <th>${facultyNameTxt}</th>
        <th>${descriptionTxt}</th>
    </tr>
    <c:forEach var="faculty" items="${faculties}">
        <tr>
                <%--<td> <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_USER&login=${user.login}">${user.login}</a></td>--%>
            <td>
                <a href="${pageContext.request.contextPath}/mainController?command=SHOW_DETAIL_FACULTY&facultyId=${faculty.facultyId}">${faculty.name}</a>
            </td>

            <td><img src="${faculty.imagePath}" height="100" width="100"><br>${faculty.description}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="/pages/partial/footer.jsp" %>