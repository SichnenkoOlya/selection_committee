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


<div class="page_title gradient_overlay" style="background: url(images/page_title_bg.jpg);">
    <div class="container">
        <div class="inner">
            <h1>${addCityTxt}</h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/mainController">Home</a></li>
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

                    <c:if test="${requestScope.containsKey('wrongData')}">
                        ${wrongPassOrLoginTxt}
                    </c:if>

                    <form id="contact-form-page" action="${pageContext.request.contextPath}/mainController"
                          method="post">
                        <input type="hidden" name="command" value="ADD_CITY"/>

                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12">
                                <label class="control-label">${cityNameTxt}</label>
                                <input type="text" class="form-control" name="cityName" placeholder="${cityNameTxt}">
                            </div>

                            <div class="form-group col-md-12 col-sm-12">
                                <label for="countries" class="control-label">${countryTxt}</label>
                                <select id="countries" name="country" class="form-control" required>
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