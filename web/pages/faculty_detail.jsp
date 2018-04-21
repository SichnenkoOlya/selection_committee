<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.faculties" var="facultiesTxt"/>
<fmt:message key="label.facultyName" var="facultyNameTxt"/>
<fmt:message key="label.description" var="descriptionTxt"/>
<fmt:message key="label.budjet_count" var="budjetTxt"/>
<fmt:message key="label.paid_count" var="paidTxt"/>
<fmt:message key="label.paid_score" var="scorePaidTxt"/>
<fmt:message key="label.budjet_score" var="scoreBudjetTxt"/>
<fmt:message key="label.subjects" var="subjectsTxt"/>

<body>
<table border="1">
    <tr>
        <th>${facultyNameTxt}</th>
        <th>${faculty.name}</th>
    </tr>
    <tr>
        <th>${descriptionTxt}</th>
        <th>${faculty.description}</th>
    </tr>
    <tr>
        <th>${budjetTxt}</th>
        <th>${faculty.budjetPlaceCount}</th>
    </tr>
    <tr>
        <th>${paidTxt}</th>
        <th>${faculty.paidPlaceCount}</th>
    </tr>
    <tr>
        <th>${scoreBudjetTxt}</th>
        <th>${faculty.passingScoreBudjet}</th>
    </tr>
    <tr>
        <th>${scorePaidTxt}</th>
        <th>${faculty.passingScorePaid}</th>
    </tr>

    <tr>
        <th>${subjectsTxt}</th>

        <th><c:forEach var="subject" items="${faculty.subjects}">
             ${subject.name}<br>
        </c:forEach>
        </th>
    </tr>

</table>
</body>
<%@include file="/pages/partial/footer.jsp" %>
