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
<fmt:message key="label.block" var="blockTxt"/>
<fmt:message key="label.unblock" var="unblockTxt"/>
<fmt:message key="label.makeAdmin" var="makeAdminTxt"/>


<fmt:message key="label.phoneNumber" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.name" var="nameTxt"/>
<fmt:message key="label.enrollee.surname" var="surnameTxt"/>
<fmt:message key="label.enrollee.patronymic" var="patronymicTxt"/>
<fmt:message key="label.enrollee.phone_number" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.faculty" var="facultyTxt"/>
<fmt:message key="label.city" var="cityTxt"/>
<fmt:message key="label.country" var="countryTxt"/>
<fmt:message key="label.passport" var="passportTxt"/>
<fmt:message key="label.sertificateScore" var="sertificateScoreTxt"/>
<body>

<div class="page_title gradient_overlay" style="background: url(images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>Our Users</h1>
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Our Users</li>
            </ol>
        </div>
    </div>
</div>


<!-- =========== MAIN ========== -->
<main id="our_staff_page">
    <div class="container">

        <div class="row">

            <div class="col-md-6">
                <dl class="info">
                    <dt>${loginTxt}</dt>
                    <dd>${user.login}</dd>

                    <dt>${roleTxt}</dt>
                    <dd>${user.role}</dd>

                    <dt>${emailTxt}</dt>
                    <dd>${user.email}</dd>

                    <c:if test="${ not empty enrollee}">

                        <dt>${surnameTxt}</dt>
                        <dd>${enrollee.surname}</dd>

                        <dt>${nameTxt}</dt>
                        <dd>${enrollee.name}</dd>

                        <dt>${patronymicTxt}</dt>
                        <dd>${enrollee.patronymic}</dd>

                        <dt>${phoneNumberTxt}</dt>
                        <dd>${enrollee.phoneNumber}</dd>

                    </c:if>
                </dl>


                <form action="${pageContext.request.contextPath}/mainController" method="post">
                    <input type="hidden" name="command" value="CHANGE_USER_LOCK"/>
                    <input type="hidden" name="id" value="${user.userId}"/>
                    <input type="hidden" name="lock" value="${not user.isBlocked}"/>
                    <c:if test="${user.isBlocked}">
                        <input type="submit" name="commit" value="${unblockTxt}">
                    </c:if>
                    <c:if test="${not user.isBlocked}">
                        <input type="submit" name="commit" value="${blockTxt}">
                    </c:if>
                </form>

                <c:if test="${user.role=='USER'}">
                    <form action="${pageContext.request.contextPath}/mainController" method="post">
                        <input type="hidden" name="command" value="CHANGE_USER_ROLE"/>
                        <input type="hidden" name="id" value="${user.userId}"/>
                        <input type="hidden" name="role" value="ADMIN"/>
                        <input type="submit" name="commit" value="${makeAdminTxt}">
                    </form>
                </c:if>

                <c:if test="${ not empty enrollee}">
                    <c:if test="${enrollee.statusId eq 6}">
                        <form action="${pageContext.request.contextPath}/mainController" method="post">
                            <input type="hidden" name="command" value="CHANGE_ENROLLEE_STATUS"/>
                            <input type="hidden" name="newStatusId" value="4"/>
                            <input type="hidden" name="userId" value="${user.userId}"/>
                            <input type="submit" name="commit" value="Confirm document">
                        </form>
                    </c:if>
                </c:if>

            </div>
        </div>
    </div>
</main>


<%@include file="/pages/partial/footer.jsp" %>