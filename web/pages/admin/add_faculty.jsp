<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18.04.2018
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.add_faculty" var="addFacultyTxt"/>
<fmt:message key="label.facultyName" var="facultyNameTxt"/>
<fmt:message key="label.description" var="descriptionTxt"/>
<fmt:message key="label.budjet_count" var="budjetTxt"/>
<fmt:message key="label.paid_count" var="paidTxt"/>
<fmt:message key="label.paid_score" var="scorePaidTxt"/>
<fmt:message key="label.budjet_score" var="scoreBudjetTxt"/>
<fmt:message key="label.subjects" var="subjectsTxt"/>
<fmt:message key="label.add" var="addTxt"/>
<body>

<c:set var="lastPage" value="pages/admin/add_faculty.jsp" scope="session" />

    <h1>
        <label>
            <c:out value="${addFacultyTxt}"/>
        </label>
    </h1>
    <br/>
    <form action="${pageContext.request.contextPath}/mainController" method="post">
        <input type="hidden" name="command" value="ADD_NEW_FACULTY"/>
        <label for="facultyNameInput">
                ${facultyNameTxt}
        </label>
        <br/>
        <input id="facultyNameInput" type="text" name="facultyName" value=""/>
        <br/>

        <label for="descriptionFacultyInput">
            ${descriptionTxt}
        </label>
        <br/>
        <textarea id="descriptionFacultyInput" cols="40" rows="5" name="facultyDescription"></textarea>
        <br/>

        <label for="budjetInput">
            ${budjetTxt}
        </label>
        <br/>
        <input id="budjetInput" type="text" name="budjetCount" value=""/>
        <br/>


        <label for="paidInput">
            ${paidTxt}
        </label>
        <br/>
        <input id="paidInput" type="text" name="paidCount" value=""/>
        <br/>

        <%--<label for="scorePaidInput">--%>
            <%--${scorePaidTxt}--%>
        <%--</label>--%>
        <%--<br/>--%>
        <%--<input id="scorePaidInput" type="text" name="paidScore" value=""/>--%>
        <%--<br/>--%>

        <%--<label for="scoreBudjetInput">--%>
            <%--${scoreBudjetTxt}--%>
        <%--</label>--%>
        <%--<br/>--%>
        <%--<input id="scoreBudjetInput" type="text" name="budjetScore" value=""/>--%>
        <br/>
        <c:forEach var="subject" items="${subjects}">
            <label for="subjects">
                <input id="subjects" type="checkbox" name="idSubject" value="${subject.subjectId}">${subject.name}<BR>
            </label>
        </c:forEach>
        <input type="submit" name="commit" value="${addTxt}">
        <br/>

    </form>
</body>

<%@include file="/pages/partial/footer.jsp" %>

