<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 24.04.2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.role" var="roleTxt"/>
<fmt:message key="label.email" var="emailTxt"/>
<fmt:message key="label.phoneNumber" var="phoneNumberTxt"/>
<fmt:message key="label.enrollee.name" var="nameTxt"/>
<fmt:message key="label.enrollee.surname" var="surnameTxt"/>
<fmt:message key="label.enrollee.patronymic" var="patronymicTxt"/>
<fmt:message key="label.enrollee.phone_number" var="phoneNumberTxt"/>
<fmt:message key="label.my_profile" var="myProfileTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.change_user_photo" var="changePhotoTxt"/>
<fmt:message key="label.choose_photo" var="choosePhotoTxt"/>
<fmt:message key="label.file_not_selected" var="fileNotSelectedTxt"/>
<fmt:message key="label.ok" var="okTxt"/>
<fmt:message key="label.send_again" var="sendDocumentsAgainTxt"/>
<fmt:message key="label.message_from_admin" var="messageFromAdminTxt"/>
<fmt:message key="label.budjet_message" var="budjetTxt"/>
<fmt:message key="label.paid_message" var="paidTxt"/>
<fmt:message key="label.document_accepted_message" var="documentAcceptedTxt"/>
<fmt:message key="label.not_admitted_message" var="notAdmittedTxt"/>
<fmt:message key="label.documet_filled_message" var="documentFilledTxt"/>
<fmt:message key="label.document_rejected_message" var="documentRejectedTxt"/>
<fmt:message key="label.faculty_name" var="facultyNameTxt"/>
<fmt:message key="label.total_sum" var="totalSumTxt"/>
<fmt:message key="error.image_not_loaded" var="imageNotLoadedTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>


<fmt:setBundle basename="general" var="general"/>
<fmt:message key="status.budjet" var="budjetStatus" bundle="${general}"/>
<fmt:message key="status.paid" var="paidStatus" bundle="${general}"/>
<fmt:message key="status.accepted" var="acceptedStatus" bundle="${general}"/>
<fmt:message key="status.not_admitted" var="notAdmittedStatus" bundle="${general}"/>
<fmt:message key="status.document_fill" var="documentFillStatus" bundle="${general}"/>
<fmt:message key="status.document_rejected" var="documentRejectedStatus" bundle="${general}"/>


<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${myProfileTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${myProfileTxt}</li>
            </ol>
        </div>
    </div>
</div>


<!-- =========== MAIN ========== -->
<main id="our_staff_page">
    <div class="container">

        <div class="row">
            <c:if test="${requestScope.containsKey('imageNotLoaded')}">
                ${imageNotLoadedTxt}
                ${makeSureTxt}
            </c:if>

            <c:if test="${requestScope.containsKey('incorrectData')}">
                ${incorrectDataTxt}
                ${makeSureTxt}
            </c:if>

            <img class="img-responsive hover_effect h_yellow" src="/${user.imagePath}"
                 alt="${user.login}">

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

                        <dt>${totalSumTxt}</dt>
                        <dd>${enrollee.avarageCertificateScore+enrollee.scoreOnCT}</dd>

                        <dt>${facultyNameTxt}</dt>
                        <dd>${facultyName}</dd>


                        <c:choose>
                            <c:when test="${enrollee.statusId eq budjetStatus}">
                                ${budjetTxt}
                            </c:when>
                            <c:when test="${enrollee.statusId eq paidStatus}">
                                ${paidTxt}
                            </c:when>
                            <c:when test="${enrollee.statusId eq acceptedStatus}">
                                ${documentAcceptedTxt}
                            </c:when>
                            <c:when test="${enrollee.statusId eq notAdmittedStatus}">
                                ${notAdmittedTxt}
                            </c:when>
                            <c:when test="${enrollee.statusId eq documentFillStatus}">
                                ${documentFilledTxt}
                            </c:when>
                            <c:when test="${enrollee.statusId eq documentRejectedStatus}">

                                ${documentRejectedTxt}<br/>
                                <form action="${pageContext.request.contextPath}/mainController" method="post">
                                    <div class="form-group col-md-12">
                                        <input type="hidden" name="command" value="SHOW_ENROLLEE_FILL_PAGE"/>
                                        <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                            <i class="fa fa-check" aria-hidden="true"></i>${sendDocumentsAgainTxt}
                                        </button>
                                    </div>
                                </form>
                                <c:if test="${not empty enrollee.infoMessage}">
                                    ${messageFromAdminTxt} ${enrollee.infoMessage}
                                </c:if>
                            </c:when>
                        </c:choose>
                    </c:if>
                </dl>

                <form action="${pageContext.request.contextPath}/uploadController" method="post"
                      enctype="multipart/form-data">
                    <input type="hidden" name="command" value="CHANGE_AVATAR"/>
                    <input type="hidden" name="userId" value="${user.userId}"/>

                    <label>${changePhotoTxt}</label>
                    <br/>
                    <div class="fl_upld">
                        <label for="fl_inp" class="custom-file-upload button btn_sm btn_yellow">
                            <i class="fa fa-cloud-upload"></i>${choosePhotoTxt}
                        </label>
                        <p id="input-image" class="error display-none"></p>
                        <input data-validation="true"
                               data-type-validation="validateEmpty"
                               data-error-area-id="input-image"
                               data-error-message="${fileNotSelectedTxt}"
                               id="fl_inp"
                               type="file"
                               name="image"/>
                        <br/>
                        <div id="fl_nm" class="file-not-selected">${fileNotSelectedTxt}</div>
                        <button type="submit" class="button btn_sm btn_yellow button-one-width"><i
                                class="fa fa-check"></i>${okTxt}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>

<%@include file="/pages/partial/footer.jsp" %>