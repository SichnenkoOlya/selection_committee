<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 21.04.2018
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.edit_user_profile" var="editProfileTxt"/>
<fmt:message key="label.save" var="saveTxt"/>
<fmt:message key="label.email" var="emailTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="error.incorrect_password" var="incorrectPasswordTxt"/>
<fmt:message key="error.wrong_password" var="wrongPasswordTxt"/>
<fmt:message key="error.incorrect_login" var="incorrectLoginTxt"/>
<fmt:message key="error.incorrect_email" var="incorrectEmailTxt"/>
<fmt:message key="error.incorrect_confirm_password" var="incorrectConfirmPassTxt"/>
<fmt:message key="error.such_name_exist" var="suchNameExistTxt"/>
<fmt:message key="label.password" var="passwordTxt"/>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${editProfileTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${editProfileTxt}</li>
            </ol>
        </div>
    </div>
</div>

<main>
    <c:if test="${empty sessionScope.userName }">
        <div class="container">
            <div class="row">
                <div class="col-md-6">

                    <div class="main_title a_left">
                        <h2><c:out value="${editProfileTxt}"/></h2>
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
                        <c:when test="${requestScope.containsKey('incorrectPassword')}">
                            ${wrongPasswordTxt}
                            ${makeSureTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('incorrectEmail')}">
                            ${incorrectEmailTxt}
                            ${makeSureTxt}
                        </c:when>
                        <c:when test="${requestScope.containsKey('suchNameExist')}">
                            ${suchNameExistTxt}
                        </c:when>
                    </c:choose>

                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post"
                          name="enrollee-fill">
                        <input type="hidden" name="command" value="EDIT_USER_PROFILE"/>
                        <input type="hidden" name="login" value="${user.login}"/>

                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12">
                                <label for="loginInput" class="control-label">${loginTxt}</label>
                                <p id="input-newLogin" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateLogin"
                                       data-error-area-id="input-newLogin"
                                       data-error-message="${incorrectLoginTxt}"
                                       id="loginInput"
                                       type="text"
                                       class="form-control"
                                       name="newLogin"
                                       value="${user.login}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label for="emailInput" class="control-label">${emailTxt}</label>
                                <p id="input-email" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateEmail"
                                       data-error-area-id="input-email"
                                       data-error-message="${incorrectEmailTxt}"
                                       id="emailInput"
                                       type="email"
                                       class="form-control"
                                       name="email"
                                       value="${user.email}">
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

                            <div class="form-group col-md-12">
                                <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                    <i class="fa fa-check" aria-hidden="true"></i>${saveTxt}
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </c:if>
</main>

<%@include file="/pages/partial/footer.jsp" %>