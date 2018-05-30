<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 16.04.2018
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.new_password" var="passwordTxt"/>
<fmt:message key="label.old_password" var="oldPasswordTxt"/>
<fmt:message key="label.confirm_password" var="confirmPasswordTxt"/>
<fmt:message key="label.change_password" var="changePasswordTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.incorrect_password" var="incorrectPasswordTxt"/>
<fmt:message key="error.incorrect_confirm_password" var="incorrectConfirmPassTxt"/>
<fmt:message key="error.such_name_exist" var="suchNameExistTxt"/>
<fmt:message key="error.incorrect_old_password" var="incorrectOldPassTxt"/>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${changePasswordTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${changePasswordTxt}</li>
            </ol>
        </div>
    </div>
</div>

<main>
    <div class="container">

        <div class="row">
            <div class="col-md-6">

                <div class="main_title a_left">
                    <h2><c:out value="${changePasswordTxt}"/></h2>
                </div>

                <c:choose>
                    <c:when test="${requestScope.containsKey('incorrectData')}">
                        ${incorrectDataTxt}
                        ${makeSureTxt}
                    </c:when>
                    <c:when test="${requestScope.containsKey('incorrectPassword')}">
                        ${incorrectPasswordTxt}
                    </c:when>
                    <c:when test="${requestScope.containsKey('incorrectConfirmPassword')}">
                        ${incorrectConfirmPassTxt}
                    </c:when>
                    <c:when test="${requestScope.containsKey('incorrectOldPassword')}">
                        ${incorrectOldPassTxt}
                    </c:when>
                </c:choose>

                <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController" method="post"
                      name="enrollee-fill">
                    <input type="hidden" name="command" value="CHANGE_PASSWORD"/>

                    <div class="row">
                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${oldPasswordTxt}</label>
                            <p id="input-oldPassword" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validatePassword"
                                   data-error-area-id="input-oldPassword"
                                   data-error-message="${incorrectPasswordTxt}"
                                   type="password"
                                   class="form-control"
                                   name="oldPassword"
                                   placeholder="${oldPasswordTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${passwordTxt}</label>
                            <p id="input-newPassword" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validatePassword"
                                   data-error-area-id="input-newPassword"
                                   data-error-message="${incorrectPasswordTxt}"
                                   type="password"
                                   class="form-control"
                                   name="newPassword"
                                   placeholder="${passwordTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${confirmPasswordTxt}</label>
                            <p id="input-confirmPassword" class="error display-none"></p>
                            <input data-validation="true"
                                   data-type-validation="validatePassword"
                                   data-error-area-id="input-confirmPassword"
                                   data-error-message="${incorrectPasswordTxt}"
                                   type="password"
                                   class="form-control"
                                   name="confirmPassword"
                                   placeholder="${confirmPasswordTxt}">
                        </div>

                        <div class="form-group col-md-12">
                            <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                <i class="fa fa-check" aria-hidden="true"></i>${changePasswordTxt}
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
<%@include file="/pages/partial/footer.jsp" %>
