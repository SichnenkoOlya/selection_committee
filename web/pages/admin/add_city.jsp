<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18.04.2018
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/pages/partial/header.jsp" %>
<fmt:message key="label.add_city" var="addCityTxt"/>
<fmt:message key="label.city_name" var="cityNameTxt"/>
<fmt:message key="label.add" var="addTxt"/>
<fmt:message key="label.country" var="countryTxt"/>
<fmt:message key="label.home" var="homeTxt"/>
<fmt:message key="error.incorrect_data" var="incorrectDataTxt"/>
<fmt:message key="error.make_sure" var="makeSureTxt"/>
<fmt:message key="error.such_city_exist" var="suchCityExistTxt"/>

<div class="page_title gradient_overlay" style="background: url(/images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${addCityTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">${homeTxt}</a></li>
                <li>${addCityTxt}</li>
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
                        <h2><c:out value="${addCityTxt}"/></h2>
                    </div>


                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post">
                        <input type="hidden" name="command" value="ADD_CITY"/>

                        <c:if test="${requestScope.containsKey('incorrectData')}">
                            ${incorrectDataTxt}
                            ${makeSureTxt}
                        </c:if>
                        <c:if test="${requestScope.containsKey('suchCityExist')}">
                            ${suchCityExistTxt}
                        </c:if>

                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${cityNameTxt}</label>
                                <p id="input-cityName" class="error display-none"></p>
                                <input data-validation="true"
                                       data-type-validation="validateEmpty"
                                       data-error-area-id="input-cityName"
                                       data-error-message="${incorrectDataTxt}"
                                       type="text"
                                       class="form-control"
                                       name="cityName"
                                       placeholder="${cityNameTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label for="countries-add-city" class="control-label">${countryTxt}</label>
                                <p id="input-countryId" class="error display-none"></p>
                                <select data-validation="true"
                                        data-type-validation="validateEmpty"
                                        data-error-area-id="input-countryId"
                                        data-error-message="${incorrectDataTxt}"
                                        id="countries-add-city"
                                        name="countryId"
                                        class="form-control">
                                    <option></option>
                                    <c:forEach var="country" items="${countries}">
                                        <option value="${country.countryId}">${country.name}</option>
                                    </c:forEach>
                                </select>
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