<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07.04.2018
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.enter" var="enterLabel"/>
<fmt:message key="error.no_such_name" var="noSuchNameTxt"/>

<fmt:message key="error.incorrect_password" var="incorrectPassTxt"/>
<fmt:message key="error.incorrect_login" var="incorrectLoginTxt"/>

<fmt:message key="error.wrong_password" var="wrongPassTxt"/>
<fmt:message key="error.wrongLoginOrPassword" var="wrongPassOrLoginTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>
<fmt:message key="error.blocked_user" var="blockedTxt"/>

<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.password" var="passwordTxt"/>
<fmt:message key="label.sign_in" var="singInTxt"/>
<fmt:message key="label.sign_up" var="singUpTxt"/>
<fmt:message key="label.home" var="homeTxt"/>


<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${singInTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${singInTxt}</li>
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
                        <h2><c:out value="${enterLabel}"/></h2>
                    </div>

                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post">
                        <input type="hidden" name="command" value="SIGN_IN"/>

                        <c:choose>
                            <c:when test="${requestScope.containsKey('incorrectData')}">
                                ${wrongPassOrLoginTxt}
                                ${makeSureTxt}
                            </c:when>
                            <c:when test="${requestScope.containsKey('noSuchName')}">
                                ${noSuchNameTxt}
                                ${makeSureTxt}
                            </c:when>
                            <c:when test="${requestScope.containsKey('wrongPassword')}">
                                ${wrongPassTxt}
                                ${makeSureTxt}
                            </c:when>
                            <c:when test="${requestScope.containsKey('blockedUser')}">
                                ${blockedTxt}
                            </c:when>
                        </c:choose>

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
                                       data-error-message="${incorrectPassTxt}"
                                       type="password"
                                       class="form-control"
                                       name="password"
                                       placeholder="${passwordTxt}">
                            </div>

                            <div class="form-group col-md-12">
                                <button type="submit" class="button  btn_blue mt40 upper pull-right">
                                    <i class="fa fa-sign-in" aria-hidden="true"></i>${singInTxt}
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
