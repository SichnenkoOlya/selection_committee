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

<div class="page_title gradient_overlay" style="background: url(images/page_title_bg.jpg);">
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


                <c:if test="${requestScope.containsKey('wrongData')}">
                    <%--${wrongPassOrLoginTxt}--%>
                </c:if>

                <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController" method="post"
                      name="enrollee-fill">
                    <input type="hidden" name="command" value="CHANGE_PASSWORD"/>

                    <div class="row">
                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${oldPasswordTxt}</label>
                            <input type="password" class="form-control" name="oldPassword"
                                   placeholder="${oldPasswordTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${passwordTxt}</label>
                            <input type="password" class="form-control" name="newPassword" placeholder="${passwordTxt}">
                        </div>

                        <div class="form-group col-md-12 col-sm-12">
                            <label class="control-label">${confirmPasswordTxt}</label>
                            <input type="password" class="form-control" name="confirmPassword"
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
