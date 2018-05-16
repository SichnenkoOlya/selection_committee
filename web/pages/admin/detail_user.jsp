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
<fmt:message key="label.confirm_document" var="confirmDocumentTxt"/>
<fmt:message key="label.reject_document" var="rejectDocumentTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.message" var="messageTxt"/>
<fmt:message key="label.sertificateScore" var="sertifacateTxt"/>
<fmt:message key="label.score_on_ct" var="scoreOnCTTxt"/>
<fmt:message key="label.faculty_name" var="facultyTxt"/>

<fmt:setBundle basename="general" var="general"/>
<fmt:message key="status.accepted" var="acceptedStatus" bundle="${general}"/>
<fmt:message key="status.document_fill" var="documentFillStatus" bundle="${general}"/>
<fmt:message key="status.document_rejected" var="documentRejectedStatus" bundle="${general}"/>

<body>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${findUser.login}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li><a href="${pageContext.request.contextPath}/mainController">${usersTxt}</a></li>
                <li>${findUser.login}</li>
            </ol>
        </div>
    </div>
</div>


<!-- =========== MAIN ========== -->
<main id="our_staff_page">
    <div class="container">

        <div class="row">

            <div class="col-md-12">
                <img class="img-responsive hover_effect h_yellow"
                     src="${pageContext.request.contextPath}${findUser.imagePath}"
                     alt="${findUser.login}">
            </div>
            <div class="col-md-6">

                <dl class="info custom-info">
                    <dt>${loginTxt}</dt>
                    <dd>${findUser.login}</dd>

                    <dt>${roleTxt}</dt>
                    <dd>${findUser.role}</dd>

                    <dt>${emailTxt}</dt>
                    <dd>${findUser.email}</dd>

                    <c:if test="${ not empty findEnrollee}">

                        <dt>${surnameTxt}</dt>
                        <dd>${findEnrollee.surname}</dd>

                        <dt>${nameTxt}</dt>
                        <dd>${findEnrollee.name}</dd>

                        <dt>${patronymicTxt}</dt>
                        <dd>${findEnrollee.patronymic}</dd>

                        <dt>${phoneNumberTxt}</dt>
                        <dd>${findEnrollee.phoneNumber}</dd>

                        <dt>${sertifacateTxt}</dt>
                        <dd>${findEnrollee.avarageCertificateScore}</dd>

                        <dt>${scoreOnCTTxt}</dt>
                        <dd>${findEnrollee.scoreOnCT}</dd>

                        <dt>${facultyTxt}</dt>
                        <dd>${faculty.name}</dd>

                    </c:if>
                </dl>

            </div>
            <div class="col-md-6">

                <form action="${pageContext.request.contextPath}/mainController" method="post" class="form-detail-user">
                    <input type="hidden" name="command" value="CHANGE_USER_LOCK"/>
                    <input type="hidden" name="id" value="${findUser.userId}"/>
                    <input type="hidden" name="lock" value="${not findUser.isBlocked}"/>
                    <div class="form-group col-md-12">
                        <c:if test="${findUser.isBlocked}">
                            <button type="submit" class="button btn_lg btn_yellow">${unblockTxt}</button>
                            <%--<input type="submit" name="commit" value="${unblockTxt}">--%>
                        </c:if>
                        <c:if test="${not findUser.isBlocked}">
                            <button type="submit" class="button btn_lg btn_yellow">${blockTxt}</button>
                            <%--<input type="submit" name="commit" value="${blockTxt}">--%>
                        </c:if>
                    </div>
                </form>

                <c:if test="${findUser.role=='USER'}">
                    <form action="${pageContext.request.contextPath}/mainController" method="post" class="form-detail-user">
                        <input type="hidden" name="command" value="CHANGE_USER_ROLE"/>
                        <input type="hidden" name="id" value="${findUser.userId}"/>
                        <input type="hidden" name="role" value="ADMIN"/>
                        <div class="form-group col-md-12">
                            <button type="submit" class="button btn_lg btn_yellow">${makeAdminTxt}</button>
                        </div>
                    </form>
                </c:if>

                <c:if test="${ not empty findEnrollee}">

                    <c:if test="${findEnrollee.statusId eq documentFillStatus}">

                        <form action="${pageContext.request.contextPath}/mainController" method="post" class="form-detail-user">
                            <input type="hidden" name="command" value="CHANGE_ENROLLEE_STATUS"/>
                            <input type="hidden" name="newStatusId" value="${acceptedStatus}"/>

                            <input type="hidden" name="userId" value="${findUser.userId}"/>
                            <div class="form-group col-md-12">
                                <input type="submit" class="button btn_lg btn_yellow" name="commit"
                                       value="${confirmDocumentTxt}">
                            </div>
                        </form>

                        <form id="reject-document" action="${pageContext.request.contextPath}/mainController" method="post" class="form-detail-user">
                            <input type="hidden" name="command" value="CHANGE_ENROLLEE_STATUS"/>
                            <input type="hidden" name="newStatusId" value="${documentRejectedStatus}"/>
                            <input type="hidden" name="userId" value="${findUser.userId}"/>
                            <div id="reject-textarea" class="form-group col-md-12" style="display: none">
                                <label class="control-label">${messageTxt}</label>
                                <textarea class="form-control" name="message" placeholder="${messageTxt}"></textarea>
                            </div>
                            <div class="form-group col-md-12">
                                <input type="submit" class="button btn_lg btn_yellow" name="commit"
                                       data-show-textarea="true"
                                       value="${rejectDocumentTxt}">
                            </div>
                        </form>

                    </c:if>
                </c:if>

            </div>
        </div>
    </div>
</main>


<%@include file="/pages/partial/footer.jsp" %>