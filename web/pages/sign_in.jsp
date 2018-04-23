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
<fmt:message key="error.wrongLoginOrPassword" var="wrongPassOrLoginTxt"/>
<fmt:message key="label.login" var="loginTxt"/>
<fmt:message key="label.password" var="passwordTxt"/>
<fmt:message key="label.sign_in" var="singInTxt"/>
<fmt:message key="label.sign_up" var="singUpTxt"/>

<div class="page_title gradient_overlay" style="background: url(images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>Sign In</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">Home</a></li>
                <li>Sign In</li>
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

                    <c:if test="${requestScope.containsKey('wrongData')}">
                        ${wrongPassOrLoginTxt}
                    </c:if>

                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post">
                        <input type="hidden" name="command" value="SIGN_IN"/>

                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${loginTxt}</label>
                                <input type="text" class="form-control" name="login" placeholder="${loginTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${passwordTxt}</label>
                                <input type="password" class="form-control" name="password"
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
