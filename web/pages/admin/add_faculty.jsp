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
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.finish_date" var="finishDateTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>
<fmt:message key="error.faculty_exist" var="suchFacultyExistTxt"/>

<body>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${addFacultyTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${addFacultyTxt}</li>
            </ol>
        </div>
    </div>
</div>

<main>
    <div class="container">

        <div class="row">
            <div class="col-md-6">
                <c:if test="${empty sessionScope.userName }">
                    <div class="main_title a_left">
                        <h2><c:out value="${addFacultyTxt}"/></h2>
                    </div>

                    <c:if test="${requestScope.containsKey('incorrectData')}">
                        ${incorrectDataTxt}
                        ${makeSureTxt}
                    </c:if>
                    <c:if test="${requestScope.containsKey('suchFacultyExist')}">
                        ${suchFacultyExistTxt}
                    </c:if>

                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post">
                        <input type="hidden" name="command" value="ADD_NEW_FACULTY"/>
                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${facultyNameTxt}</label>
                                <p id="input-facultyName" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateEmpty"
                                       data-error-area-id="input-facultyName"
                                       data-error-message="${incorrectDataTxt}"
                                       type="text"
                                       class="form-control"
                                       name="facultyName"
                                       placeholder="${facultyNameTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${descriptionTxt}</label>
                                <p id="input-facultyDescription" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateEmpty"
                                       data-error-area-id="input-facultyDescription"
                                       data-error-message="${incorrectDataTxt}"
                                       type="text"
                                       class="form-control"
                                       name="facultyDescription"
                                       placeholder="${descriptionTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${budjetTxt}</label>
                                <p id="input-budjetCount" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateUnsignedNotZero"
                                       data-error-area-id="input-budjetCount"
                                       data-error-message="${incorrectDataTxt}"
                                       type="number"
                                       class="form-control"
                                       name="budjetCount"
                                       placeholder="${budjetTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${paidTxt}</label>
                                <p id="input-paidCount" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateUnsignedNotZero"
                                       data-error-area-id="input-paidCount"
                                       data-error-message="${incorrectDataTxt}"
                                       type="number"
                                       class="form-control"
                                       name="paidCount"
                                       placeholder="${paidTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${finishDateTxt}</label>
                                <p id="input-finishDate" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateDate"
                                       data-error-area-id="input-finishDate"
                                       data-error-message="${incorrectDataTxt}"
                                       type="date"
                                       class="form-control"
                                       name="finishDate"
                                       placeholder="${finishDateTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${subjectsTxt}</label>
                                <p id="input-idSubject" class="error display-none"></p>
                                <c:forEach var="subject" items="${subjects}">
                                    <br/>
                                    <label for="privileges">
                                        <input data-validation="true"
                                               data-type-validation="validateCount"
                                               data-error-area-id="input-idSubject"
                                               data-error-message="${incorrectDataTxt}"
                                               id="privileges"
                                               type="checkbox"
                                               name="idSubject"
                                               value="${subject.subjectId}">
                                            ${subject.name}
                                    </label>
                                </c:forEach>
                            </div>

                            <div class="form-group col-md-12">
                                <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                    <i class="fa fa-check" aria-hidden="true"></i>${addTxt}
                                </button>
                            </div>
                        </div>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</main>

<%@include file="/pages/partial/footer.jsp" %>

