<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 25.04.2018
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.confirm_document" var="confirmDocumentTxt"/>
<fmt:message key="label.list_enrollees" var="listEnrolleesTxt"/>
<fmt:message key="label.empty_enrolle_list" var="emptyEnrolleesTxt"/>
<fmt:message key="label.enrollees" var="enrolleesTxt"/>
<fmt:message key="label.home" var="homeTxt"/>

<body>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${enrolleesTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${enrolleesTxt}</li>
            </ol>
        </div>
    </div>
</div>


<!-- =========== MAIN ========== -->
<main id="our_staff_page">
    <ctg:emptyList items="${enrollees}">
        <h2>${emptyEnrolleesTxt}</h2>
    </ctg:emptyList>

    <div class="container">
        <c:if test="${not empty enrollees}">
            <div class="row">

                <div class="col-md-6">
                    <h3>${listEnrolleesTxt}</h3>

                    <dl class="info custom-info">
                        <c:forEach var="enrollee" items="${enrollees}">
                            <dt>${enrollee.surname} ${enrollee.name} ${enrollee.patronymic}</dt>
                            <dd>${enrollee.avarageCertificateScore+enrollee.scoreOnCT}</dd>
                        </c:forEach>
                    </dl>

                </div>
            </div>
        </c:if>

        <%--<ctg:admin role="${user.role}">--%>

            <%--<form action="${pageContext.request.contextPath}/mainController" method="post">--%>
                <%--<input type="hidden" name="command" value="CHANGE_ENROLLEE_STATUS"/>--%>
                <%--<input type="hidden" name="newStatusId" value="4"/>--%>
                <%--<input type="hidden" name="userId" value="${user.userId}"/>--%>
                <%--<input type="submit" name="commit" value="${confirmDocumentTxt}">--%>
            <%--</form>--%>
        <%--</ctg:admin>--%>
    </div>
</main>


<%@include file="/pages/partial/footer.jsp" %>