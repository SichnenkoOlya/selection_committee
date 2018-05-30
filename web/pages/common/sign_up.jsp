<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="error.wrongLoginOrPassword" var="wrongPassOrLoginTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.password" var="passwordTxt"/>
<fmt:message key="label.sign_in" var="singInTxt"/>
<fmt:message key="label.registration" var="registrationTxt"/>
<fmt:message key="label.sign_up" var="signUpTxt"/>
<fmt:message key="label.confirm_password" var="confirmPasswordTxt"/>
<fmt:message key="label.email" var="emailTxt"/>
<fmt:message key="label.sign_up" var="signUpTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.incorrect_password" var="incorrectPasswordTxt"/>
<fmt:message key="error.incorrect_login" var="incorrectLoginTxt"/>
<fmt:message key="error.incorrect_email" var="incorrectEmailTxt"/>
<fmt:message key="error.incorrect_confirm_password" var="incorrectConfirmPassTxt"/>
<fmt:message key="error.such_name_exist" var="suchNameExistTxt"/>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${signUpTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${signUpTxt}</li>
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
                        <h2>
                            <c:out value="${registrationTxt}"/>
                        </h2>
                    </div>
                    <c:choose>
                        <c:when test="${requestScope.containsKey('incorrectData')}">
                            ${incorrectDataTxt}
                            ${makeSureTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('incorrectLogin')}">
                            ${incorrectLoginTxt}
                            ${makeSureTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('incorrectEmail')}">
                            ${incorrectEmailTxt}
                            ${makeSureTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('incorrectPassword')}">
                            ${incorrectPasswordTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('incorrectConfirmPassword')}">
                            ${incorrectConfirmPassTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('suchNameExist')}">
                            ${suchNameExistTxt}
                        </c:when>
                    </c:choose>

                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post">
                        <input type="hidden" name="command" value="SIGN_UP"/>

                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${loginTxt}</label>
                                <p id="input-login" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateLogin"
                                       data-error-area-id="input-login"
                                       data-error-message="${incorrectLoginTxt}"
                                       type="text"
                                       class="form-control"
                                       name="login"
                                       placeholder="${loginTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${passwordTxt}</label>
                                <p id="input-password" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validatePassword"
                                       data-error-area-id="input-password"
                                       data-error-message="${incorrectPasswordTxt}"
                                       type="password"
                                       class="form-control"
                                       name="password"
                                       placeholder="${passwordTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${confirmPasswordTxt}</label>
                                <p id="input-confirm-password" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validatePassword"
                                       data-error-area-id="input-confirm-password"
                                       data-error-message="${incorrectPasswordTxt}"
                                       type="password" class="form-control" name="confirmPassword"
                                       placeholder="${confirmPasswordTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${emailTxt}</label>
                                <p id="input-email" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateEmail"
                                       data-error-area-id="input-email"
                                       data-error-message="${incorrectEmailTxt}"
                                       type="email"
                                       class="form-control"
                                       name="email"
                                       placeholder="${emailTxt}">
                            </div>

                            <div class="form-group col-md-12">
                                <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                    <i class="fa fa-sign-in" aria-hidden="true"></i>${signUpTxt}
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

